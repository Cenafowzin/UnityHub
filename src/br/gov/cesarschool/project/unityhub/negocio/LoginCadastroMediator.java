package br.gov.cesarschool.project.unityhub.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.gov.cesarschool.project.unityhub.dao.ColaboradorDAO;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
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
	
	private String logarColaborador(Colaborador colaborador) {
		String resultado = validarColaborador(colaborador);
	    if (resultado != null) {
	      return resultado;
	    }
	    
	    if (repositorioColaborador.buscar(colaborador.getCpf()) == null) {
	      return "Usuário não cadastrado";
	    }
	    
	    return null;
	}
	
	private String cadastrarColaborador(Colaborador colaborador) {
		String resultado = validarColaborador(colaborador);
		if(resultado != null) {
			return resultado;
		}
		
		boolean incluir = repositorioColaborador.incluir(colaborador);
	    if (incluir == false) {
	    	return "Usuário ja existe";
	    }
	    
	    return "Usuário cadastrado com sucesso";
	}
	
	private String validarColaborador(Colaborador colaborador) {
		if (StringUtil.ehNuloOuBranco(colaborador.getCpf())) {
			return "CPF nao informado";
		}else if (!ValidadorCPF.ehCpfValido(colaborador.getCpf())) {
			return "CPF invalido";
		}
		if (StringUtil.ehNuloOuBranco(colaborador.getNomeCompleto())) {
			return "Nome completo nao informado";
		}
		if (colaborador.getGenero() == null) {
			return "Genero nao informado";
		}
		if (colaborador.getDataDeNascimento() == null) {
			return "Data de nascimento nao informada";
		}
		if (dataNascimentoInvalida(colaborador.getDataDeNascimento())) {
			return "Data de nascimento invalida";
		}				
		return null;
	}
	
	private boolean dataNascimentoInvalida(LocalDateTime dataNascimento) {
		long yearsDifference = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return yearsDifference < 18;
	}
	
}
