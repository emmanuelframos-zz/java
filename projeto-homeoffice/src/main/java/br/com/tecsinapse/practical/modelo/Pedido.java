package br.com.tecsinapse.practical.modelo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
	private String cnpjCliente;
	private String usuarioSolicitante;
	private List<ItemPedido> itens = new ArrayList<>();
	private BigDecimal valorTotal;

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

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
		if (itens.size() > 1)
			tratarItensPedido();
	}

	private void tratarItensPedido() {
		Map<String, List<ItemPedido>> itensAgrupados = getItensAgrupados();

		for (String chave : itensAgrupados.keySet()){			
			List<ItemPedido> itensRepetidos = itensAgrupados.get(chave);
			if (itensRepetidos!=null && itensRepetidos.size() > 1){
				ItemPedido novoItem = new ItemPedido();
				
				int quantidade = 0;
				BigDecimal valorTotal = new BigDecimal("0");
				MathContext contexto = new MathContext(3, RoundingMode.HALF_EVEN);
				for (ItemPedido itemRepetido : itensRepetidos){
					quantidade+=itemRepetido.getQuantidade();
					valorTotal = valorTotal.add(itemRepetido.getValorTotal(), contexto);
					novoItem.setCnpjCliente(itemRepetido.getCnpjCliente());
					novoItem.setCodigoItem(itemRepetido.getCodigoItem());
					novoItem.setUsuarioSolicitante(itemRepetido.getUsuarioSolicitante());					
				}
				novoItem.setQuantidade(quantidade);
				novoItem.setValorTotal(valorTotal);
				
				itens.removeAll(itensRepetidos);
				itens.add(novoItem);
			}
		}			
	}

	private Map<String, List<ItemPedido>> getItensAgrupados(){
		Map<String, List<ItemPedido>> itensAgrupados = new LinkedHashMap<>();

		for (ItemPedido itemPedido : itens){
			String chave = itemPedido.getCodigoItem();
			if (itensAgrupados.get(chave) == null){
				itensAgrupados.put(chave, new ArrayList<ItemPedido>());
			}
			itensAgrupados.get(chave).add(itemPedido);
		}
		return itensAgrupados;
	}

	public BigDecimal getValorTotal() {		
		this.valorTotal = new BigDecimal("0");
		for (ItemPedido itemPedido : itens){
			this.valorTotal = this.valorTotal.add(itemPedido.getValorTotal(), new MathContext(3, RoundingMode.HALF_EVEN));
		}
		return this.valorTotal;
	}	

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}