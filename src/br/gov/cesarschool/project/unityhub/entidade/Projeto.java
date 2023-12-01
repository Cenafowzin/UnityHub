package br.gov.cesarschool.project.unityhub.entidade;

import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

@SuppressWarnings("serial")
public class Projeto extends Registro{
	private String nome;
	private String celular;
	private String email;
	private String descricao;
	private String cep;
	private Prioridade prioridade;

	public Projeto(String nome, String celular, String email, String descricao, String cep, Prioridade prioridade) {
		super();
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.descricao = descricao;
		this.cep = cep;
		this.prioridade = prioridade;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public String getNome() {
		return nome;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCep() {
		return cep;
	}
	
	@Override
	public String getIdUnico() {
		return nome;
	}
	
}
