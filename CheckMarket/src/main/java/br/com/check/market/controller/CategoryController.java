package br.com.check.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.check.market.model.Category;
import br.com.check.market.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("/")
	public Category create(@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/")
	public List<Category> getAllCategorys() {
		return categoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
		Category category = categoryRepository.findOne(categoryId);
		if (category == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(category);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long categoryId) {
		Category category = categoryRepository.findOne(categoryId);
		if (category == null) {
			return ResponseEntity.notFound().build();
		}

		categoryRepository.delete(category);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId,
			@Valid @RequestBody Category categoryDetails) {
		Category category = categoryRepository.findOne(categoryId);
		if (category == null) {
			return ResponseEntity.notFound().build();
		}

		category.setDescription(categoryDetails.getDescription());
		category.setStatus(categoryDetails.isStatus());

		Category updatedCategory = categoryRepository.save(category);
		return ResponseEntity.ok(updatedCategory);
	}
}