package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
			.append("P1 (revenue_subtotal)").append(";")
			.append("P1 (unit_cost)").append(";")
			.append("P1 (cost_subtotal)").append(";")
			.append("P1 (profit_subtotal)").append(";")

			.append("P2 (units_sold)").append(";")
			.append("P2 (unit_price)").append(";")
			.append("P2 (revenue_subtotal)").append(";")
			.append("P2 (unit_cost)").append(";")
			.append("P2 (cost_subtotal)").append(";")
			.append("P2 (profit_subtotal)").append(";")

			.append("Total Units Sold").append(";")
			.append("Total Revenue").append(";")
			.append("Total Cost").append(";")
			.append("Total Profit").append(";")

			.append("Payroll").append(";")
			.append("Other Expenses").append(";")

			.append("Overall Costs").append(";")
			.append("Overall Profit").append("\n")
			.toString().getBytes();
	}

	public Report() {
	}

	private static byte[] buildData(Company company) {
		StringBuilder sb = new StringBuilder();

		company.getSales().forEach(sales -> {
			sb.append(sales.getMonth()).append(";");

			sales.getItems().forEach(item ->
				sb.append(item.getQuantity()).append(";")
					.append(item.getProduct().getUnitPrice()).append(";")
					.append(item.getRevenueSubtotal()).append(";")
					.append(item.getProduct().getProductionCost()).append(";")
					.append(item.getCostSubtotal()).append(";")
					.append(item.getProfitSubtotal()).append(";")
			);

			sb.append(sales.getUnitsSold()).append(";")
				.append(sales.getRevenueSubtotal()).append(";")
				.append(sales.getCostSubtotal()).append(";")
				.append(sales.getProfitSubtotal()).append(";");

			sb.append(company.getPayroll().getSubtotal()).append(";")
				.append(company.getExpenses().getSubtotal()).append(";");

			sb.append(company.getTotalCosts()).append(";")
				.append(company.getTotalProfit()).append("\n");
		});

		return sb.toString().getBytes();
	}

}
