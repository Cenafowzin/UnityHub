package br.gov.cesarschool.project.unityhub.entidade;

import java.io.Serializable;

public enum Cargo implements Serializable{
	GERENCIA (1,"Gerencia"), 
	EMBAIXADOR (2,"Embaixador"),
	USUARIO (3,"Usuario");
	private int codigo;
	private String nome;
	private Cargo(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public static Cargo obterCargo(int codigo) {
		for (Cargo cargo : Cargo.values()) {
			if (cargo.codigo == codigo) {
				return cargo;
			}
		}
		return null;
	}
}


