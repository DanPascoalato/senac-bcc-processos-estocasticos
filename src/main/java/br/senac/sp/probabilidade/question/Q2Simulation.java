package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;
import br.senac.sp.probabilidade.model.Product;
import br.senac.sp.probabilidade.model.Sales;

import java.util.ArrayList;
import java.util.List;

public class Q2Simulation implements Simulation {

	private Company company;
	private List<Sales> sales;

	public Q2Simulation(Company company) {
		this.company = company;
		this.sales = new ArrayList<>();
	}

	@Override
	public Simulation runWith(Product... products) {
		return this;
	}
}
