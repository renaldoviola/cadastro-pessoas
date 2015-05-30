package br.com.furb.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.model.Pessoa;

public class TestPessoaDao {

	@Test
	public void shouldInsertPessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(1234567, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		assertNotNull(dao.find(pessoa));
	}
	
	@Test
	public void shouldDeletePessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(7777777, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		dao.delete(pessoa);
		assertNull(dao.find(pessoa));
	}

	@Test
	public void shouldUpdatePessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		Pessoa pessoa = new Pessoa(9999999, "teste", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		
		pessoa.setNome("teste2");
		dao.update(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setRg(9999999);
		
		Pessoa pessoa2 = dao.find(pessoa);
		
		assertNotNull(pessoa2);
		assertTrue("teste2".equals(pessoa2.getNome()));
	}
	
	@Test
	public void shouldFindAllPessoa() {
		PessoaDao dao = PessoaDao.getInstance();
		dao.deleteAll();
		
		Pessoa pessoa = new Pessoa(1111111, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa);
		Pessoa pessoa2 = new Pessoa(2222222, "Pessoa da Silva", "silva@gmail.com.br", "123098123098");
		dao.insert(pessoa2);

		assertEquals(2, dao.findAll().size());
	}
	
}