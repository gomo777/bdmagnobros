package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_magno")
public class magno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long clicodigo;

	private String clinome;
	
	private String cliemail;
	
	private String climensagem;

	public Long getClicodigo() {
		return clicodigo;
	}

	public void setClicodigo(Long clicodigo) {
		this.clicodigo = clicodigo;
	}

	public String getClinome() {
		return clinome;
	}

	public void setClinome(String clinome) {
		this.clinome = clinome;
	}

	public String getCliemail() {
		return cliemail;
	}

	public void setCliemail(String cliemail) {
		this.cliemail = cliemail;
	}

	public String getClimensagem() {
		return climensagem;
	}

	public void setClimensagem(String climensagem) {
		this.climensagem = climensagem;
	}
	
	
	public magno() {

	}

	public magno(Long clicodigo, String clinome, String cliemail, String climensagem) {
		super();
		this.clicodigo = clicodigo;
		this.clinome = clinome;
		this.cliemail = cliemail;
		this.climensagem = climensagem;
	}
	
	
	

	
	

}
