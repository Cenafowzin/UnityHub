package br.gov.cesarschool.project.unityhub.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.gov.cesarschool.project.unityhub.entidade.geral.Registro;

@SuppressWarnings("serial")
public class Colaborador extends Registro{
	private String cpf;
	private String nomeCompleto;
	private String celular;
	private String email;
	private String senha;
	private String genero;
	private Estado estado;
	private String cep;
	private String cidade;
	private LocalDate dataDeNascimento;
	
	public Colaborador(String cpf, String nomeCompleto, String celular, String email, String senha, String genero, 
			String cep, String cidade, LocalDate dataDeNascimento) {
		super();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
		this.genero = genero;
		this.cep = cep;
		this.cidade = cidade;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Colaborador(String cpf, String nomeCompleto, String celular, String email, String senha, String genero,
			Estado estado, String cep, String cidade, LocalDate dataDeNascimento) {
		this(cpf, nomeCompleto, celular, email, senha, genero, cep, cidade ,dataDeNascimento);
		
		this.estado = estado;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public int calcularIdade() {
		return (int)ChronoUnit.YEARS.between(dataDeNascimento, LocalDate.now());
	}

	@Override
	public String getIdUnico() {
		return cpf;
	}
}
