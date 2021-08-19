package br.com.logusretail.consultorio.servicos;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logusretail.consultorio.entidades.consulta.Consulta;
import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.repositorio.ConsultaRepositorio;
import br.com.logusretail.consultorio.repositorio.MedicoRepositorio;

@Service
public class ValidacaoService {
	private static final int TOTAL_CONSULTAS_POR_DIA = 12;
	private static final int TOTAL_CONSULTAS_MESMA_SALA = 2;
	private static final int TOTAL_CONSULTAS_MESMA_HORARIO = 1;
	private static final int TOTAL_MEDICOS_POR_CONSULTA = 2;
	private MedicoRepositorio medicoRepositorio;
	private ConsultaRepositorio consultaRepositorio;
	

	@Autowired
	public ValidacaoService(MedicoRepositorio medicoRepositorio, ConsultaRepositorio consultaRepositorio) {
		this.medicoRepositorio = medicoRepositorio;
		this.consultaRepositorio = consultaRepositorio;
	}

	public Boolean validarConsulta(ConsultaDTO dto) {
		if(nonNull(dto) && nonNull(dto.medicos)) {
			List<Consulta> consultas = consultaRepositorio.findConsultasNoMesmoConsultorioMesmoDia(dto.numeroConsultorio,dto.data.toLocalDate());
			Boolean dentroDoLimiteDiario = verificaConsultasPorDia(consultas);
			Boolean dentroDoLimiteDeConsultasPorConsultorio = verificaQuantidadeConsultaPorConsultorio(consultas,dto);
			Boolean dentroDoLimiteDeConsultasNoMesmoHorario = verificaQuantidadeConsultaNoMesmoHorario(consultas, dto.data);
			Boolean dentroDoLimiteDeMedicosPorConsulta = dto.medicos.size() <= TOTAL_MEDICOS_POR_CONSULTA;
			Boolean existeMedicosCadastrados = false;
			
			if(dentroDoLimiteDeMedicosPorConsulta) {
				int medicosNaConsulta = dto.medicos.size();
				String crmMedico1 = dto.medicos.get(0).crm;
				
				if(medicosNaConsulta == 1) {
					existeMedicosCadastrados = medicoRepositorio.findByCrm(crmMedico1) != null;
				}
				if(medicosNaConsulta == 2) {
					String crmMedico2 = dto.medicos.get(1).crm;
					existeMedicosCadastrados = medicoRepositorio.findMedicosPorCRM(crmMedico1, crmMedico2).size() == 2;
				}
			}
			
			return  dentroDoLimiteDiario && existeMedicosCadastrados
						&& dentroDoLimiteDeConsultasPorConsultorio 
						&& dentroDoLimiteDeConsultasNoMesmoHorario 
						&& dentroDoLimiteDeMedicosPorConsulta ;			
		}
		return false;
	}

	private Boolean verificaQuantidadeConsultaNoMesmoHorario(List<Consulta> consultas,LocalDateTime data) {
		if(nonNull(data)) {			
			return consultas.stream().filter(c -> {
				return c.getData().getHour() == data.getHour() 
						&& c.getData().getMinute() == data.getMinute();
			}).collect(toList()).size()<=TOTAL_CONSULTAS_MESMA_HORARIO;
		}
		return false;
	}

	private Boolean verificaQuantidadeConsultaPorConsultorio(List<Consulta> consultas, ConsultaDTO dto) {
		if (!verificaConsultasPorDia(consultas)) {
			return verificaTotalConsultasMesmaSala(consultas, dto.numeroConsultorio);
		}
		return false;
	}

	private Boolean verificaTotalConsultasMesmaSala(List<Consulta> consultas, int numeroConsultorio) {
		if(nonNull(consultas)) {
			return consultas.stream().filter(c -> c.getNumeroConsultorio() == numeroConsultorio)
					.collect(toList()).size()<=TOTAL_CONSULTAS_MESMA_SALA;			
		}
		return false;
	}

	private Boolean verificaConsultasPorDia(List<Consulta> consultas) {
		return nonNull(consultas) ? consultas.size() >= TOTAL_CONSULTAS_POR_DIA : false;
	}

}
