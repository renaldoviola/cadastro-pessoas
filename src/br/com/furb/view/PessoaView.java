package br.com.furb.view;

import java.awt.Rectangle;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import br.com.furb.controller.PessoaController;
import br.com.furb.model.Pessoa;
import br.com.furb.view.util.DefaultIconBar;
import br.com.furb.view.util.ReflectionTableModel;

public class PessoaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField cpfField;
	private JTextField rgField;
	private PessoaController controller;
	private JTable table;
	private ReflectionTableModel tableModel;
	
	/**
	 * Create the frame.
	 */
	public PessoaView() {
		
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 600, 500));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controller = new PessoaController();
		
		DefaultIconBar iconBar = getIconBarActions();
		iconBar.setBounds(10, -1, 574, 42);
		contentPane.add(iconBar);
		
		createComponents();
	}
	
	private void createComponents(){
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(10, 53, 574, 166);
		contentPane.add(panelCadastro);
		panelCadastro.setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(165, 11, 342, 20);
		panelCadastro.add(nomeField);
		nomeField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(165, 39, 342, 20);
		panelCadastro.add(emailField);
		emailField.setColumns(10);
		emailField.setText("");
		
		try {
			cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cpfField.setBounds(165, 67, 121, 20);
		panelCadastro.add(cpfField);
		cpfField.setColumns(10);
		cpfField.setText("");
		
		try {
			rgField = new JFormattedTextField(new MaskFormatter("#.###.###"));
		} catch (ParseException e) {}
		rgField.setText("");
		rgField.setColumns(10);
		rgField.setBounds(165, 93, 121, 20);
		panelCadastro.add(rgField);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(63, 11, 73, 20);
		panelCadastro.add(lblNome);
		
		JLabel lblCustoUnitario = new JLabel("E-mail:");
		lblCustoUnitario.setBounds(63, 42, 85, 14);
		panelCadastro.add(lblCustoUnitario);
		
		JLabel lblVolume = new JLabel("CPF:");
		lblVolume.setBounds(63, 70, 100, 14);
		panelCadastro.add(lblVolume);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(63, 96, 100, 14);
		panelCadastro.add(lblRg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 574, 242);
		
		createTable();
		
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
	}
	
	private void updateTable(){
		table.clearSelection();
		tableModel.updateModel(controller.findAll());
		tableModel.fireTableDataChanged();
	}
	
	private void createTable(){
		List<Pessoa> lista = controller.findAll();
		table = new JTable();
		table.clearSelection();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setBounds(this.getWidth(), this.getHeight(), 0, 0);
		tableModel = new ReflectionTableModel(lista);
		table.setModel(tableModel);
		table.updateUI();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Pessoa pessoa = getSelectedElement();
				if(pessoa != null)
					bindPessoa(pessoa);
			}
		});
	}
	
	private Pessoa getSelectedElement(){
		ReflectionTableModel tableModel = (ReflectionTableModel) table.getModel();
		return (Pessoa) tableModel.getValueAt(table.getSelectedRow());
	}
	
	private String removeMask(String value) {
		value = value.replace("-", "");
		return value.replace(".", "");
	}
	
	private void clearFields() {
		getNomeField().setText("");
		getEmailField().setText("");
		getCpfField().setText("");
		getRgField().setText("");
	}
	
	
	private int getRgValue() {
		try{
			return Integer.parseInt(removeMask(rgField.getText()));
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	private DefaultIconBar getIconBarActions(){
		return new DefaultIconBar(){
			private static final long serialVersionUID = 1L;

			@Override
			public void save() {
	
				Pessoa pessoa = new Pessoa(getRgValue(), nomeField.getText(), 
						emailField.getText(), removeMask(cpfField.getText()));
				
				try{
					controller.save(pessoa);
				}catch(IllegalArgumentException iae){
					JOptionPane.showMessageDialog(null, iae.getMessage());
				}
				updateTable();
				clearFields();
			}
			
			@Override
			public void newRegister() {
				updateTable();
				clearFields();
			}
			
			@Override
			public void delete() {
				controller.delete(getSelectedElement());
				updateTable();
				clearFields();
			}
		};
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public JTextField getRgField() {
		return rgField;
	}
	
	private void bindPessoa(Pessoa pessoa){
		setNomeField(pessoa.getNome());
		setCpfField(pessoa.getCpf());
		setEmailField(pessoa.getEmail());
		setRgField(pessoa.getRg());
	}

	public void setNomeField(String nome) {
		this.nomeField.setText(nome);
	}

	public void setEmailField(String email) {
		this.emailField.setText(email);
	}

	public void setCpfField(String cpf) {
		this.cpfField.setText(cpf);
	}

	public void setRgField(int rg) {
		this.rgField.setText(String.valueOf(rg));
	}
	
	
}
