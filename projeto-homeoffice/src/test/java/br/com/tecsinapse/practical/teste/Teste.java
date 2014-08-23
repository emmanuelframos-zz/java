package br.com.tecsinapse.practical.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.tecsinapse.practical.main.Main;
import br.com.tecsinapse.practical.modelo.ItemPedido;
import br.com.tecsinapse.practical.modelo.Pedido;

import com.google.common.collect.Lists;

public class Teste {

	@DataProvider(name = "itens")
	public Object[][] itens() {
		ItemPedido ip1 = gerarItemPedido("1", "1", "1", 1);
		ItemPedido ip2 = gerarItemPedido("2", "2", "2", 2);
		ItemPedido ip3 = gerarItemPedido("1", "1", "3", 3);
		ItemPedido ip4 = gerarItemPedido("1", "1", "3", 3);
		ItemPedido ip5 = gerarItemPedido("1", "1", "3", 6);

		Pedido p1 = gerarPedido(ip1.getCnpjCliente(),
				ip1.getUsuarioSolicitante(), ip1, ip3);

		Pedido p2 = gerarPedido(ip2.getCnpjCliente(),
				ip2.getUsuarioSolicitante(), ip2);

		Pedido p3 = gerarPedido(ip1.getCnpjCliente(),
				ip1.getUsuarioSolicitante(), ip1, ip5);

		return new Object[][] {
				{ Lists.newArrayList(ip1, ip2), Lists.newArrayList(p1, p2) },
				{ Lists.newArrayList(), Lists.newArrayList() },
				{ Lists.newArrayList(ip1, ip3, ip4), Lists.newArrayList(p3) } };
	}

	@Test(dataProvider = "itens", testName= "gerarPedidosAgrupados")
	public void gerarPedidosAgrupados(List<ItemPedido> itens,
			List<Pedido> pedidosEsperados) {
		List<Pedido> pedidos = Main.gerarPedidosAgrupados(itens);

		Assert.assertEquals(pedidos.size(), pedidosEsperados.size(),
				"número diferente de pedidos");

		for (Pedido pEsperado : pedidosEsperados) {
			boolean achouPedidoEsperado = false;
			for (Pedido p : pedidos) {
				if (pEsperado.getCnpjCliente().equals(p.getCnpjCliente())
						&& pEsperado.getUsuarioSolicitante().equals(
								p.getUsuarioSolicitante())) {

					for (ItemPedido ipEsperado : pEsperado.getItens()) {
						boolean achouItemPedidoEsperado = false;
						for (ItemPedido ip : p.getItens()) {
							if (ipEsperado.getCnpjCliente().equals(
									ip.getCnpjCliente())
									&& ipEsperado.getCodigoItem().equals(
											ip.getCodigoItem())
									&& ipEsperado.getUsuarioSolicitante()
											.equals(ip.getUsuarioSolicitante())
									&& ipEsperado.getQuantidade() == ip
											.getQuantidade()) {
								Assert.assertFalse(
										achouItemPedidoEsperado,
										"achou 2 vezes o item: "
												+ ipEsperado.getCodigoItem());
								achouItemPedidoEsperado = true;
							}
						}
						if (achouItemPedidoEsperado)
							break;

					}

					Assert.assertFalse(
							achouPedidoEsperado,
							"achou 2 vezes o pedido do cnpj: "
									+ pEsperado.getCnpjCliente()
									+ " e usuario: "
									+ pEsperado.getUsuarioSolicitante());
					achouPedidoEsperado = true;
				}

				if (achouPedidoEsperado)
					break;
			}
		}

	}

	public ItemPedido gerarItemPedido(String cnpjCliente,
			String usuarioSolicitante, String codigoItem, int quantidade) {
		ItemPedido ip = new ItemPedido();
		ip.setCnpjCliente(cnpjCliente);
		ip.setUsuarioSolicitante(usuarioSolicitante);
		ip.setCodigoItem(codigoItem);
		ip.setQuantidade(quantidade);
		ip.setValorTotal(new BigDecimal("1.00"));
		return ip;
	}

	public Pedido gerarPedido(String cnpjCliente, String usuarioSolicitante,
			ItemPedido... itens) {
		Pedido p = new Pedido();
		p.setCnpjCliente(cnpjCliente);
		p.setUsuarioSolicitante(usuarioSolicitante);
		if (itens != null) {
			p.getItens().addAll(Lists.newArrayList(itens));
		}
		return p;

	}	 
	
	@Test(testName="calculaValorTotalPedido")
	public void calculaValorTotalPedido(){
		Pedido pedido = new Pedido();
		
		List<ItemPedido> itens = new ArrayList<>();
		
		ItemPedido item1 = new ItemPedido();
		item1.setValorTotal(new BigDecimal("3.50"));
		item1.setCnpjCliente("1");
		item1.setCodigoItem("1");
		item1.setUsuarioSolicitante("1");
		item1.setQuantidade(1);
		itens.add(item1);
		
		ItemPedido item2 = new ItemPedido();
		item2.setValorTotal(new BigDecimal("4.50"));
		item2.setCnpjCliente("2");
		item2.setCodigoItem("2");
		item2.setUsuarioSolicitante("2");
		item1.setQuantidade(1);
		itens.add(item2);
		
		pedido.setItens(itens);		
		
		Assert.assertEquals(new BigDecimal("8.00"), pedido.getValorTotal());
	}
	
	@Test(testName="calculaValorUnitarioItemPedido")
	public void calculaValorUnitarioItemPedido(){			
		ItemPedido item = new ItemPedido();
		item.setValorTotal(new BigDecimal("4.50"));
		item.setCnpjCliente("1");
		item.setCodigoItem("1");
		item.setUsuarioSolicitante("1");
		item.setQuantidade(3);
				
		Assert.assertEquals(new BigDecimal("1.50"), item.getValorUnitario());
	}
}