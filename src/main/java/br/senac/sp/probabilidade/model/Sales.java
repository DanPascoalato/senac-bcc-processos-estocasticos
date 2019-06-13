package br.senac.sp.probabilidade.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Sales {

	private List<Item> items;
	private Month month;

	private Sales(List<Item> items, Month month) {
		this.items = items;
		this.month = month;
	}

	public static Sales of(Month month) {
		return new Sales(new ArrayList<>(), month);
	}

	public static Sales of(Integer month) {
		return new Sales(new ArrayList<>(), Month.of(month));
	}

	public Sales addItem(Item item) {
		items.add(item);
		return this;
	}

	public Sales addItem(Product product, Integer quantity) {
		items.add(new Item(product, quantity));
		return this;
	}

	public Double getRevenueSubtotal() {
		return items.stream()
			.map(Item::getRevenueSubtotal)
			.reduce(0.0, (a,b) -> a+b);
	}

	public Double getCostSubtotal() {
		return items.stream()
			.map(Item::getCostSubtotal)
			.reduce(0.0, (a,b) -> a+b);
	}

	public Double getProfitSubtotal() {
		return getRevenueSubtotal() - getCostSubtotal();
	}

	public List<Item> getItems() {
		return items;
	}

	public Month getMonth() {
		return month;
	}
}
