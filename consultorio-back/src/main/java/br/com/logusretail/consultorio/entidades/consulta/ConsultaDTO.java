package br.com.logusretail.consultorio.entidades.consulta;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.logusretail.consultorio.entidades.medico.MedicoDTO;
import br.com.logusretail.consultorio.utils.parsers.ValidaConsulta;

@ValidaConsulta(message = "Verifique se a especialidade é cirurgia, ou se médicos está nulo!")
public class ConsultaDTO {
	public Long id;
	@NotNull(message = "O paciente não pode ser nulo!")
	@NotBlank(message = "O nome do paciente não pode ser nulo!")
	public String nomePaciente;
	@NotNull(message = "É necessário haver no mínimo um médico ao cadastrar a consulta")
	public List<MedicoDTO> medicos;
	@NotNull(message = "Favor, informe uma data válida")
	public LocalDateTime data;
	@NotNull(message = "É necessário informar o número do consultório")
	public Integer numeroConsultorio;
	@NotNull(message = "É necessário informar a especialidade")
	@NotEmpty(message = "É necessário informar a especialidade")
	public String especialidade;
}
