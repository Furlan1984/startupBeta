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

import br.com.check.market.model.Establishment;
import br.com.check.market.repository.EstablishmentRepository;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

	@Autowired
	EstablishmentRepository establishmentRepository;

	@PostMapping("/new")
	public Establishment create(@Valid @RequestBody Establishment establishment) {
		return establishmentRepository.save(establishment);
	}

	@GetMapping("/establishments")
	public List<Establishment> getAllEstablishments() {
		return establishmentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Establishment> getEstablishmentById(@PathVariable(value = "id") Long establishmentId) {
		Establishment establishment = establishmentRepository.findOne(establishmentId);
		if (establishment == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(establishment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Establishment> deleteEstablishment(@PathVariable(value = "id") Long establishmentId) {
		Establishment establishment = establishmentRepository.findOne(establishmentId);
		if (establishment == null) {
			return ResponseEntity.notFound().build();
		}

		establishmentRepository.delete(establishment);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Establishment> updateEstablishment(@PathVariable(value = "id") Long establishmentId,
			@Valid @RequestBody Establishment establishmentDetails) {
		Establishment establishment = establishmentRepository.findOne(establishmentId);
		if (establishment == null) {
			return ResponseEntity.notFound().build();
		}

		Establishment updatedEstablishment = establishmentRepository.save(establishment);
		return ResponseEntity.ok(updatedEstablishment);
	}

}