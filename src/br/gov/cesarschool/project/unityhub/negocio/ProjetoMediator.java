package br.gov.cesarschool.project.unityhub.negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.gov.cesarschool.project.unityhub.dao.PedidoDAO;
import br.gov.cesarschool.project.unityhub.dao.ProjetoDAO;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
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
	
	public Projeto buscarProjeto(String email) {
		return repositorioProjeto.buscar(email);
	}
	
	public ProjetoMediator(){
		this.repositorioProjeto = new ProjetoDAO();
		this.repositorioPedido = new PedidoDAO();
	}
	
	public String editarPedido(Pedido pedido) {
		boolean result = repositorioPedido.alterar(pedido);
		if(result == false) {
			return "Pedido inexistente";
		}
		return null;
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
	
	public Pedido[] listarPedidosPorUsuario(Colaborador colaborador) {
		Pedido[] todosPedidos = listarPedidos();
        List<Pedido> pedidosFiltrados = new ArrayList<>();

        for (Pedido pedido : todosPedidos) {
            if (pedido.getProjeto().getEmail().equals(colaborador.getEmail())) {
            	pedidosFiltrados.add(pedido);
            }
        }

        return pedidosFiltrados.toArray(new Pedido[0]);
    }
	
	public Pedido[] listarPedidos() {
		return repositorioPedido.buscarTodos();
	}
	
	public Pedido[] listarPedidosPorEstado(Estado estadoProcurado) {
	    Projeto[] projetosEstado = listarProjetosPorEstado(estadoProcurado);

	    // Use um conjunto de identificadores de projeto para comparação
	    Set<String> idsProjetos = new HashSet<>();
	    for (Projeto projeto : projetosEstado) {
	        idsProjetos.add(projeto.getIdUnico()); // Supondo que getIdUnico() retorne um identificador único
	    }

	    Pedido[] todosPedidos = listarPedidos();
	    List<Pedido> pedidosFiltrados = new ArrayList<>();

	    for (Pedido pedido : todosPedidos) {
	        if (idsProjetos.contains(pedido.getProjeto().getIdUnico())) {
	            pedidosFiltrados.add(pedido);
	        }
	    }

	    return pedidosFiltrados.toArray(new Pedido[0]);
	}
	
	public String criarPedido(Pedido pedido) {		
		boolean incluir = repositorioPedido.incluir(pedido);
		if(incluir == false) {
			return "Erro no cadastro de pedidos";
		}
		return null;
	}
}
