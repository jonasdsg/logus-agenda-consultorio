package br.com.logusretail.consultorio.servicos;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logusretail.consultorio.entidades.consulta.Consulta;
import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.entidades.medico.Especialidade;
import br.com.logusretail.consultorio.repositorio.ConsultaRepositorio;
import br.com.logusretail.consultorio.utils.mapeadores.ConsultaMapper;

@Service
public class ConsultorioServico {

	private final ConsultaRepositorio consultaRepositorio;
	private final ConsultaMapper mapper;

	@Autowired
	public ConsultorioServico(ConsultaRepositorio consultaRepositorio, ConsultaMapper mapper) {
		this.consultaRepositorio = consultaRepositorio;
		this.mapper = mapper;
	}

	public void agendarConsulta(ConsultaDTO consulta) {
		Consulta model = mapper.toModel(consulta);
		consultaRepositorio.save(model);
	}

	public List<ConsultaDTO> buscarConsultas() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		consultaRepositorio.findAll().forEach(c -> consultas.add(c));
		return mapper.toListDTO(consultas);
	}

	public List<ConsultaDTO> buscarPorFiltro(String crm, LocalDateTime data, String nomePaciente, String especialidade,
			Integer numeroConsultorio) {
		Boolean parametrosNulos = checarSeHaParametrosNulos(
				asList(crm, data, nomePaciente, Especialidade.getInstance(especialidade), numeroConsultorio));
		System.out.println(parametrosNulos);
		if (parametrosNulos) {
			return this.buscarConsultas();
		}

		return mapper.toListDTO(consultaRepositorio.findUsingFilter(crm, data, nomePaciente,
				Especialidade.getInstance(especialidade), numeroConsultorio));
	}

	public ConsultaDTO salvar(ConsultaDTO dto) {
		return mapper.toDTO(consultaRepositorio.save(mapper.toModel(dto)));
	}

	private Boolean checarSeHaParametrosNulos(List<Object> params) {
		Boolean b = params.stream().filter(o -> isNull(o)).collect(toList()).size() > 0;
		return b;
	}

	public ConsultaDTO remover(ConsultaDTO dto) {
		Consulta consulta = consultaRepositorio.findById(dto.id).get();
		if(consulta!=null) {
			consultaRepositorio.deleteById(consulta.getId());
		}
		return null;
	}

	public ConsultaDTO buscarPorId(Long id) {
		Consulta c = consultaRepositorio.findById(id).get();
		if(nonNull(c)) {
			return mapper.toDTO(c);
		}
		return null;
	}
}
