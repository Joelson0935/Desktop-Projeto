package br.com.casa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.NoResultException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.casa.dao.Dao;
import br.com.casa.domain.Usuario;

public class TelaLoginAdm extends JFrame {
	private static final long serialVersionUID = 1L;

	JFrame frame;

	JPanel painel;
	Pane pane;

	Dao<Usuario> dao;
	Usuario usuario;
	List<Usuario> usuarios;

	JLabel titulo;
	JLabel login;
	JLabel senha;

	JTextField txtLogin;
	JPasswordField txtSenha;

	JButton entrar;
	JButton funcionario;

	public TelaLoginAdm() {
		super("Adm-Login");
		this.tela();
	}

	public void tela() {

		frame = new JFrame();
		this.setSize(1300, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		pane = new Pane();
		pane.setBounds(0, 0, 1300, 720);

		painel = new JPanel();
		painel.setBounds(0, 0, 1300, 720);
		painel.setLayout(null);

		titulo = new JLabel("TELA DE ADMINISTRADOR");
		titulo.setFont(new Font("arial", Font.BOLD, 30));
		titulo.setBounds(450, 100, 400, 30);

		login = new JLabel("LOGIN ");
		login.setBounds(500, 230, 100, 20);
		login.setFont(new Font("arial", Font.BOLD, 20));

		txtLogin = new JTextField(20);
		txtLogin.setBounds(610, 230, 200, 20);

		senha = new JLabel("SENHA ");
		senha.setBounds(500, 350, 100, 20);
		senha.setFont(new Font("arial", Font.BOLD, 20));

		txtSenha = new JPasswordField();
		txtSenha.setBounds(610, 350, 200, 20);

		entrar = new JButton("ENTRAR");
		entrar.setBounds(600, 470, 100, 30);
		entrar.setFont(new Font("arial", Font.BOLD, 15));
		entrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtLogin.getText().isBlank() || txtSenha.getPassword().length < 5) {
						JOptionPane.showMessageDialog(null, "Usu?rio ou Senha incorretos.");
						JOptionPane.showMessageDialog(null,
								"Usuario n?o pode ser nulo e senha tem que conter mais de 5 caracteres.");
						txtLogin.setText("");
						txtSenha.setText("");
					} else {

						dao = new Dao<Usuario>(Usuario.class);

						String login = txtLogin.getText();
						char[] senha = txtSenha.getPassword();

						usuario = new Usuario(login, new String(senha));

						usuario = dao.buscarPorNome(login);

						if (login.equals(usuario.getNome()) && new String(senha).equals(usuario.getSenha())
								&& usuario.getAdmin() == true) {
							telaProdutos();
							txtLogin.setText("");
							txtSenha.setText("");
							fechar();
						} else {
							JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
							txtLogin.setText("");
							txtSenha.setText("");
						}

					}
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
					txtLogin.setText("");
					txtSenha.setText("");
					e1.printStackTrace();
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
					txtLogin.setText("");
					txtSenha.setText("");
					e2.printStackTrace();
				} catch (NoResultException e3) {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
					txtLogin.setText("");
					txtSenha.setText("");
					e3.printStackTrace();
				} catch (NullPointerException e4) {
					JOptionPane.showMessageDialog(null, "Este Usuario n?o ? um administrador.");
					txtLogin.setText("");
					txtSenha.setText("");
					e4.printStackTrace();
				}
			}

		});

		funcionario = new JButton("FUNC");
		funcionario.setBounds(710, 470, 80, 30);
		funcionario.setBackground(Color.GREEN);
		funcionario.setForeground(Color.RED);
		funcionario.setFont(new Font("arial", Font.BOLD, 15));
		funcionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaVendedor();
				fechar();
			}
		});

		painel.add(txtSenha);
		painel.add(txtLogin);
		painel.add(entrar);
		painel.add(funcionario);
		painel.add(senha);
		painel.add(login);
		painel.add(titulo);
		painel.add(pane);
		this.add(painel);

	}

	public void telaVendedor() {
		TelaLogin vendedor = new TelaLogin();
		vendedor.tela();
	}

	public void telaProdutos() {
		TelaProdutos produto = new TelaProdutos();
		produto.telaProduto();
	}

	public void fechar() {
		this.dispose();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			TelaLoginAdm tela = new TelaLoginAdm();
		});
	}

}
