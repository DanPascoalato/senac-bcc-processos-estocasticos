package simuladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Month;

import modelos.Empresa;



public class Report {

	public static void geraReporte(Empresa company, String filename) throws IOException {
		Path filepath = Paths.get("reports/" + filename);
		Files.createDirectories(filepath.getParent());
		Files.write(filepath, buildHeader(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		Files.write(filepath, buildData(company), StandardOpenOption.APPEND);
	}

	private static byte[] buildHeader() {
		return new StringBuilder()
			.append("Mes;")

			.append("P1 - Unidades vendidas").append(";")
			.append("P1 - Preço de unidade").append(";")
			.append("P1 - Custo de unidade").append(";")
			.append("P1 - Ganho").append(";")
			.append("P1 - Custo").append(";")
			.append("P1 - Lucro").append(";")

			.append("P2 - Unidades vendidas").append(";")
			.append("P2 - Preço de unidade").append(";")
			.append("P2 - Custo de unidade").append(";")
			.append("P2 - Ganho").append(";")
			.append("P2 - Custo").append(";")
			.append("P2 - Lucro").append(";")

			.append("Unidades vendidas").append(";")
			.append("Ganho das vendas").append(";")
			.append("Custo de produção").append(";")
			.append("Lucro total - antes de gastos extras").append(";")

			.append("Salários").append(";")
			.append("Gastos gerais").append(";")

			.append("Gastos totais").append(";")
			.append("Lucro total - final").append("\n")
			.toString().getBytes();
	}

	public Report() {
	}

	private static byte[] buildData(Empresa company) {
		StringBuilder sb = new StringBuilder();

		company.getSales().forEach(monthlySales -> {
			sb.append(monthlySales.getMonth().getValue()).append(";");

			monthlySales.getItems().forEach(item ->
				sb.append(item.getQuantidade()).append(";")
					.append(item.getProduct().getPrecoUnidade()).append(";")
					.append(item.getProduct().getGastoProducao()).append(";")
					.append(item.getGanhoSub()).append(";")
					.append(item.getGastoSub()).append(";")
					.append(item.getProfitSubtotal()).append(";")
			);

			sb.append(monthlySales.getUnidadesVendidas()).append(";")
				.append(monthlySales.getGanhoSub()).append(";")
				.append(monthlySales.getGastoSub()).append(";")
				.append(monthlySales.getLucroSub()).append(";");

			sb.append(company.getMonthlyPayroll().getSubtotal()).append(";")
				.append(company.getMonthlyExpenses().getSubtotal()).append(";");

			Month month = monthlySales.getMonth();
			sb.append(company.getCustoTotalem(month)).append(";")
				.append(company.getLucroem(month)).append("\n");
		});

		return sb.toString().getBytes();
	}

}
