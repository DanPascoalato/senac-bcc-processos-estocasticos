package br.senac.sp.probabilidade;

import br.senac.sp.probabilidade.model.Company;
import br.senac.sp.probabilidade.model.Expenses;
import br.senac.sp.probabilidade.model.Payroll;
import br.senac.sp.probabilidade.model.Product;

public class Application {

	public static void main(String[] args) {
		Product p1 = new Product(2, 1);
		Product p2 = new Product(2, 3);
		Company company = Company.builder()
			.capacity(400)
			.expenses(buildExpenses())
			.payroll(buildPayroll())
			.build();


	}

	private static Payroll buildPayroll() {
		return Payroll.builder()
			.productionLineSalary(3500.00)
			.administrationalary(4000.00)
			.generalServicesSalary(2000.00)
			.directorSalary(6000.00)
			.employeesInProduction(5)
			.employeesInAdmin(2)
			.employeesInGeneralServices(2)
			.numberOfDirectors(1)
			.build();
	}

	private static Expenses buildExpenses() {
		return Expenses.builder()
			.rent(3500.00)
			.electrictyBill(900.00)
			.waterSewerBill(600.00)
			.build();
	}

}
