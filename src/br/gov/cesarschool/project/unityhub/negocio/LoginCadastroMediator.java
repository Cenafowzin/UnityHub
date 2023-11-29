package br.gov.cesarschool.project.unityhub.negocio;

import br.gov.cesarschool.project.unityhub.dao.ColaboradorDAO;

public class LoginCadastroMediator {
	private static LoginCadastroMediator instancia;
	public static LoginCadastroMediator getInstancia() {
		if (instancia == null) {
			instancia = new LoginCadastroMediator();
		}
		return instancia;
	}
	private ColaboradorDAO repositorioColaborador;
	
}
