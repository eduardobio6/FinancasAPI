package br.financas.fatec.controller;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.financas.fatec.model.PessoaJuridica;
import br.financas.fatec.service.PessoaJuridicaService;

@RestController
@RequestMapping("/contatos")
public class PessoaJuridicaController implements ControllerInterface<PessoaJuridica>{

	@Autowired
	private PessoaJuridicaService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<PessoaJuridica>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		PessoaJuridica _pessoaJuridica = service.findById(id);
		if (_pessoaJuridica != null) {
			return ResponseEntity.ok(_pessoaJuridica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	@Override
	@PostMapping
	public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica pessoaJuridica) {
		service.create(pessoaJuridica);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaJuridica.getId())
				.toUri();
		return ResponseEntity.created(location).body(pessoaJuridica);
	}

	@PutMapping
	public ResponseEntity<?> put(@RequestBody PessoaJuridica pessoaJuridica) {
		if (service.update(pessoaJuridica)) {
			return ResponseEntity.ok(pessoaJuridica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/id")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
