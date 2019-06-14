package br.senac.sp.probabilidade.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Company {

	private Integer capacity;
	private Expenses monthlyExpenses;
	private Payroll monthlyPayroll;
	private List<Sales> sales;

	public Company(Integer capacity, Expenses monthlyExpenses, Payroll monthlyPayroll, List<Sales> sales) {
		this.capacity = capacity;
		this.monthlyExpenses = monthlyExpenses;
		this.monthlyPayroll = monthlyPayroll;
		this.sales = sales;
	}

	public Double getProfitIn(Month month) {
		return getRevenueIn(month) - getOverallCostsIn(month);
	}

	public Double getRevenueIn(Month month) {
		return sales.get(month.getValue()-1).getRevenueSubtotal();
	}

	public Double getOverallCostsIn(Month month) {
		return sales.get(month.getValue()-1).getCostSubtotal()
			+ getMonthlyExpenses().getSubtotal()
			+ getMonthlyPayroll().getSubtotal();
	}

	public Expenses getMonthlyExpenses() {
		return monthlyExpenses;
	}

	public Payroll getMonthlyPayroll() {
		return monthlyPayroll;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public List<Sales> getSales() {
		return sales;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer capacity;
		private Expenses expenses;
		private Payroll payroll;
		private List<Sales> sales = new ArrayList<>();

		public Builder capacity(Integer capacity) {
			this.capacity = capacity;
			return this;
		}

		public Builder expenses(Expenses expenses) {
			this.expenses = expenses;
			return this;
		}

		public Builder payroll(Payroll payroll) {
			this.payroll = payroll;
			return this;
		}

		public Builder sales(Sales sales) {
			this.sales.add(sales);
			return this;
		}

		public Builder totalSales(List<Sales> sales) {
			this.sales = sales;
			return this;
		}

		public Company build() {
			return new Company(capacity, expenses, payroll, sales);
		}
	}

}
