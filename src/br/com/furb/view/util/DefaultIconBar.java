package br.com.furb.view.util;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public abstract class DefaultIconBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public DefaultIconBar() {
		
		setVisible(true);
		setLocation(0, 0);
		
		final JLabel lblNew = new JLabel();
		lblNew.setBounds(10, 10, 37, 19);
		lblNew.setIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/new.png")));
		lblNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newRegister();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNew.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/new.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNew.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/new.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}
		});
		add(lblNew);
		
		final JLabel lblSave = new JLabel();
		lblSave.setBounds(10, 10, 37, 19);
		lblSave.setIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/save.png")));
		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/save.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSave.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/save.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}			
		});
		add(lblSave);
		
		final JLabel lblDelete = new JLabel();
		lblDelete.setBounds(10, 10, 37, 19);
		lblDelete.setIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/delete.png")));
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDelete.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/delete.png")).getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDelete.setIcon(new ImageIcon(new ImageIcon(DefaultIconBar.class.getResource("/icons/delete.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			}			
		});
		add(lblDelete);
		
	}
	
	public abstract void newRegister();
	public abstract void save();
	public abstract void delete();
	
}
