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

import br.com.check.market.model.User;
import br.com.check.market.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users/new")
	public User create(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getNoteById(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteNote(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateNote(@PathVariable(value = "id") Long noteId,
			@Valid @RequestBody User userDetails) {
		User user = userRepository.findOne(noteId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

}