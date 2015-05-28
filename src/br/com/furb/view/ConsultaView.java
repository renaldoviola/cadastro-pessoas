package br.com.furb.view;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.com.furb.dao.Dao;
import br.com.furb.model.ModelToPersist;
import br.com.furb.view.util.DefaultIconBarConsulta;
import br.com.furb.view.util.ReflectionTableModel;

public class ConsultaView<T extends ModelToPersist> extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JTable table;
	private Dao<T> dao;
	
	/**
	 * Create the frame.
	 */
	public ConsultaView(String formName, Dao<T> dao, DefaultIconBarConsulta iconBar) {
		super(formName);

		this.dao = dao;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 600, 400));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);

		iconBar.setBounds(10, 0, 574, 46);
		contentPane.add(iconBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 574, 293);
		
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		updateTable();
		
		this.setVisible(true);
		this.setEnabled(true);
	}
	
	public void updateTable(){
		List<T> lista = dao.findAll();
		table = new JTable();
		table.clearSelection();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setBounds(this.getWidth(), this.getHeight(), 0, 0);
		table.setModel(new ReflectionTableModel(lista));
		table.updateUI();
	}
}
