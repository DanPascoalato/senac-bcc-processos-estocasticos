package br.senac.sp.probabilidade.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {

	private List<Component> components;
	private Double unitPrice;

	private Product(List<Component> components, Double unitPrice) {
		this.components = components;
		this.unitPrice = unitPrice;
	}

	public Double getProductionCost() {
		return components.stream()
			.map(Component::getProductionCost)
			.reduce(0.0, (a,b) -> a+b);
	}


	public List<Component> getComponents() {
		return components;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private List<Component> components = new ArrayList<>();
		private Double unitPrice;

		public Builder component(Component component, Integer qtty) {
			this.components.addAll(Collections.nCopies(qtty, component));
			return this;
		}

		public Builder unitPrice(Double unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}

		public Product build() {
			return new Product(components, unitPrice);
		}

	}

}
