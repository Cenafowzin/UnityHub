package br.gov.cesarschool.project.unityhub.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

public class DAOGenerico {
	CadastroObjetos cadastro;

	public DAOGenerico(Class<?> tipo) {
		super();
		this.cadastro = new CadastroObjetos(tipo);
	}
	
	public boolean incluir(Registro reg) {
		Registro novo = buscar(reg.getIdUnico());
		if (novo != null) {
			return false;
		} else {
			cadastro.incluir(reg, reg.getIdUnico());
			return true;
		}
	}
	
	public boolean excluir(Registro reg) {
		Registro novo = buscar(reg.getIdUnico());
		if (novo == null) {
			return false;
		} else {
			cadastro.excluir(reg.getIdUnico());
			return true;
		}
	}
	
	public boolean alterar(Registro reg) {
		Registro novo = buscar(reg.getIdUnico());
		if (novo == null) {
			return false;
		} else {
			cadastro.alterar(reg, reg.getIdUnico());
			return true;
		}
	}
	
	public Registro buscar(String id) {
		return (Registro)cadastro.buscar(id);
	}
	
	public Registro[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Registro.class);
		Registro[] registros = new Registro[rets.length];
		for(int i=0; i<rets.length; i++) {
			registros[i] = (Registro)rets[i];
		}
		return registros;
	}
}
