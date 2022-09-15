package br.financas.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.fatec.financas.repository.PessoaJuridicaRepository;
import br.financas.fatec.model.PessoaJuridica;

public class PessoaJuridicaService implements PessoaInterface<PessoaJuridica>{
	@Autowired
	private PessoaJuridicaRepository repository;
	
	public PessoaJuridicaService() {
		
	}
	@Override
	public PessoaJuridica create(PessoaJuridica pessoaJuridica) {
		repository.save(pessoaJuridica);
		return pessoaJuridica;
	}
	@Override
	public List<PessoaJuridica> findAll(){
		return repository.findAll();
	}
	
	public PessoaJuridica findById(Long id) {
		Optional<PessoaJuridica> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	@Override
	public boolean update(PessoaJuridica pessoaFisica) {
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
