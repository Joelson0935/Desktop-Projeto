package br.com.casa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
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
import br.com.casa.domain.ItensPedido;
import br.com.casa.domain.Pedido;
import br.com.casa.domain.Produto;

public class TelaVendas extends JFrame {
	private static final long serialVersionUID = 1L;

	protected JFrame frame;

	Pane pane;
	JPanel painel;

	Dao<ItensPedido> dao;
	Dao<Produto> daoProduto;
	Dao<Pedido> daoPedido;
	Produto produto;
	Pedido pedido;
	ItensPedido itens;
	List<ItensPedido> itensPedido;

	JLabel titulo;
	JLabel quantidade;
	JLabel codPedido;
	JLabel precoUnd;
	JLabel valorTotal;

	JTextField txtQtd;
	JTextField txtCodPed;
	JTextField txtPreco;
	JTextField txtTotal;
	JTextField txtBuscar;

	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane scroll;

	JButton buscar;
	JButton comprar;

	public TelaVendas() {
		super("Vendas");
		tela();
	}

	void tela() {
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
		painel.setBounds(0, 0, 1300, 720);
		painel.setLayout(null);

		titulo = new JLabel("SISTEMA DE VENDAS");
		titulo.setFont(new Font("arial", Font.BOLD, 30));
		titulo.setBounds(475, 100, 350, 30);

		quantidade = new JLabel("QUANTIDADE");
		quantidade.setBounds(30, 200, 150, 20);
		quantidade.setFont(new Font("arial black", Font.BOLD, 15));

		txtQtd = new JTextField();
		txtQtd.setBounds(30, 225, 150, 30);
		txtQtd.setFont(new Font("arial black", Font.BOLD, 20));
		txtQtd.setBackground(Color.GREEN);
		txtQtd.setForeground(Color.RED);
		txtQtd.setHorizontalAlignment(JTextField.CENTER);
		painel.add(txtQtd);

		codPedido = new JLabel("COD/PEDIDO");
		codPedido.setBounds(30, 265, 150, 20);
		codPedido.setFont(new Font("arial black", Font.BOLD, 15));

		txtCodPed = new JTextField();
		txtCodPed.setBounds(30, 290, 150, 30);
		txtCodPed.setFont(new Font("arial black", Font.BOLD, 20));
		txtCodPed.setBackground(Color.GREEN);
		txtCodPed.setForeground(Color.RED);
		txtCodPed.setHorizontalAlignment(JTextField.CENTER);
		painel.add(txtCodPed);

		precoUnd = new JLabel("PREÇO");
		precoUnd.setBounds(30, 330, 100, 20);
		precoUnd.setFont(new Font("arial black", Font.BOLD, 15));

		txtPreco = new JTextField();
		txtPreco.setBounds(30, 355, 150, 30);
		txtPreco.setFont(new Font("arial black", Font.BOLD, 20));
		txtPreco.setBackground(Color.GREEN);
		txtPreco.setForeground(Color.RED);
		txtPreco.setHorizontalAlignment(JTextField.CENTER);
		painel.add(txtPreco);

		valorTotal = new JLabel("TOTAL");
		valorTotal.setBounds(30, 395, 100, 20);
		valorTotal.setFont(new Font("arial black", Font.BOLD, 15));

		txtTotal = new JTextField();
		txtTotal.setBounds(30, 420, 150, 30);
		txtTotal.setFont(new Font("arial black", Font.BOLD, 20));
		txtTotal.setBackground(Color.GREEN);
		txtTotal.setForeground(Color.RED);
		txtTotal.setHorizontalAlignment(JTextField.CENTER);
		painel.add(txtTotal);

		modelo = new DefaultTableModel(30, 0);
		modelo.addColumn("Produto");
		modelo.addColumn("Pedido");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço Unitario");
		modelo.addColumn("Valor da Compra");

		tabela = new JTable(modelo);
		tabela.setBounds(200, 200, 960, 300);

		scroll = new JScrollPane(tabela);
		scroll.setBounds(200, 200, 960, 300);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(450, 515, 300, 30);
		txtBuscar.setFont(new Font("arial black", Font.BOLD, 20));
		txtBuscar.setBackground(Color.GREEN);
		txtBuscar.setForeground(Color.RED);
		txtBuscar.setHorizontalAlignment(JTextField.CENTER);
		painel.add(txtBuscar);

		buscar = new JButton("Buscar");
		buscar.setBounds(755, 515, 100, 30);
		buscar.setFont((new Font("arial black", Font.BOLD, 13)));
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					daoProduto = new Dao<Produto>(Produto.class);
					dao = new Dao<ItensPedido>(ItensPedido.class);
					daoPedido = new Dao<Pedido>(Pedido.class);

					Integer quantidade = Integer.parseInt(txtQtd.getText());
					String busca = txtBuscar.getText();
					produto = new Produto();

					produto = daoProduto.buscarPorNome(busca);
					pedido = new Pedido();
					Long codigo = Long.parseLong(txtCodPed.getText());
					pedido.setCodigo(codigo);

					itens = new ItensPedido(produto, pedido, quantidade);

					Object[] obj = { itens.getProduto().getNome(), codigo, itens.getQuantidade(),
							itens.getPrecoUnitario(), itens.getValorCompra() };

					modelo.insertRow(0, obj);

					txtPreco.setText(String.valueOf(produto.getPrecoUnitario()));

					dao.salvar(itens);

//					itensPedido = new ArrayList<ItensPedido>();
//					itensPedido.add(itens);
//					BigDecimal total = new BigDecimal(0);
//					BigDecimal valor = new BigDecimal(0);
//					for (ItensPedido p : itensPedido) {
//					valor = valor.add(p.getValorCompra());
//					total = total.add(valor);
//					}
//					
//					txtTotal.setText(String.valueOf(total));

					txtQtd.setText("");
					txtBuscar.setText("");

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro de NumberFormat");
					txtQtd.setText("");
					txtBuscar.setText("");
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Erro de Hedless");
					txtQtd.setText("");
					txtBuscar.setText("");
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Nulo ou inexistente");
					txtQtd.setText("");
					txtBuscar.setText("");
					e1.printStackTrace();
				} catch (NoResultException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum item encontrado para esta buscar");
					txtQtd.setText("");
					txtBuscar.setText("");
					e1.printStackTrace();
				}

			}
		});

		comprar = new JButton("Comprar");
		comprar.setBounds(955, 515, 100, 30);
		comprar.setFont((new Font("arial black", Font.BOLD, 13)));
		comprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		painel.add(buscar);

		painel.add(comprar);

		painel.add(scroll);

		painel.add(valorTotal);

		painel.add(precoUnd);

		painel.add(codPedido);

		painel.add(quantidade);

		painel.add(titulo);

		painel.add(pane);

		this.add(painel);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			TelaVendas venda = new TelaVendas();
		});
	}

}
