package br.gov.cesarschool.project.unityhub.dao;

import br.gov.cesarschool.project.unityhub.entidade.Projeto;
import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

public class ProjetoDAO {
	private DAOGenerico dao;
	public ProjetoDAO() {
        this.dao = new DAOGenerico(Projeto.class);
    }
	public boolean incluir(Projeto caixaBonus) {
		return dao.incluir(caixaBonus);
	}
	public boolean alterar(Projeto caixaBonus) {
		return dao.alterar(caixaBonus);	
	}
	public Projeto buscar(String codigo) {
		return (Projeto) dao.buscar(codigo);
	}
	public Projeto[] buscarTodos() {
		Registro[] registros = dao.buscarTodos();
		Projeto[] caixasDeBonus = new Projeto[registros.length];
        for (int i = 0; i < registros.length; i++) {
        	caixasDeBonus[i] = (Projeto) registros[i];
        }
        return caixasDeBonus;
	} 
}
