package br.com.logusretail.consultorio.controladores;

import java.util.List;

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

import br.com.logusretail.consultorio.entidades.medico.MedicoDTO;
import br.com.logusretail.consultorio.servicos.MedicoServico;

@CrossOrigin
@RestController
@RequestMapping("medico")
public class MedicoController {
	@Autowired
	private MedicoServico medicoServico;

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> get() {
		return ResponseEntity.ok(medicoServico.buscarTodos());
	}

	@GetMapping("/{crm}")
	public ResponseEntity<List<MedicoDTO>> find(@PathVariable String crm) {
		return ResponseEntity.ok(medicoServico.buscarPorNome(crm));
	}

	@PostMapping
	public ResponseEntity<MedicoDTO> set(@RequestBody MedicoDTO dto) {
		return ResponseEntity.ok(medicoServico.salvar(dto));
	}

	@DeleteMapping
	public ResponseEntity<?> drop(@RequestBody MedicoDTO dto) {
		medicoServico.remover(dto);
		return ResponseEntity.ok().build();
	}
}
