package br.com.furb.view;

import java.awt.Rectangle;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.furb.view.util.DefaultIconBar;

public class PessoaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField cpfField;
	private JTextField rgField;
	
	/**
	 * Create the frame.
	 * @param iconBar
	 */
	public PessoaView(DefaultIconBar iconBar) {
		
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 600, 400));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iconBar.setBounds(0, 0, 584, 42);
		contentPane.add(iconBar);
		
		createComponents();
		
		setVisible(true);
		
	}
	
	private void createComponents(){
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 53, 584, 297);
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
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
}
