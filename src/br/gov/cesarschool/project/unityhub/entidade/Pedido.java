package br.gov.cesarschool.project.unityhub.entidade;

import java.time.LocalDateTime;

import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

@SuppressWarnings("serial")
public class Pedido extends Registro{
	private int id;
	private String descricao;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	
	public Pedido(int id, String descricao, LocalDateTime dataHoraInicio) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
	}
	
	public Pedido(int id, String descricao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
		this(id, descricao, dataHoraInicio);
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
