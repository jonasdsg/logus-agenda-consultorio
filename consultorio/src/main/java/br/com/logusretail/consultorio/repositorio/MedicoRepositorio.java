package br.com.logusretail.consultorio.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.logusretail.consultorio.entidades.medico.Medico;

@Repository
public interface MedicoRepositorio extends CrudRepository<Medico, Long> {

	public Medico findByCrm(String crm);

	public List<Medico> findByNome(String nome);
}
