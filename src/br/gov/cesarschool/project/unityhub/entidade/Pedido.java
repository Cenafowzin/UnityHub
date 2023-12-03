package br.gov.cesarschool.project.unityhub.entidade;

import java.time.LocalDateTime;

import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

@SuppressWarnings("serial")
public class Pedido extends Registro{
	private int id;
	private Projeto projeto;
	private String descricao;
	private Prioridade prioridade;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	
	public Pedido(int id, Projeto projeto, String descricao, Prioridade prioridade, LocalDateTime dataHoraInicio) {
		super();
		this.id = id;
		this.projeto = projeto;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.dataHoraInicio = dataHoraInicio;
	}
	
	

	public Projeto getProjeto() {
		return projeto;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}
	
	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	@Override
	public String getIdUnico() {
		return "" + id;
	}
	
	
}
