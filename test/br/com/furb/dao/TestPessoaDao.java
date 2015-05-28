package br.com.furb.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.furb.model.Pessoa;

public class TestPessoaDao {

	@Test
	public void shouldInsertPessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(1234567, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		assertNotNull(dao.find(pessoa.getId()));
	}
	
	@Test(expected = Exception.class)
	public void shouldntInsertDuplicatePessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(8888888, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		dao.insert(pessoa);
	}
	
	@Test
	public void shouldDeletePessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(7777777, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		dao.delete(pessoa);
		assertNull(dao.find(pessoa.getId()));
	}

	@Test
	public void shouldUpdatePessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(9999999, "teste", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		
		pessoa.setNome("teste2");
		dao.update(pessoa);
		
		Pessoa pessoa2 = dao.find(pessoa.getId());
		assertTrue("teste2".equals(pessoa2.getNome()));
	}
	
}