package br.com.logusretail.consultorio.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logusretail.consultorio.entidades.medico.Medico;
import br.com.logusretail.consultorio.entidades.medico.MedicoDTO;
import br.com.logusretail.consultorio.repositorio.MedicoRepositorio;
import br.com.logusretail.consultorio.utils.mapeadores.MedicoMapper;

@Service
public class MedicoServico {

	private MedicoRepositorio medicoRepositorio;
	private MedicoMapper medicoMapper;

	@Autowired
	public MedicoServico(MedicoRepositorio medicoRepositorio, MedicoMapper medicoMapper) {
		this.medicoRepositorio = medicoRepositorio;
		this.medicoMapper = medicoMapper;
	}

	public List<MedicoDTO> buscarTodos() {
		List<Medico> medicos = new ArrayList<Medico>();
		this.medicoRepositorio.findAll().forEach(m->medicos.add(m));
		return medicoMapper.toListDTO(medicos);
	}

	public MedicoDTO salvar(MedicoDTO dto) {
		return medicoMapper.toDTO(medicoRepositorio.save(medicoMapper.toModel(dto)));
	}

	public List<MedicoDTO> buscarPorNome(String crm) {
		return medicoMapper.toListDTO(medicoRepositorio.findByNome(crm));
	}

	public void remover(MedicoDTO dto) {
		medicoRepositorio.delete(medicoMapper.toModel(dto));;
	}
	
}
