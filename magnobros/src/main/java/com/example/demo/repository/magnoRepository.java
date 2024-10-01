package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.magno;
import com.example.demo.service.magnoService;

public interface magnoRepository extends JpaRepository<magno,Long> {

	

}
