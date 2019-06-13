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

	public Double getTotalCost() {
		return items.stream()
			.map(item -> item.getProduct().getProductionCost())
			.reduce(0.0, (a,b) -> a+b);
	}

	public Double getTotalRevenue() {
		return items.stream()
			.map(Item::getSubtotal)
			.reduce(0.0, (a,b) -> a+b);
	}

	public List<Item> getItems() {
		return items;
	}

	public Month getMonth() {
		return month;
	}
}