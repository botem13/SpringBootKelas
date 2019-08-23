package com.bootcamp.kelas.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

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

import com.bootcamp.kelas.exception.ResourceNotFoundException;
import com.bootcamp.kelas.model.Murid;
import com.bootcamp.kelas.repository.MuridRepository;

@RestController
@RequestMapping("/api/v5")
public class MuridController {
	@Autowired
	private MuridRepository muridRepository;

	@GetMapping("/murid")
	public List<Murid> getAllMurid() {
		return muridRepository.findAll();
	}

	@GetMapping("/murid/{id}")
	public ResponseEntity<Murid> getMuridById(@PathVariable(value = "id") Long muridId)
			throws ResourceNotFoundException {
		Murid murid = muridRepository.findById(muridId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + muridId));
		return ResponseEntity.ok().body(murid);
	}

	@PostMapping("/murid")
	public Murid createMurid(@Valid @RequestBody Murid murid) {
		return muridRepository.save(murid);
	}

	@PutMapping("/murid/{id}")
	public ResponseEntity<Murid> updateMurid(@PathVariable(value = "id") Long muridId,
			@Valid @RequestBody Murid muridDetails) throws ResourceNotFoundException {
		Murid murid = muridRepository.findById(muridId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + muridId));

		murid.setNama(muridDetails.getNama());
		murid.setAlamat(muridDetails.getAlamat());
		final Murid updatedMurid = muridRepository.save(murid);
		return ResponseEntity.ok(updatedMurid);
	}

	@DeleteMapping("/murid/{id}")
	public Map<String, Boolean> deleteMurid(@PathVariable(value = "id") Long muridId)
			throws ResourceNotFoundException {
		Murid murid = muridRepository.findById(muridId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + muridId));

		muridRepository.delete(murid);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
