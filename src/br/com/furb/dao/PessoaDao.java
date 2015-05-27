package br.com.furb.dao;

import br.com.furb.model.Pessoa;
import br.com.furb.persistence.PersistenceStrategy;

public class PessoaDao extends Dao <Pessoa>{
	
	public PessoaDao(PersistenceStrategy<Pessoa> persistenceStrategy) {
		super(persistenceStrategy);
	}

}
