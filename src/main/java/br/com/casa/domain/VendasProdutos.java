package br.com.casa.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VendasProdutos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String marca;

	private Integer quantidade;
	@Column(precision = 6, scale = 2)
	private BigDecimal precoUnitario;

	private LocalDate data;

	@OneToMany
	private List<Produto> produtos = new ArrayList<>();

	public VendasProdutos() {
		super();
		this.data = LocalDate.now();
	}

	public VendasProdutos(String nome, String marca, Integer quantidade, BigDecimal precoUnitario, LocalDate data,
			List<Produto> produtos) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.data = LocalDate.now();
		this.produtos = produtos;
	}

	public VendasProdutos(Long id, String nome, String marca, Integer quantidade, BigDecimal precoUnitario,
			LocalDate data, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.data = LocalDate.now();
		this.produtos = produtos;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		VendasProdutos other = (VendasProdutos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendasProdutos [id = " + id + ", nome = " + nome + ", marca = " + marca + ", quantidade = " + quantidade
				+ ", precoUnitario = " + precoUnitario + ", data = " + data + ", produtos = " + produtos + "]";
	}

}
