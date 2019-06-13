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
	}

	private static byte[] buildHeader() {
		StringBuilder sb = new StringBuilder();
		sb.append("# Month;");
		sb.append("P1 (unit_sales); P1 (revenue); P1 (production_cost); P1 (profit);");
		sb.append("P2 (unit_sales); P2 (revenue); P2 (production_cost);  P2 (profit);");
		sb.append("Sales Revenue; Sales Prod. Cost; Sales Profit");
		sb.append("Payroll; Other Expenses");
		sb.append("\n");
		return sb.toString().getBytes();
	}

}
