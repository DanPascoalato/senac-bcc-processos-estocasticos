package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Month;

public class Report {

	public static void generateReport(Company company, String filename) throws IOException {
		Path filepath = Paths.get("reports/" + filename);
		Files.createDirectories(filepath.getParent());
		Files.write(filepath, buildHeader(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		Files.write(filepath, buildData(company), StandardOpenOption.APPEND);
	}

	private static byte[] buildHeader() {
		return new StringBuilder()
			.append("# Month;")

			.append("P1 (units_sold)").append(";")
			.append("P1 (unit_price)").append(";")
			.append("P1 (unit_cost)").append(";")
			.append("P1 (revenue_subtotal)").append(";")
			.append("P1 (cost_subtotal)").append(";")
			.append("P1 (profit_subtotal)").append(";")

			.append("P2 (units_sold)").append(";")
			.append("P2 (unit_price)").append(";")
			.append("P2 (unit_cost)").append(";")
			.append("P2 (revenue_subtotal)").append(";")
			.append("P2 (cost_subtotal)").append(";")
			.append("P2 (profit_subtotal)").append(";")

			.append("Sales Units Sold").append(";")
			.append("Sales Revenue").append(";")
			.append("Sales Production Cost").append(";")
			.append("Sales Profit").append(";")

			.append("Payroll").append(";")
			.append("Other Expenses").append(";")

			.append("Overall Monthly Costs").append(";")
			.append("Overall Monthly Profit").append("\n")
			.toString().getBytes();
	}

	public Report() {
	}

	private static byte[] buildData(Company company) {
		StringBuilder sb = new StringBuilder();

		company.getSales().forEach(monthlySales -> {
			sb.append(monthlySales.getMonth()).append(";");

			monthlySales.getItems().forEach(item ->
				sb.append(item.getQuantity()).append(";")
					.append(item.getProduct().getUnitPrice()).append(";")
					.append(item.getProduct().getProductionCost()).append(";")
					.append(item.getRevenueSubtotal()).append(";")
					.append(item.getCostSubtotal()).append(";")
					.append(item.getProfitSubtotal()).append(";")
			);

			sb.append(monthlySales.getUnitsSold()).append(";")
				.append(monthlySales.getRevenueSubtotal()).append(";")
				.append(monthlySales.getCostSubtotal()).append(";")
				.append(monthlySales.getProfitSubtotal()).append(";");

			sb.append(company.getMonthlyPayroll().getSubtotal()).append(";")
				.append(company.getMonthlyExpenses().getSubtotal()).append(";");

			Month month = monthlySales.getMonth();
			sb.append(company.getOverallCostsIn(month)).append(";")
				.append(company.getProfitIn(month)).append("\n");
		});

		return sb.toString().getBytes();
	}

}
