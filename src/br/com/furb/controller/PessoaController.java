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
		this.view = new PessoaView(getViewActions());
	}
	
	private DefaultIconBar getViewActions(){
		return new DefaultIconBar() {
			private static final long serialVersionUID = 1L;

			@Override
			public void save() {
				Pessoa pessoa = new Pessoa();
				dao.insert(pessoa);
				//TODO: 
			}
			
			@Override
			public void newRegister() {
				clearFields();
			}

			@Override
			public void find() {
				new ConsultaView<Pessoa>("Consulta de Pessoas", dao, getConsultaViewActions());
			}
			
			private void clearFields() {
				view.getNomeField().setText("");
				view.getEmailField().setText("");
				view.getCpfField().setText("");
				view.getRgField().setText("");
			}
		};
	}
	
	private DefaultIconBarConsulta getConsultaViewActions() {
		return new DefaultIconBarConsulta() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void ok() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void delete() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
