package br.gov.cesarschool.project.unityhub.dao;

import br.gov.cesarschool.project.unityhub.entidade.Estado;
import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

public class EstadoDAO {
	private DAOGenerico dao;
	public EstadoDAO() {
        this.dao = new DAOGenerico(Estado.class);
    }
	public boolean incluir(Estado estado) {
		return dao.incluir(estado);
	}
	public boolean alterar(Estado estado) {
		return dao.alterar(estado);	
	}
	public Estado buscar(String codigo) {
		return (Estado) dao.buscar(codigo);
	}
	public Estado[] buscarTodos() {
		Registro[] registros = dao.buscarTodos();
		Estado[] estados = new Estado[registros.length];
        for (int i = 0; i < registros.length; i++) {
        	estados[i] = (Estado) registros[i];
        }
        return estados;
	} 
}
