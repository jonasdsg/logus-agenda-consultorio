package br.com.logusretail.consultorio.repositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.logusretail.consultorio.entidades.consulta.Consulta;
import br.com.logusretail.consultorio.entidades.medico.Especialidade;

@Repository
public interface ConsultaRepositorio extends CrudRepository<Consulta, Long> {
	public List<Consulta> findByEspecialidade(String especialidade);

	@Query("SELECT c FROM Consulta c WHERE c.informacaoConsulta.nomePaciente = :paciente")
	public List<Consulta> findWithNomePaciente(String paciente);

	@Query("SELECT c FROM Consulta c WHERE c.informacaoConsulta.numeroConsultorio = :numero")
	public List<Consulta> findWithNumeroConsultorio(Integer numero);

	@Query("SELECT c FROM Consulta c LEFT JOIN c.medicos m WHERE 1=1"
			+ " AND c.informacaoConsulta.nomePaciente = :nomePaciente "
			+ " OR c.informacaoConsulta.numeroConsultorio = :numeroConsultorio "
			+ " OR c.especialidade =:especialidade "
			+ " OR c.informacaoConsulta.data = :data"
			+ " OR m.crm = :crm"
			+ " ORDER BY c.informacaoConsulta.data DESC")
	public List<Consulta> findUsingFilter(String crm, LocalDateTime data, String nomePaciente, Especialidade especialidade,Integer numeroConsultorio);

	@Query("SELECT c FROM Contulta c WHERE c.informacaoConsulta.numeroConsultorio =:numeroConsultorio AND c.informacaoConsulta.data =:data")
	public List<Consulta> findConsultasNoMesmoConsultorioMesmoDia(Integer numeroConsultorio,LocalDate data);

}
