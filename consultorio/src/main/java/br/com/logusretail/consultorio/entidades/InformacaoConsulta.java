package br.com.logusretail.consultorio.entidades;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class InformacaoConsulta {
	private Integer numeroConsultorio;
	private String nomePaciente;
	private LocalDateTime data;
	
	public InformacaoConsulta(Integer numeroConsultorio, String nomePaciente, LocalDateTime data) {
		this.numeroConsultorio = numeroConsultorio;
		this.nomePaciente = nomePaciente;
		this.data = data;
	}
	
	public Integer getNumeroConsultorio() {
		return numeroConsultorio;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public LocalDateTime getData() {
		return data;
	}

}
