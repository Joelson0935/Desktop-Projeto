package br.com.casa.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pane extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		try {
			ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/ouro.png"));

			Image img = imagem.getImage();
			g.drawImage(img, 0, 0, 1300, 720, this);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Imagem não encontrada");
		}
	}

}
