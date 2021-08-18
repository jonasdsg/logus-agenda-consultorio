package br.com.logusretail.consultorio.entidades.medico;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class MedicoDTO {
	public Long id;
	@NotNull
	@NotEmpty
	public String nome;
	@NotNull
	@NotEmpty
	public String crm;
	@NotNull
	public LocalDate nascimento;
}
