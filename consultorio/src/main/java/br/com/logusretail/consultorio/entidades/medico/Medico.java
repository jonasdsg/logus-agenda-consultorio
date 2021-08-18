package br.com.logusretail.consultorio.entidades.medico;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.logusretail.consultorio.entidades.consulta.Consulta;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String nome;
	private String crm;
	private LocalDate nascimento;
	@ManyToOne(fetch = LAZY)
	private Consulta consulta;
	
	@Deprecated
	public Medico() {} //Construtor JPA
	
	public Medico(Long id, String nome, String crm, LocalDate nascimento, Consulta consulta) {
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.nascimento = nascimento;
		this.consulta = consulta;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCrm() {
		return crm;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}
	
	
	
}
