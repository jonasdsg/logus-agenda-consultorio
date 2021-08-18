package br.com.logusretail.consultorio.entidades;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "consulta", fetch = LAZY)
	private List<Medico> medicos;
	@Enumerated(STRING)
	private Especialidade especialidade;
	@Embedded
	private InformacaoConsulta informacaoConsulta;
	@Deprecated
	public Consulta() {} //Construtor JPA
	
	public Consulta(Long id, String nomePaciente, List<Medico> medicos, LocalDateTime data, Especialidade especialidade,
			Integer numeroConsultorio) {
		this.informacaoConsulta = new InformacaoConsulta(numeroConsultorio, nomePaciente, data);
		this.medicos = medicos;
		this.especialidade = especialidade;

	}

	public String getNomePaciente() {
		return informacaoConsulta.getNomePaciente();
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public LocalDateTime getData() {
		return informacaoConsulta.getData();
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public Integer getNumeroConsultorio() {
		return informacaoConsulta.getNumeroConsultorio();
	}
	
	public Long getId() {
		return id;
	}
}
