package br.com.logusretail.consultorio.utils.mapeadores;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logusretail.consultorio.entidades.consulta.Consulta;
import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.entidades.medico.Especialidade;

@Service
public class ConsultaMapper implements Mapeador<ConsultaDTO, Consulta> {
	@Autowired
	private MedicoMapper medicoMapper;

	@Override
	public ConsultaDTO toDTO(Consulta model) {
		ConsultaDTO dto = new ConsultaDTO();
		dto.id = model.getId();
		dto.data = model.getData();
		dto.medicos = medicoMapper.toListDTO(model.getMedicos());
		dto.nomePaciente = model.getNomePaciente();
		dto.numeroConsultorio = model.getNumeroConsultorio();
		dto.especialidade = model.getEspecialidade().getDescricao();
		
		return dto;
	}

	@Override
	public Consulta toModel(ConsultaDTO dto) {
		Consulta consulta = new Consulta(
					dto.id, dto.nomePaciente,
					medicoMapper.toListModel(dto.medicos), dto.data,
					Especialidade.getInstance(dto.especialidade), dto.numeroConsultorio);
		return consulta;
	}

	@Override
	public List<ConsultaDTO> toListDTO(List<Consulta> model) {
		return model.stream().map(c -> this.toDTO(c)).collect(toList());
	}

	@Override
	public List<Consulta> toListModel(List<ConsultaDTO> dto) {
		return dto.stream().map(c -> toModel(c)).collect(toList());
	}

}
