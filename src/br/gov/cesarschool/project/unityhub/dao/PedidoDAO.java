package br.gov.cesarschool.project.unityhub.dao;

import br.gov.cesarschool.project.unityhub.entidade.Pedido;
import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

public class PedidoDAO {
	private DAOGenerico dao;
	public PedidoDAO() {
        this.dao = new DAOGenerico(Pedido.class);
    }
	public boolean incluir(Pedido pedido) {
		return dao.incluir(pedido);
	}
	public boolean excluir(Pedido pedido) {
		return dao.excluir(pedido);
	}
	public boolean alterar(Pedido pedido) {
		return dao.alterar(pedido);	
	}
	public Pedido buscar(String codigo) {
		return (Pedido) dao.buscar(codigo);
	}
	public Pedido[] buscarTodos() {
		Registro[] registros = dao.buscarTodos();
		Pedido[] pedidos = new Pedido[registros.length];
        for (int i = 0; i < registros.length; i++) {
        	pedidos[i] = (Pedido) registros[i];
        }
        return pedidos;
	} 
}
