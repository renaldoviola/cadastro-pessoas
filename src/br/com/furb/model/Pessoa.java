package br.com.furb.model;

import br.com.furb.view.util.ConsultaViewColumn;

public class Pessoa implements ModelToPersist {

	private String nome;
	private String email;
	private String cpf;
	private int rg;
	
	public Pessoa(int rg, String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public Pessoa() {}

	@Override
	public int getId() {
		return rg;
	}
	
	@ConsultaViewColumn(nome="CPF", posicao=2)
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@ConsultaViewColumn(nome="RG", posicao=3)
	public int getRg() {
		return rg;
	}
	
	public void setRg(int rg) {
		this.rg = rg;
	}
	
	@ConsultaViewColumn(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ConsultaViewColumn(nome="E-mail", posicao=1)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
