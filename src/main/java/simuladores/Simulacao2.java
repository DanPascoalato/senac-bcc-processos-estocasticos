package simuladores;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import modelos.Empresa;
import modelos.Produto;
import modelos.Vendas;

public class Simulacao2 implements Basesimulacao {

	private Empresa company;
	private final static Integer FIRST_MONTH_SALES = 300;

	public Simulacao2(Empresa company) {
		this.company = company;
	}

	@Override
	public Empresa calculeVendasde(Produto... products) {
		Produto p1 = products[0];
		Produto p2 = products[1];

		Integer totalSales = FIRST_MONTH_SALES;
		List<Vendas> sales = new ArrayList<>();

		for (Month month : Month.values()) {
			Integer p1Sales = Basesimulacao.rng(totalSales);
			sales.add(Vendas.of(month)
				.addItem(p1, p1Sales)
				.addItem(p2, totalSales - p1Sales));
			totalSales = salesVariance(totalSales);
		}

		return new Empresa(company.getCapacity(), company.getMonthlyExpenses(), company.getMonthlyPayroll(), sales);
	}

	private Integer salesVariance(Integer totalSales) {
		Integer rng = Basesimulacao.rng(100);

		if (rng >= 0 && rng <= 50) {
			int _totalSales = Math.round(totalSales * 1.1f);
			return (_totalSales > company.getCapacity()) ? company.getCapacity() : _totalSales;
		}

		return Math.round(totalSales * 0.9f);
	}


}
