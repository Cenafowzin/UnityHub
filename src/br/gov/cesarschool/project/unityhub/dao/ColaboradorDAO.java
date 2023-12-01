package br.gov.cesarschool.project.unityhub.dao;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

public class ColaboradorDAO {
	private DAOGenerico dao;
	public ColaboradorDAO() {
        this.dao = new DAOGenerico(Colaborador.class);
    }
	
	public boolean incluir(Colaborador colaborador) {
		return dao.incluir(colaborador);
	}
	
	public boolean excluir(Colaborador colaborador) {
		return dao.excluir(colaborador);
	}
	
	public boolean alterar(Colaborador colaborador) {
		return dao.alterar(colaborador);	
	}
	
	public Colaborador buscar(String codigo) {
		return (Colaborador) dao.buscar(codigo);
	}
	
	public Colaborador[] buscarTodos() {
		Registro[] registros = dao.buscarTodos();
		Colaborador[] colaboradores = new Colaborador[registros.length];
        for (int i = 0; i < registros.length; i++) {
        	colaboradores[i] = (Colaborador) registros[i];
        }
        return colaboradores;
	} 
}
