package br.gov.cesarschool.project.unityhub.entidade;

import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

@SuppressWarnings("serial")
public class Estado extends Registro{
	private String nome;
	private double latitudeCapital;
	private double longitudeCapital;
	private Projeto[] projetos;
	
	public Estado(String nome, double latitudeCapital, double longitudeCapital) {
		super();
		this.nome = nome;
		this.latitudeCapital = latitudeCapital;
		this.longitudeCapital = longitudeCapital;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getLatitudeCapital() {
		return latitudeCapital;
	}
	
	public double getLongitudeCapital() {
		return longitudeCapital;
	}

	public Projeto[] getProjetos() {
		return projetos;
	}

	@Override
	public String getIdUnico() {
		return nome;
	}
	
}
