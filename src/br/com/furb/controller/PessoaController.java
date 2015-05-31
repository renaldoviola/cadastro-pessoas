package br.com.furb.controller;

import java.util.List;

import br.com.furb.dao.PessoaDao;
import br.com.furb.model.Pessoa;

public class PessoaController {
	
	private PessoaDao dao;
	
	public PessoaController() {
		this.dao = PessoaDao.getInstance();
	}
	
	public void save(Pessoa pessoa) throws IllegalArgumentException {
		String erros = validaPessoa(pessoa);
		if (erros == null || erros.isEmpty())
			dao.insert(pessoa);
		else
			throw new IllegalArgumentException(erros);
	}
	
	public void delete(Pessoa pessoa) {
		if(pessoa != null)
			dao.delete(pessoa);
	}

	private String validaPessoa(Pessoa pessoa) {
		
		StringBuilder strBuilder = new StringBuilder();
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty())
			strBuilder.append("\nO campo nome deve ser informado!");
		else if (pessoa.getEmail() == null || pessoa.getEmail().isEmpty())
			strBuilder.append("\nO campo e-mail deve ser informado!");
		else if (pessoa.getCpf() == null || pessoa.getCpf().trim().isEmpty())
			strBuilder.append("\nO campo cpf deve ser informado!");
		else if (pessoa.getRg() == 0)
			strBuilder.append("\nO campo rg deve ser informado!");
		
		return strBuilder.toString();
	}
	
	public List<Pessoa> findAll(){
		return dao.findAll();
	}
}
