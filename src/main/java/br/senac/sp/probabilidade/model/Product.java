package br.senac.sp.probabilidade.model;

public class Product {

	private Integer qttyA;
	private Integer qttyB;

	public Product(Integer qttyA, Integer qttyB) {
		this.qttyA = qttyA;
		this.qttyB = qttyB;
	}

	public Integer getQttyA() {
		return qttyA;
	}

	public Integer getQttyB() {
		return qttyB;
	}

}
