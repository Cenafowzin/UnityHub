package br.gov.cesarschool.project.unityhub.negocio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import br.gov.cesarschool.project.unityhub.dao.ColaboradorDAO;
import br.gov.cesarschool.project.unityhub.dao.EstadoDAO;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Estado;
import br.gov.cesarschool.project.unityhub.negocio.geral.StringUtil;
import br.gov.cesarschool.project.unityhub.negocio.geral.ValidadorCPF;

public class LoginCadastroMediator {
	private static LoginCadastroMediator instancia;
	public static LoginCadastroMediator getInstancia() {
		if (instancia == null) {
			instancia = new LoginCadastroMediator();
		}
		return instancia;
	}
	private ColaboradorDAO repositorioColaborador;
	private EstadoDAO repositorioEstado;
	
	private LoginCadastroMediator() {
		this.repositorioColaborador = new ColaboradorDAO();
		this.repositorioEstado = new EstadoDAO();
	}
	
	public Colaborador buscarColaborador(String email) {
		Colaborador colaborador = repositorioColaborador.buscar(email);
		if(colaborador == null) {
			return null;
		}
		
		return colaborador;
	}
	
	public String excluirColaborador(Colaborador colaborador) {
		if(repositorioColaborador.excluir(colaborador)) {
			return null;
		}
		
		return "Falha na exclusão";
	}
	
	public Estado buscarEstado(String nome){
		Estado estado = repositorioEstado.buscar(nome);
		if(estado == null) {
			return null;
		}
		
		return estado;
	}
	
	public String logarColaborador(Colaborador colaborador, String confirmarSenha) {
		if(colaborador == null) {
			return "Login ou senha incorretos";
		}
		String resultadoValidar = validarColaborador(colaborador);
	    if (resultadoValidar != null) {
	      return resultadoValidar;
	    }
	    
	    Colaborador login = repositorioColaborador.buscar(colaborador.getEmail());
	    String resultadoSenha = compararSenha(colaborador, confirmarSenha);
	    if(login == null || resultadoSenha != null) {
	    	return "Login ou senha incorretos";
	    }
	    
	    return null;
	}
	
	public String cadastrarColaborador(Colaborador colaborador, String confirmarSenha) {
		String resultado = validarColaborador(colaborador);
		if(resultado != null) {
			return resultado;
		}
		
	    String resultadoSenha = compararSenha(colaborador, confirmarSenha);
	    if(resultadoSenha != null) {
	    	return "Senhas incompatíveis";
	    }
		boolean incluir = repositorioColaborador.incluir(colaborador);
	    if (incluir == false) {
	    	return "Usuário ja existe";
	    }
	    
	    return null;
	}
	
	public String[] listarEstados() {
		Estado[] estados = repositorioEstado.buscarTodos();
		String[] nomesEstados = new String[estados.length];
		
		for(int i = 0; i < estados.length; i++) {
			nomesEstados[i] = estados[i].getNome();
		}
		
		return nomesEstados;
	}
	
	private String compararSenha(Colaborador colaborador, String confirmaSenha) {
		if(confirmaSenha.contentEquals(colaborador.getSenha())) {
			return null;
		}
		
		return "Login ou senha incorretos";
	}
	
	private String validarColaborador(Colaborador colaborador) {
		if (StringUtil.ehNuloOuBranco(colaborador.getCpf())) {
			return "CPF nao informado";
		}else if (!ValidadorCPF.ehCpfValido(colaborador.getCpf())) {
			return "CPF invalido";
		}
		if (StringUtil.ehNuloOuBranco(colaborador.getNomeCompleto())) {
			return "Nome completo não informado";
		}
		if (StringUtil.ehNuloOuBranco(colaborador.getGenero())) {
			return "Genero não informado";
		}
		if(StringUtil.ehNuloOuBranco(colaborador.getCep())) {
			return "CEP não informado";
		}
		if (colaborador.getDataDeNascimento() == null) {
			return "Data de nascimento não informada";
		}else if (dataNascimentoInvalida(colaborador.getDataDeNascimento())) {
			return "Data de nascimento inválida";
		}
		if(StringUtil.ehNuloOuBranco(colaborador.getCelular())) {
			return "Número de celular não informado";
		}
		if(StringUtil.ehNuloOuBranco(colaborador.getCidade())) {
			return "Cidade não informada";
		}
		if(StringUtil.ehNuloOuBranco(colaborador.getEmail())) {
			return "E-mail não informado";
		}
		if(StringUtil.ehNuloOuBranco(colaborador.getSenha())) {
			return "Senha não informada";
		}
		if(colaborador.getCargo() == null) {
			return "Cargo não selecionado";
		}
		return null;
	}
	
	private boolean dataNascimentoInvalida(LocalDate dataNascimento) {
		long yearsDifference = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return yearsDifference < 18;
	}
	
}
