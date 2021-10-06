package br.com.casa.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItensPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	Produto produto;

	@ManyToOne
	Pedido pedido;

	private Integer quantidade;

	@Column(precision = 6, scale = 2)
	private BigDecimal precoUnitario;

	@Column(precision = 6, scale = 2)
	private BigDecimal valorCompra;

	public ItensPedido() {
		super();
	}

	public ItensPedido(Long id, Produto produto, Pedido pedido, Integer quantidade, BigDecimal precoUnitario) {
		super();
		this.id = id;
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.precoUnitario = produto.getPrecoUnitario();
		this.valorCompra = this.precoUnitario.multiply(new BigDecimal(quantidade));
	}

	public ItensPedido(Produto produto, Pedido pedido, Integer quantidade) {
		super();
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.precoUnitario = produto.getPrecoUnitario();
		this.valorCompra = this.precoUnitario.multiply(new BigDecimal(quantidade));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public BigDecimal Total() {
		BigDecimal total = BigDecimal.ZERO;
		pedido.getPedidos().forEach(itens -> {
			total.add(itens.getValorCompra());
		});
		return total;
	}

}
