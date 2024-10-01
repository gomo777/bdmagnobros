package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.demo.entities.magno;
import com.example.demo.repository.magnoRepository;

@Service
public class magnoService {
	private final magnoRepository magnoRepository;

	@Autowired
	public magnoService(magnoRepository magnoRepository) {
		this.magnoRepository = magnoRepository;
	}

	// salvando o Jogo
	public magno Savemagno(magno Magno) {
		return magnoRepository.save(Magno);
	}

	// preparando as buscas por id
	public magno getmagnoById(Long id) {
		return magnoRepository.findById(id).orElse(null);
	}

	// preparando a busca geral
	public List<magno> getAllmagno() {
		// TODO Auto-generated method stub
		return magnoRepository.findAll();
	}

	// excluindo o Jogo
	public void deletemagno(Long id) {
		magnoRepository.deleteById(id);
	}

	// salvando o magno
	public magno insertmagno(magno magno) {
		return magnoRepository.save(magno);
	}

	// fazendo o update do jogo com o optional
	public magno updateMagno(Long clicodigo, magno novoMagno) {
		Optional<magno> magnoOptional = magnoRepository.findById(clicodigo);
		if (magnoOptional.isPresent()) {
			magno magnoExistente = magnoOptional.get();
			magnoExistente.setClinome(novoMagno.getClinome());
			magnoExistente.setCliemail(novoMagno.getCliemail());
			magnoExistente.setClimensagem(novoMagno.getClimensagem());
			return magnoRepository.save(magnoExistente);
		} else {
			return null;
		}
	}

}
