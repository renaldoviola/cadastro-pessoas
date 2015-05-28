package br.com.furb.view.util;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class DefaultIconBarConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public DefaultIconBarConsulta() {
		
		setVisible(true);
		setLocation(0, 0);
		
		final JLabel lblOk = new JLabel();
		lblOk.setBounds(10, 10, 37, 19);
		lblOk.setIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/ok.png")));
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ok();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOk.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/ok.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblOk.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/ok.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}
		});
		add(lblOk);
		
		final JLabel lblBack = new JLabel();
		lblBack.setBounds(10, 10, 37, 19);
		lblBack.setIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/back.png")));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/back.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/back.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}
		});
		add(lblBack);
		
		final JLabel lblDelete = new JLabel();
		lblDelete.setBounds(10, 10, 37, 19);
		lblDelete.setIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/delete.png")));
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDelete.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/delete.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDelete.setIcon(new ImageIcon(new ImageIcon(DefaultIconBarConsulta.class.getResource("/icons/delete.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}
		});
		add(lblDelete);
		
	}
	
	public abstract void ok();
	public abstract void exit();
	public abstract void delete();
	

}
