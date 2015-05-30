package br.com.furb.controller;

import br.com.furb.dao.PessoaDao;
import br.com.furb.model.Pessoa;
import br.com.furb.view.ConsultaView;
import br.com.furb.view.PessoaView;
import br.com.furb.view.util.DefaultIconBar;
import br.com.furb.view.util.DefaultIconBarConsulta;

public class PessoaController {
	
	private PessoaView view;
	private PessoaDao dao;
	
	public PessoaController() {
		this.dao = PessoaDao.getInstance();
	}
	
	public void save(Pessoa pessoa) {
		String erros = validaPessoa(pessoa);
		if (erros == null) {
			dao.insert(pessoa);
		} else {
			throw new IllegalArgumentException(erros);
		}
	}

	private String validaPessoa(Pessoa pessoa) {
		StringBuilder strBuilder = new StringBuilder();
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			if (strBuilder.toString() == null) strBuilder.append("Houveram erros no processo:");
			strBuilder.append("\nO campo nome deve ser informado!");
		} else if (pessoa.getEmail() == null || pessoa.getEmail().isEmpty()) {
			if (strBuilder.toString() == null) strBuilder.append("Houveram erros no processo:");
			strBuilder.append("\nO campo e-mail deve ser informado!");
		} else if (pessoa.getCpf() == null || pessoa.getCpf().isEmpty()) {
			if (strBuilder.toString() == null) strBuilder.append("Houveram erros no processo:");
			strBuilder.append("\nO campo cpf deve ser informado!");
		} else if (pessoa.getRg() == 0) {
			strBuilder.append("\nO campo rg deve ser informado!");
		}
		return strBuilder.toString();
	}
	
	public PessoaDao getDao() {
		return dao;
	}
	
}
