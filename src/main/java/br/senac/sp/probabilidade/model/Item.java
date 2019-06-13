package br.senac.sp.probabilidade.model;

public class Item {

	private Product product;
	private Integer quantity;

	public Item(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return product.getUnitPrice() * quantity;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}
}
