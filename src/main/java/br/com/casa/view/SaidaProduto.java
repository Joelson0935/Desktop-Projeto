package br.com.casa.view;

import java.math.BigDecimal;

import br.com.casa.dao.Dao;
import br.com.casa.domain.Produto;

public class SaidaProduto {

	public static void main(String[] args) {

		Dao<Produto> dao = new Dao<Produto>(Produto.class);

		Produto produto = new Produto(11L, "Mouse", "Fortrek", 25, BigDecimal.valueOf(23.95));
//		Produto produto = new Produto(6L, "miccro-ondas", 3, BigDecimal.valueOf(899));
		dao.atualizar(produto, produto.getId());
//		var produto = new Produto();
//		produto = dao.buscarPorId(1L);
//		produto.setId(6L);

//		dao.deletar(produto.getId());

		System.out.println(produto.toString());

		dao.fecharEM();
	}

}
