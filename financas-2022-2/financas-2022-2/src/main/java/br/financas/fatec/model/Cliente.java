package br.financas.fatec.model;

import javax.persistence.*;


@Entity
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends AbstractEntity1{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome", length = 60)
	private String nome;
	@Column(name = "ds_endereco", length = 120)
	private String endereco;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Conta conta;
	
	public Cliente() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

}
