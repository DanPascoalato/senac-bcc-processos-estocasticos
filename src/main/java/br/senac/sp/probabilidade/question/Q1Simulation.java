package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;
import br.senac.sp.probabilidade.model.Product;
import br.senac.sp.probabilidade.model.Sales;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1Simulation implements Simulation {

	private Company company;
	private final static Integer FIRST_MONTH_SALES = 250;
	private final static Integer THIRD_MONTH_SALES = 320;

	public Q1Simulation(Company company) {
		this.company = company;
	}

	@Override
	public Company computeSalesOf(Product... products) {
		Product p1 = products[0];
		Product p2 = products[1];

		Integer p1SalesInJan = Simulation.rng(FIRST_MONTH_SALES);
		Sales janSales = Sales.of(Month.JANUARY)
			.addItem(p1, p1SalesInJan)
			.addItem(p2, FIRST_MONTH_SALES - p1SalesInJan);

		Sales febSales = Sales.of(Month.FEBRUARY)
			.addItem(p1, Double.valueOf(janSales.getItems().get(0).getQuantity() * 1.1).intValue())
			.addItem(p2, Double.valueOf(janSales.getItems().get(1).getQuantity() * 1.1).intValue());

		List<Sales> sales = IntStream.rangeClosed(3, 12).mapToObj(month -> {
			int p1SalesInMarch = Simulation.rng(THIRD_MONTH_SALES);
			return Sales.of(Month.of(month))
				.addItem(p1, p1SalesInMarch)
				.addItem(p2, THIRD_MONTH_SALES - p1SalesInMarch);
		}).collect(Collectors.toList());

		sales.add(0, janSales);
		sales.add(1, febSales);
		return new Company(company.getCapacity(), company.getExpenses(), company.getPayroll(), sales);
	}

}
