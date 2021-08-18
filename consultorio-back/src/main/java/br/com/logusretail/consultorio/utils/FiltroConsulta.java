package br.com.logusretail.consultorio.utils;

public class FiltroConsulta {
	private String nomePaciente;
	private String data;
	private String especialidade;
	private String crm;
	private Integer numeroConsultorio;
	
	private FiltroConsulta() {}
	
	public static FiltroConsulta get() {
		return new FiltroConsulta();
	}
	
	public FiltroConsulta porNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
		return this;
	}

	public FiltroConsulta porData(String data) {
		this.data = data;
		return this;
	}

	public FiltroConsulta porEspecialidade(String especialidade) {
		this.especialidade = especialidade;
		return this;
	}

	public FiltroConsulta porEspecialidade(Integer numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
		return this;
	}

	
	public FiltroConsulta porCrm(String crm) {
		this.crm = crm;
		return this;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getData() {
		return data;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public Integer geNumeroConsultorio() {
		return this.numeroConsultorio;
	}

}
