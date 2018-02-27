package br.com.check.market.controller;

import java.math.BigDecimal;
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
import br.com.check.market.model.Iten;
import br.com.check.market.repository.ItenRepository;

@RestController
@RequestMapping("/iten")
public class ItenController {

	@Autowired
	ItenRepository itenRepository;

	@PostMapping("/iten/new")
	public Iten create(@Valid @RequestBody Iten iten) {
		iten.setValor(new BigDecimal("0.0"));
		return itenRepository.save(iten);
	}

	@GetMapping("/itens")
	public List<Iten> getAllItens() {
		return itenRepository.findAll();
	}

	@GetMapping("/iten/{id}")
	public ResponseEntity<Iten> getItenById(@PathVariable(value = "id") Long itenId) {
		Iten iten = itenRepository.findOne(itenId);
		if (iten == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(iten);
	}

	@DeleteMapping("/iten/{id}")
	public ResponseEntity<Iten> deleteIten(@PathVariable(value = "id") Long itenId) {
		Iten iten = itenRepository.findOne(itenId);
		if (iten == null) {
			return ResponseEntity.notFound().build();
		}

		itenRepository.delete(iten);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/iten/{id}")
	public ResponseEntity<Iten> updateIten(@PathVariable(value = "id") Long itenId,
			@Valid @RequestBody Category categoryDetails) {
		Iten iten = itenRepository.findOne(itenId);
		if (iten == null) {
			return ResponseEntity.notFound().build();
		}

		Iten updateIten = itenRepository.save(iten);
		return ResponseEntity.ok(updateIten);
	}

}
