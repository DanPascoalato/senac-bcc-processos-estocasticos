package br.senac.sp.probabilidade.model;

public class Company {

	private Integer capacity;
	private Expenses expenses;
	private Payroll payroll;
	private Sales sales;

	private Company(Integer capacity, Expenses expenses, Payroll payroll) {
		this.capacity = capacity;
		this.expenses = expenses;
		this.payroll = payroll;
	}

	public Double getTotalRevenue() {
		return sales.getTotalRevenue();
	}

	public Double getProfit() {
		return getTotalRevenue() - getTotalCosts();
	}

	public Double getTotalCosts() {
		return getProductionCosts() + getExpenses().getSubtotal() + getPayroll().getSubtotal();
	}

	public Double getProductionCosts() {
		return sales.getTotalCost();
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

		public Company build() {
			return new Company(capacity, expenses, payroll);
		}
	}

}
