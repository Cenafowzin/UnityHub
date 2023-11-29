package br.gov.cesarschool.project.unityhub.entidade;

import java.io.Serializable;

public enum Prioridade implements Serializable{
	ALTA (1,"Alta"),
	MEDIA (2,"Media"), 
	BAIXA (3,"Baixa");
	private int codigo;
	private String nome;
	private Prioridade(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public static Prioridade obterPrioridade(int codigo) {
		for (Prioridade prioridade : Prioridade.values()) {
			if (prioridade.codigo == codigo) {
				return prioridade;
			}
		}
		return null;
	}
}
