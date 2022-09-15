package br.financas.fatec.service;

import java.util.List;

public interface PessoaInterface<P> {
	P create(P obj);
	P findById(Long id);
	List<P> findAll();
	boolean update(P obj);
	boolean delete(Long id);
}
