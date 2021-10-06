package br.com.casa.view;

import br.com.casa.dao.Dao;
import br.com.casa.domain.ItensPedido;
import br.com.casa.domain.Pedido;
import br.com.casa.domain.Produto;

public class SaidaItens {

	public static void main(String[] args) {

		Dao<Produto> daoPr = new Dao<Produto>(Produto.class);
//		Dao<Pedido> daoPe = new Dao<Pedido>(Pedido.class);
		Dao<ItensPedido> dao = new Dao<ItensPedido>(ItensPedido.class);
		Produto produto = new Produto();
		daoPr.buscarPorNome("mouse");
//		List<ItensPedido> itensPedidos = new ArrayList<ItensPedido>();
		Pedido pedido = new Pedido();

		ItensPedido itens = new ItensPedido(produto, pedido, 10);

		dao.salvar(itens);
		System.out.println(itens.toString());
	}

}
