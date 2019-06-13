package br.senac.sp.probabilidade.model;

import java.util.stream.Stream;

public class Payroll {

	private Double productionLineSalary;
	private Double administrationSalary;
	private Double generalServicesSalary;
	private Double directorSalary;
	private Integer employeesInProduction;
	private Integer employeesInAdmin;
	private Integer employeesInGS;
	private Integer numberOfDirectors;


	private Payroll(Double productionLineSalary, Double administrationSalary, Double generalServicesSalary, Double directorSalary,
	                Integer employeesInProduction, Integer employeesInAdmin, Integer employeesInGS, Integer numberOfDirectors) {
		this.productionLineSalary = productionLineSalary;
		this.administrationSalary = administrationSalary;
		this.generalServicesSalary = generalServicesSalary;
		this.directorSalary = directorSalary;
		this.employeesInProduction = employeesInProduction;
		this.employeesInAdmin = employeesInAdmin;
		this.employeesInGS = employeesInGS;
		this.numberOfDirectors = numberOfDirectors;
	}

	private Double getSubtotal() {
		return Stream.of(
			productionLineSalary * employeesInProduction,
			administrationSalary * employeesInAdmin,
			generalServicesSalary * employeesInGS,
			directorSalary * numberOfDirectors
		).reduce(0.0, (a, b) -> a + b);
	}

	public Double getProductionLineSalary() {
		return productionLineSalary;
	}

	public Double getAdministrationSalary() {
		return administrationSalary;
	}

	public Double getGeneralServicesSalary() {
		return generalServicesSalary;
	}

	public Double getDirectorSalary() {
		return directorSalary;
	}

	public Integer getEmployeesInProduction() {
		return employeesInProduction;
	}

	public Integer getEmployeesInAdmin() {
		return employeesInAdmin;
	}

	public Integer getEmployeesInGS() {
		return employeesInGS;
	}

	public Integer getNumberOfDirectors() {
		return numberOfDirectors;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Double productionLineSalary;
		private Double administrationSalary;
		private Double generalServicesSalary;
		private Double directorSalary;
		private Integer employeesInProduction;
		private Integer employeesInAdmin;
		private Integer employeesInGS;
		private Integer numberOfdirectors;

		public Builder productionLineSalary(Double salary) {
			this.productionLineSalary = salary;
			return this;
		}

		public Builder administrationalary(Double salary) {
			this.administrationSalary = salary;
			return this;
		}

		public Builder generalServicesSalary(Double salary) {
			this.generalServicesSalary = salary;
			return this;
		}

		public Builder directorSalary(Double salary) {
			this.directorSalary = salary;
			return this;
		}

		public Builder employeesInProduction(Integer numberOfEmployees) {
			this.employeesInProduction = numberOfEmployees;
			return this;
		}

		public Builder employeesInAdmin(Integer numberOfEmployes) {
			this.employeesInAdmin = numberOfEmployes;
			return this;
		}

		public Builder employeesInGeneralServices(Integer numberOfEmployees) {
			this.employeesInGS = numberOfEmployees;
			return this;
		}

		public Builder numberOfDirectors(Integer numberOfDirectors) {
			this.numberOfdirectors = numberOfDirectors;
			return this;
		}

		public Payroll build() {
			return new Payroll(productionLineSalary, administrationSalary, generalServicesSalary, directorSalary,
				employeesInProduction, employeesInAdmin, employeesInGS, numberOfdirectors);
		}

	}
}
