package br.com.logusretail.consultorio.controladores;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.servicos.ConsultorioServico;
import br.com.logusretail.consultorio.utils.parsers.LocalDateTimeParse;

@CrossOrigin
@RestController
@RequestMapping("consulta")
public class ConsultaController {
	@Autowired
	private ConsultorioServico consultorioServico;
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaDTO> findById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(consultorioServico.buscarPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> find(
			@PathParam("crm") String crm,
			@PathParam("data") LocalDateTimeParse data, 
			@PathParam("nomePaciente") String nomePaciente,
			@PathParam("especialidade") String especialidade,
			@PathParam("numeroConsultorio") Integer numeroConsultorio) {

		return ResponseEntity.ok(consultorioServico.buscarPorFiltro(crm, data.getDate(), nomePaciente, especialidade,numeroConsultorio));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> save(
			@RequestBody @Valid ConsultaDTO dto){
		return ResponseEntity.ok(consultorioServico.salvar(dto));
	}
	
	@DeleteMapping
	public ResponseEntity<ConsultaDTO> drop(
			@RequestBody ConsultaDTO dto){
		return ResponseEntity.ok(consultorioServico.remover(dto));
	}
}
