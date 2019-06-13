package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;
import br.senac.sp.probabilidade.model.Product;
import br.senac.sp.probabilidade.model.Sales;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Q2Simulation implements Simulation {

	private Company company;
	private final static Integer FIRST_MONTH_SALES = 300;

	public Q2Simulation(Company company) {
		this.company = company;
	}

	@Override
	public Company computeSalesOf(Product... products) {
		Product p1 = products[0];
		Product p2 = products[1];

		Integer totalSales = FIRST_MONTH_SALES;
		List<Sales> sales = new ArrayList<>();

		for (Month month : Month.values()) {
			Integer p1Sales = Simulation.rng(totalSales);
			sales.add(Sales.of(month)
				.addItem(p1, p1Sales)
				.addItem(p2, totalSales - p1Sales));
			totalSales = salesVariance(totalSales);
		}

		return new Company(company.getCapacity(), company.getExpenses(), company.getPayroll(), sales);
	}

	private Integer salesVariance(Integer totalSales) {
		Integer rng = Simulation.rng(100);

		if (rng >= 0 && rng <= 50) {
			int _totalSales = Math.round(totalSales * 1.1f);
			return (_totalSales > company.getCapacity()) ? company.getCapacity() : _totalSales;
		}

		return Math.round(totalSales * 0.9f);
	}


}
