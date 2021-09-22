package br.com.casa.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaVendas extends JFrame {
	private static final long serialVersionUID = 1L;

	protected JFrame frame;

	public TelaVendas() {
		super("Vendas");
		tela();
	}

	@SuppressWarnings("static-access")
	void tela() {
		frame = new JFrame();
		this.setSize(1300, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setBackground(getBackground().RED);
		this.setResizable(false);

		JPanel tela0 = new JPanel();
		tela0.setBackground(getBackground().RED);
		tela0.setBounds(0, 0, 1300, 50);

		JPanel tela1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela1.setBackground(getBackground().RED);
		tela1.setBounds(0, 50, 1300, 70);
		JLabel nomeMercado = new JLabel("MERCADO DOÇE COMPRA");
		nomeMercado.setFont(new Font("arial", Font.BOLD, 30));
		tela1.add(nomeMercado);

		JPanel tela2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela2.setBackground(getBackground().RED);
		tela2.setBounds(0, 120, 1300, 50);
		tela2.setAlignmentX(15);
		JLabel codigo = new JLabel("Cod.");
		codigo.setFont(new Font("arial", Font.BOLD, 15));
		tela2.add(codigo);
		JTextField txtcodigo = new JTextField(5);
		tela2.add(txtcodigo);

		JLabel produto = new JLabel("Produto ");
		produto.setFont(new Font("arial", Font.BOLD, 15));
		tela2.add(produto);
		JTextField txtProduto = new JTextField(10);
		tela2.add(txtProduto);
		JButton buscar = new JButton("Buscar");
		tela2.add(buscar);

		JLabel quantidade = new JLabel("Quantidade ");
		quantidade.setFont(new Font("arial", Font.BOLD, 15));
		tela2.add(quantidade);
		JTextField txtQuantidade = new JTextField(7);
		tela2.add(txtQuantidade);
		JButton adicionar = new JButton("Adicionar");
		tela2.add(adicionar);

		JPanel tela3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela3.setBackground(getBackground().red);
		tela3.setBounds(0, 170, 1300, 50);
		JLabel precoUnitario = new JLabel("PreçoUnd R$");
		precoUnitario.setFont(new Font("arial", Font.BOLD, 15));
		tela3.add(precoUnitario);
		JTextField txtPrecoUnitario = new JTextField(7);
		tela3.add(txtPrecoUnitario);

		JLabel fornecedor = new JLabel("Fornecedor ");
		fornecedor.setFont(new Font("arial", Font.BOLD, 15));
		tela3.add(fornecedor);
		JTextField txtFornecedor = new JTextField(10);
		tela3.add(txtFornecedor);

		JLabel data = new JLabel("Data ");
		data.setFont(new Font("arial", Font.BOLD, 15));
		tela3.add(data);
		JTextField txtData = new JTextField(10);
		tela3.add(txtData);
		JButton remover = new JButton("Remover");
		tela3.add(remover);

		JPanel tela4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela4.setBackground(getBackground().RED);
		tela4.setBounds(0, 220, 1300, 50);
		JLabel pagamento = new JLabel("Pagamento");
		pagamento.setFont(new Font("arial", Font.BOLD, 15));
		tela4.add(pagamento);
		JTextField txtPagamento = new JTextField(10);
		tela4.add(txtPagamento);

		JLabel valorTotal = new JLabel("Valor Total");
		valorTotal.setFont(new Font("arial", Font.BOLD, 15));
		tela4.add(valorTotal);
		JTextField txtvalorTotal = new JTextField(10);
		tela4.add(txtvalorTotal);

		JLabel troco = new JLabel("Troco ");
		troco.setFont(new Font("arial", Font.BOLD, 15));
		tela4.add(troco);
		JTextField txtTroco = new JTextField(10);
		tela4.add(txtTroco);

		JPanel tela5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela5.setBackground(getBackground().red);
		tela5.setBounds(0, 270, 1300, 380);
		JTextArea area = new JTextArea(23, 80);
		tela5.add(area);

		JPanel tela6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tela6.setBackground(getBackground().red);
		tela6.setBounds(0, 650, 1300, 50);

		JLabel codVendedor = new JLabel("Cod.");
		codVendedor.setFont(new Font("arial", Font.BOLD, 15));
		tela6.add(codVendedor);
		JTextField txtCodVendedor = new JTextField(7);
		tela6.add(txtCodVendedor);

		JLabel nomeVendedor = new JLabel("Nome do Vendedor");
		nomeVendedor.setFont(new Font("arial", Font.BOLD, 15));
		tela6.add(nomeVendedor);
		JTextField txtNomeVendedor = new JTextField(15);
		tela6.add(txtNomeVendedor);

		this.add(tela0);
		this.add(tela1);
		this.add(tela2);
		this.add(tela3);
		this.add(tela4);
		this.add(tela5);
		this.add(tela6);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			TelaVendas venda = new TelaVendas();
		});
	}

}
