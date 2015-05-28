package br.com.furb.view.pessoa;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.furb.view.util.DefaultIconBar;

public class PessoaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNome;
	private JTextField fieldCustoUnitario;
	private JTextField fieldVolume;
	
	/**
	 * Create the frame.
	 * 
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
		
		fieldNome = new JTextField();
		fieldNome.setBounds(165, 11, 342, 20);
		panelCadastro.add(fieldNome);
		fieldNome.setColumns(10);
		
		fieldCustoUnitario = new JTextField();
		fieldCustoUnitario.setBounds(165, 39, 121, 20);
		panelCadastro.add(fieldCustoUnitario);
		fieldCustoUnitario.setColumns(10);
		fieldCustoUnitario.setText("");
		
		fieldVolume = new JTextField();
		fieldVolume.setBounds(165, 67, 121, 20);
		panelCadastro.add(fieldVolume);
		fieldVolume.setColumns(10);
		fieldVolume.setText("");
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(63, 11, 73, 20);
		panelCadastro.add(lblNome);
		
		JLabel lblCustoUnitario = new JLabel("Custo Unit.:");
		lblCustoUnitario.setBounds(63, 42, 85, 14);
		panelCadastro.add(lblCustoUnitario);
		
		JLabel lblVolume = new JLabel("Volume (Lts).:");
		lblVolume.setBounds(63, 69, 100, 14);
		panelCadastro.add(lblVolume);
	}
}
