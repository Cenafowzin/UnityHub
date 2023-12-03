package br.gov.cesarschool.project.unityhub.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.gov.cesarschool.project.unityhub.dao.PedidoDAO;
import br.gov.cesarschool.project.unityhub.dao.ProjetoDAO;
import br.gov.cesarschool.project.unityhub.entidade.Estado;
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
	
	public Projeto[] listarProjetosPorEstado(Estado estadoProcurado) {
        Projeto[] todosProjetos = listarProjetos();
        List<Projeto> projetosFiltrados = new ArrayList<>();

        for (Projeto projeto : todosProjetos) {
            if (projeto.getEstado().getNome().equals(estadoProcurado.getNome())) {
                projetosFiltrados.add(projeto);
            }
        }

        return projetosFiltrados.toArray(new Projeto[0]);
    }
	
	public Pedido[] listarPedidos() {
		return repositorioPedido.buscarTodos();
	}
	
	public Pedido[] listarPedidosPorEstado(Estado estadoProcurado) {
	    Projeto[] projetosEstado = listarProjetosPorEstado(estadoProcurado);
	    
	    Set<Projeto> conjuntoProjetos = new HashSet<>(Arrays.asList(projetosEstado));

	    Pedido[] todosPedidos = listarPedidos();
	    List<Pedido> pedidosFiltrados = new ArrayList<>();

	    for (Pedido pedido : todosPedidos) {
	        if (conjuntoProjetos.contains(pedido.getProjeto())) {
	            pedidosFiltrados.add(pedido);
	        }
	    }

	    return pedidosFiltrados.toArray(new Pedido[0]);
	}
}
