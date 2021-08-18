package br.com.logusretail.consultorio.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultaDTO {
	public Long id;
	public String nomePaciente;
	public List<MedicoDTO> medicos;
	public LocalDateTime data;
	public Integer numeroConsultorio;
}
