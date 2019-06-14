package modelos;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Vendas {

	private List<Item> items;
	private Month mes;

	private Vendas(List<Item> itens, Month mes) {
		this.items = itens;
		this.mes = mes;
	}

	public static Vendas of(Month mes) {
		return new Vendas(new ArrayList<>(), mes);
	}

	public static Vendas of(Integer mes) {
		return new Vendas(new ArrayList<>(), Month.of(mes));
	}

	public Vendas addItem(Item item) {
		items.add(item);
		return this;
	}

	public Vendas addItem(Produto produto, Integer quantidade) {
		items.add(new Item(produto, quantidade));
		return this;
	}

	public Integer getUnidadesVendidas() {
		return items.stream()
			.map(Item::getQuantidade)
			.reduce(0, (a, b) -> a + b);
	}

	public Double getGanhoSub() {
		return items.stream()
			.map(Item::getGanhoSub)
			.reduce(0.0, (a, b) -> a + b);
	}

	public Double getGastoSub() {
		return items.stream()
			.map(Item::getGastoSub)
			.reduce(0.0, (a, b) -> a + b);
	}

	public Double getLucroSub() {
		return getGanhoSub() - getGastoSub();
	}

	public List<Item> getItems() {
		return items;
	}

	public Month getMonth() {
		return mes;
	}
}
