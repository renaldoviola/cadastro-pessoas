package br.com.furb.dao;

import br.com.furb.model.Pessoa;

public class PessoaDao extends Dao <Pessoa> {
	
	private static PessoaDao instance;
	
	private PessoaDao() {}
	
	public static PessoaDao getInstance(){
		if(instance == null)
			instance = new PessoaDao();
		return instance;
	}
	
}
