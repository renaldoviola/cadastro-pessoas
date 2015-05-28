package br.com.furb.controller;

import br.com.furb.dao.PessoaDao;
import br.com.furb.model.Pessoa;
import br.com.furb.view.PessoaView;
import br.com.furb.view.util.DefaultIconBar;

public class PessoaController {
	
	private PessoaView view;
	private PessoaDao dao;
	
	public PessoaController() {
		this.view = new PessoaView(getViewActions());
	}
	
	private DefaultIconBar getViewActions(){
		return new DefaultIconBar() {
			private static final long serialVersionUID = 1L;

			@Override
			public void save() {
				Pessoa pessoa = new Pessoa();
				dao.insert(pessoa);
			}
			
			@Override
			public void newRegister() {
				// TODO limpar os campos da tela
			}
			
			@Override
			public void find() {
				// TODO criar view de consulta
			}
		};
	}
	
}
