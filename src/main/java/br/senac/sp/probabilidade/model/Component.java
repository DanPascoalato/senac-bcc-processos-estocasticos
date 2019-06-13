package br.senac.sp.probabilidade.model;

public class Component {

	private String name;
	private Double productionCost;

	public Component(String name, Double productionCost) {
		this.name = name;
		this.productionCost = productionCost;
	}

	public String getName() {
		return name;
	}

	public Double getProductionCost() {
		return productionCost;
	}
}
