package br.com.logusretail.consultorio.mapeadores;

import static java.util.stream.Collectors.toList;

import java.util.List;

import br.com.logusretail.consultorio.dto.MedicoDTO;
import br.com.logusretail.consultorio.entidades.Medico;

public class MedicoMapper implements Mapeador<MedicoDTO, Medico> {

	@Override
	public MedicoDTO toDTO(Medico model) {
		MedicoDTO dto = new MedicoDTO();
		dto.id = model.getId();
		dto.crm = model.getCrm();
		dto.nascimento = model.getNascimento();
		dto.nome = model.getNome();

		return dto;
	}

	@Override
	public Medico toModel(MedicoDTO dto) {
		Medico medico = new Medico(dto.id, dto.nome, dto.crm, dto.nascimento, null);
		return medico;
	}

	@Override
	public List<MedicoDTO> toListDTO(List<Medico> model) {
		return model.stream().map(c -> toDTO(c)).collect(toList());
	}

	@Override
	public List<Medico> toListModel(List<MedicoDTO> dto) {
		return dto.stream().map(m -> toModel(m)).collect(toList());
	}

}
