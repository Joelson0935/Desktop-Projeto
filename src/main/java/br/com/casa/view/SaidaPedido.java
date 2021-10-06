package br.com.casa.view;

import br.com.casa.dao.Dao;
import br.com.casa.domain.Pedido;

public class SaidaPedido {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Dao<Pedido> dao = new Dao<Pedido>(Pedido.class);
		Pedido pedido = new Pedido();
		
		dao.salvar(pedido);
		
//		pedido = dao.buscarPorId(1L);
//
//		System.out.println(pedido.getPedidos());
		System.out.println(pedido.toString());

	}

}
