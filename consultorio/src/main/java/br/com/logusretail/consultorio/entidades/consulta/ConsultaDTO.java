package br.com.logusretail.consultorio.entidades.consulta;

import java.time.LocalDateTime;
import java.util.List;

import br.com.logusretail.consultorio.entidades.medico.MedicoDTO;

public class ConsultaDTO {
	public Long id;
	public String nomePaciente;
	public List<MedicoDTO> medicos;
	public LocalDateTime data;
	public Integer numeroConsultorio;
	public String especialidade;
}
