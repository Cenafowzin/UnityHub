package br.gov.cesarschool.project.unityhub.negocio;

public class ProjetoMediator {
	private static ProjetoMediator instancia;
	public static ProjetoMediator getInstancia() {
		if (instancia == null) {
			instancia = new ProjetoMediator();
		}
		return instancia;
	}
	
}
