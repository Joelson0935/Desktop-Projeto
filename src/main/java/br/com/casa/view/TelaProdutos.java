package br.com.casa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import br.com.casa.dao.Dao;
import br.com.casa.domain.Produto;

public class TelaProdutos extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Pane pane;
	JPanel painel;
	DefaultTableModel padrao;
	JScrollPane scroll;

	JButton adicionar;
	JButton buscar;
	JButton atualizar;
	JButton remover;

	JTextField txtCod;
	JTextField txtNome;
	JTextField txtFornecedor;
	JTextField txtQuantidade;
	JTextField txtPreco;
	JTable tabela;

	Dao<Produto> dao = new Dao<>(Produto.class);
	Produto produto;
	List<Produto> produtos;

	protected JFrame frame;

	public TelaProdutos() {
		super("Controle de Produtos");
		telaProduto();

	}

	void telaProduto() {
		frame = new JFrame();
		this.setSize(1300, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setResizable(false);

		pane = new Pane();
		pane.setBounds(0, 0, 1300, 720);
		painel = new JPanel();
		painel.setLayout(null);

		// bounds = L.esquerda, L.cima, largura, altura
		painel.setBounds(0, 0, 1300, 720);

		JLabel titulo = new JLabel("CONTROLE DE ESTOQUE");
		titulo.setBounds(500, 90, 300, 30);
		titulo.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(titulo);

		JLabel cod = new JLabel("Cod.");
		cod.setBounds(95, 250, 60, 20);
		cod.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(cod);

		txtCod = new JTextField();
		txtCod.setBounds(155, 250, 120, 20);
		painel.add(txtCod);

		// bounds = L.esquerda, L.cima, largura, altura
		JLabel nome = new JLabel("Nome");
		nome.setBounds(285, 250, 60, 20);
		nome.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(nome);

		txtNome = new JTextField();
		txtNome.setBounds(355, 250, 120, 20);
		painel.add(txtNome);

		// bounds = L.esquerda, L.cima, largura, altura
		JLabel fornecedor = new JLabel("Fornecedor");
		fornecedor.setBounds(485, 250, 120, 20);
		fornecedor.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(fornecedor);

		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(610, 250, 120, 20);
		painel.add(txtFornecedor);

		// bounds = L.esquerda, L.cima, largura, altura
		JLabel quantidade = new JLabel("Quantidade ");
		quantidade.setBounds(740, 250, 120, 20);
		quantidade.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(quantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(865, 250, 120, 20);
		txtQuantidade.setSelectionColor(Color.CYAN);
		painel.add(txtQuantidade);

		// bounds = L.esquerda, L.cima, largura, altura
		JLabel preco = new JLabel("Preço");
		preco.setBounds(995, 250, 60, 20);
		preco.setFont(new Font("arial", Font.BOLD, 20));
		painel.add(preco);

		// bounds = L.esquerda, L.cima, largura, altura
		txtPreco = new JTextField();
		txtPreco.setBounds(1060, 250, 120, 20);
		painel.add(txtPreco);

		// bounds = L.esquerda, L.cima, largura, altura
		padrao = new DefaultTableModel(20, 0);
		padrao.addColumn("Codigo");
		padrao.addColumn("Nome");
		padrao.addColumn("Fornecedor");
		padrao.addColumn("Quantidade");
		padrao.addColumn("PreçoUnd");

		tabela = new JTable(padrao);
		tabela.setBounds(95, 350, 1080, 300);
		tabela.setModel(padrao);

		scroll = new JScrollPane(tabela);
		scroll.setBounds(95, 350, 1080, 300);
		painel.add(scroll);

		// bounds = L.esquerda, L.cima, largura, altura
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(1180, 350, 100, 30);
		adicionar.setFont(new Font("arial", Font.BOLD, 15));
		adicionar.addActionListener(this);
		painel.add(adicionar);

		// bounds = L.esquerda, L.cima, largura, altura
		buscar = new JButton("Buscar");
		buscar.setBounds(1180, 440, 100, 30);
		buscar.setFont(new Font("arial", Font.BOLD, 15));
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtCod.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
				} else {
					try {
						Long id = Long.parseLong(txtCod.getText());

						produto = dao.buscarPorId(id);

						Object[] lista = { produto.getId(), produto.getNome(), produto.getMarca(),
								produto.getQuantidade(), produto.getPrecoUnitario() };

						padrao.insertRow(0, lista);

						txtCod.setText("");
						txtNome.setText("");
						txtFornecedor.setText("");
						txtQuantidade.setText("");
						txtPreco.setText("");

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						txtCod.setText("");
					}
				}
			}
		});

		painel.add(buscar);

		// bounds = L.esquerda, L.cima, largura, altura
		atualizar = new JButton("Atualizar");
		atualizar.setBounds(1180, 530, 100, 30);
		atualizar.setFont(new Font("arial", Font.BOLD, 15));
		atualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCod.getText().isBlank() || txtNome.getText().isBlank() || txtFornecedor.getText().isBlank()
						|| txtQuantidade.getText().isBlank() || txtPreco.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios.");

				} else {

					try {
						Long id = Long.parseLong(txtCod.getText());
						String nome = txtNome.getText();
						String fornecedor = txtFornecedor.getText();
						Integer quantidade = Integer.parseInt(txtQuantidade.getText());
						BigDecimal preco = new BigDecimal(txtPreco.getText());

						produto = new Produto(id, nome, fornecedor, quantidade, preco);

						dao.atualizar(produto, produto.getId());
						System.out.println(produto.toString());
						JOptionPane.showMessageDialog(null, produto.toString());

						txtCod.setText("");
						txtNome.setText("");
						txtFornecedor.setText("");
						txtQuantidade.setText("");
						txtPreco.setText("");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
					}
				}
			}
		});
		painel.add(atualizar);

		// bounds = L.esquerda, L.cima, largura, altura
		remover = new JButton("Remover");
		remover.setBounds(1180, 620, 100, 30);
		remover.setFont(new Font("arial", Font.BOLD, 15));
		remover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCod.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");

				} else {
					try {
						Long id = Long.parseLong(txtCod.getText());

						produto = dao.buscarPorId(id);
						dao.deletar(produto.getId());

						JOptionPane.showMessageDialog(null, "Produto " + id + " deletado com sucesso!");

						txtCod.setText("");
						txtNome.setText("");
						txtFornecedor.setText("");
						txtQuantidade.setText("");
						txtPreco.setText("");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
					}
				}

			}
		});
		painel.add(remover);

		this.add(painel);
		painel.add(pane);

	}

//	Método para adicionar produtos no banco de dados.
	public void actionPerformed(ActionEvent e) {

		if (txtNome.getText().isBlank() || txtFornecedor.getText().isBlank() || txtQuantidade.getText().isBlank()
				|| txtPreco.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios.");

		} else {

			try {

				String nome = txtNome.getText();
				String fornecedor = txtFornecedor.getText();
				Integer quantidade = Integer.parseInt(txtQuantidade.getText());
				BigDecimal preco = new BigDecimal(txtPreco.getText());

				produto = new Produto(nome, fornecedor, quantidade, preco);

				dao.salvar(produto);
				System.out.println(produto.toString());
				JOptionPane.showMessageDialog(null, produto.toString());

				txtCod.setText("");
				txtNome.setText("");
				txtFornecedor.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
				e1.printStackTrace();
			} catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
				e1.printStackTrace();
			} catch (IllegalStateException e1) {
				JOptionPane.showMessageDialog(null, "O campo código está vazio ou não existe.");
			}
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			TelaProdutos tela = new TelaProdutos();
		});
	}

}
