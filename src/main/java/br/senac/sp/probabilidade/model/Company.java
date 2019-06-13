package br.senac.sp.probabilidade.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private Integer capacity;
	private Expenses expenses;
	private Payroll payroll;
	private List<Sales> sales;

	private Company(Integer capacity, Expenses expenses, Payroll payroll, List<Sales> sales) {
		this.capacity = capacity;
		this.expenses = expenses;
		this.payroll = payroll;
		this.sales = sales;
	}

	public Double getTotalProfit() {
		return getTotalRevenue() - getTotalCosts();
	}

	public Double getTotalRevenue() {
		return sales.stream()
			.map(Sales::getRevenueSubtotal)
			.reduce(0.0, (a,b) -> a+b);
	}

	public Double getTotalCosts() {
		return getTotalProductionCosts() +
			getExpenses().getSubtotal() +
			getPayroll().getSubtotal();
	}


	public Double getTotalProductionCosts() {
		return sales.stream()
			.map(Sales::getCostSubtotal)
			.reduce(0.0, (a,b) -> a+b);
	}

	public Expenses getExpenses() {
		return expenses;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public Integer getCapacity() {
		return capacity;
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

		public Company build() {
			return new Company(capacity, expenses, payroll, sales);
		}
	}

}
