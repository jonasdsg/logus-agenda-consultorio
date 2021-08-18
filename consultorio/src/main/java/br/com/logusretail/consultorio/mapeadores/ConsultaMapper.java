package br.com.logusretail.consultorio.mapeadores;

import static java.util.stream.Collectors.toList;

import java.util.List;

import br.com.logusretail.consultorio.dto.ConsultaDTO;
import br.com.logusretail.consultorio.entidades.Consulta;

public class ConsultaMapper implements Mapeador<ConsultaDTO, Consulta> {
	private MedicoMapper medicoMapper = new MedicoMapper();

	@Override
	public ConsultaDTO toDTO(Consulta model) {
		ConsultaDTO dto = new ConsultaDTO();
		dto.id = model.getId();
		dto.data = model.getData();
		dto.medicos = medicoMapper.toListDTO(model.getMedicos());
		dto.nomePaciente = model.getNomePaciente();
		dto.numeroConsultorio = model.getNumeroConsultorio();

		return dto;
	}

	@Override
	public Consulta toModel(ConsultaDTO dto) {
		// TODO Auto-generated method stub
		return null;
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
