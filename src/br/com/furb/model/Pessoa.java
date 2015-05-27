package br.com.furb.model;

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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
