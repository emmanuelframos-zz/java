package br.com.tecsinapse.practical.modelo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ItemPedido {
	private String cnpjCliente;
	private String usuarioSolicitante;
	private String codigoItem;
	private int quantidade;
	private BigDecimal valorTotal;
	private BigDecimal valorUnitario;

	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

	public String getUsuarioSolicitante() {
		return usuarioSolicitante;
	}

	public void setUsuarioSolicitante(String usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorUnitario() {
		this.valorUnitario = new BigDecimal("0");
		this.valorUnitario = valorTotal.divide(new BigDecimal(quantidade), new MathContext(3, RoundingMode.HALF_EVEN));
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}	

	@Override
	public String toString() {
		return "[cnpj=" + cnpjCliente + " - usuario=" + usuarioSolicitante
				+ " - codigo=" + codigoItem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoItem == null) ? 0 : codigoItem.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
			return false;
		return true;
	}		
}