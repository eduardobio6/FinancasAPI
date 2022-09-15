package br.financas.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.fatec.financas.repository.PessoaFisicaRepository;
import br.financas.fatec.model.PessoaFisica;

public class PessoaFisicaService implements PessoaInterface<PessoaFisica>{
	@Autowired
	private PessoaFisicaRepository repository;
	
	public PessoaFisicaService() {
		
	}
	@Override
	public PessoaFisica create(PessoaFisica pessoaFisica) {
		repository.save(pessoaFisica);
		return pessoaFisica;
	}
	@Override
	public List<PessoaFisica> findAll(){
		return repository.findAll();
	}
	
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	@Override
	public boolean update(PessoaFisica pessoaFisica) {
		if (repository.existsById(pessoaFisica.getId())) {
			repository.save(pessoaFisica);
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	/*@Override
	public PessoaFisica findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(PessoaFisica obj) {
		// TODO Auto-generated method stub
		return false;
	}*/}
