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

import br.financas.fatec.model.PessoaFisica;
import br.financas.fatec.service.PessoaFisicaService;

@RestController
@RequestMapping("/contatos")
public class PessoaFisicaController implements ControllerInterface<PessoaFisica>{

	@Autowired
	private PessoaFisicaService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<PessoaFisica>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		PessoaFisica _pessoaFisica = service.findById(id);
		if (_pessoaFisica != null) {
			return ResponseEntity.ok(_pessoaFisica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	@Override
	@PostMapping
	public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica pessoaFisica) {
		service.create(pessoaFisica);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaFisica.getId())
				.toUri();
		return ResponseEntity.created(location).body(pessoaFisica);
	}

	@PutMapping
	public ResponseEntity<?> put(@RequestBody PessoaFisica pessoaFisica) {
		if (service.update(pessoaFisica)) {
			return ResponseEntity.ok(pessoaFisica);
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
