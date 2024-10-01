package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.magno;
import com.example.demo.service.magnoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/magno")
public class magnoController {
	private final magnoService magnoService;

	@Autowired
	public magnoController(magnoService magnoService) {
		this.magnoService = magnoService;
	}
	/*
	 * @PostMapping("/create") public magno createmagno(@RequestParam String
	 * clinome, @RequestParam String cliemail,
	 * 
	 * @RequestParam String climensagem) throws IOException { magno magno = new
	 * magno(); magno.setClinome(clinome); magno.setCliemail(cliemail);
	 * magno.setClimensagem(climensagem); return magnoService.Savemagno(magno); }
	 */

	@PostMapping("/create")
	public ResponseEntity<magno> createmagno(@RequestBody magno magnocreated) {
	    try {
	        magno novomagno = magnoService.Savemagno(magnocreated);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novomagno);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

	@PostMapping
	public ResponseEntity<magno> insertmagnoControl(@RequestBody @Validated magno magno) {
		magno novomagno = magnoService.insertmagno(magno);
		return ResponseEntity.status(HttpStatus.CREATED).body(novomagno);
	}

	@PutMapping("/{clicodigo}")
	public ResponseEntity<magno> updatemagnoControl(@PathVariable Long clicodigo, @RequestBody @Validated magno magno) {
		magno mudamagno = magnoService.updateMagno(clicodigo, magno);
		if (mudamagno != null) {
			return ResponseEntity.ok(magno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<magno> getAllmagno() {
		return magnoService.getAllmagno();
	}

	@GetMapping("/{id}")
	public ResponseEntity<magno> getMagno(@PathVariable Long clicodigo) {
		magno magno = magnoService.getmagnoById(clicodigo);
		if (magno != null) {
			return ResponseEntity.ok(magno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deletemagno(@PathVariable Long id) {
		magnoService.deletemagno(id);
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // nome do seu arquivo HTML , (sem a extensão)
	}

}
