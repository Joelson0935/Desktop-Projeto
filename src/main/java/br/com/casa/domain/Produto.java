package br.com.casa.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String marca;

	private Integer quantidade = 0;
	@Column(precision = 6, scale = 2)
	private BigDecimal precoUnitario = BigDecimal.valueOf(0.0);

	public Produto() {
		super();
	}

	public Produto(Long id, String produto, String marca, Integer quantidade, BigDecimal precoUnitario) {
		super();
		this.id = id;
		this.nome = produto;
		this.marca = marca;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public Produto(String produto, String marca, Integer quantidade, BigDecimal precoUnitario) {
		super();
		this.nome = produto;
		this.marca = marca;
		this.quantidade = quantidade = (quantidade == null) ? (quantidade = 0) : quantidade;
		this.precoUnitario = precoUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id = " + id + ", nome = " + nome + ", marca = " + marca + ", quantidade = " + quantidade
				+ ", precoUnitario = " + precoUnitario + "]";
	}

}
