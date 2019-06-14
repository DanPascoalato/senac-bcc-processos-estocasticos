package simuladores;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import modelos.Empresa;
import modelos.Produto;
import modelos.Vendas;

public class Simulacao1 implements Basesimulacao {

	private Empresa empresa;
	private final static Integer PRIMEIRO_MES = 250;
	private final static Integer TERCEIRO_MES = 320;

	public Simulacao1(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public Empresa calculeVendasde(Produto... produtos) {
		Produto p1 = produtos[0];
		Produto p2 = produtos[1];

		Integer p1VendasemJan = Basesimulacao.rng(PRIMEIRO_MES);
		Vendas janSales = Vendas.of(Month.JANUARY)
			.addItem(p1, p1VendasemJan)
			.addItem(p2, PRIMEIRO_MES - p1VendasemJan);

		Vendas febSales = Vendas.of(Month.FEBRUARY)
			.addItem(p1, Double.valueOf(janSales.getItems().get(0).getQuantidade() * 1.1).intValue())
			.addItem(p2, Double.valueOf(janSales.getItems().get(1).getQuantidade() * 1.1).intValue());

		List<Vendas> sales = IntStream.rangeClosed(3, 12).mapToObj(month -> {
			int p1SalesInMarch = Basesimulacao.rng(TERCEIRO_MES);
			return Vendas.of(Month.of(month))
				.addItem(p1, p1SalesInMarch)
				.addItem(p2, TERCEIRO_MES - p1SalesInMarch);
		}).collect(Collectors.toList());

		sales.add(0, janSales);
		sales.add(1, febSales);
		return new Empresa(empresa.getCapacity(), empresa.getMonthlyExpenses(), empresa.getMonthlyPayroll(), sales);
	}

}
