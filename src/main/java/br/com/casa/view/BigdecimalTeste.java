package br.com.casa.view;

import java.math.BigDecimal;

public class BigdecimalTeste {

	public static void main(String[] args) {

		BigDecimal valor1 = BigDecimal.ZERO;
		BigDecimal valor2 = new BigDecimal(30);
		BigDecimal valor3 = new BigDecimal(110);
		BigDecimal valor4 = BigDecimal.ZERO;
		BigDecimal valor5 = new BigDecimal(359);

		valor1 = valor1.add(valor2);

		System.out.println("Resultado é : " + valor1);
	}

}
