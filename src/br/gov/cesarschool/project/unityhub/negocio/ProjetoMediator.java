package br.gov.cesarschool.project.unityhub.negocio;

import br.gov.cesarschool.project.unityhub.dao.PedidoDAO;
import br.gov.cesarschool.project.unityhub.dao.ProjetoDAO;
import br.gov.cesarschool.project.unityhub.entidade.Pedido;
import br.gov.cesarschool.project.unityhub.entidade.Projeto;

public class ProjetoMediator {
	private static ProjetoMediator instancia;
	public static ProjetoMediator getInstancia() {
		if (instancia == null) {
			instancia = new ProjetoMediator();
		}
		return instancia;
	}
	
	private ProjetoDAO repositorioProjeto;
	private PedidoDAO repositorioPedido;
	
	public ProjetoMediator(){
		this.repositorioProjeto = new ProjetoDAO();
		this.repositorioPedido = new PedidoDAO();
	}
	
	public Projeto[] listarProjetos() {
		return repositorioProjeto.buscarTodos();
	}
	
	public Pedido[] listarPedidos() {
		return repositorioPedido.buscarTodos();
	}
}
