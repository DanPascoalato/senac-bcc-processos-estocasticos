package br.senac.sp.probabilidade.model;

public class Expenses {

	private Double rent;
	private Double electricityBill;
	private Double waterSewerBill;

	private Expenses(Double rent, Double electricityBill, Double waterSewerBill) {
		this.rent = rent;
		this.electricityBill = electricityBill;
		this.waterSewerBill = waterSewerBill;
	}

	public Double getSubtotal() {
		return rent + electricityBill + waterSewerBill;
	}

	public Double getRent() {
		return rent;
	}

	public Double getElectricityBill() {
		return electricityBill;
	}

	public Double getWaterSewerBill() {
		return waterSewerBill;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Double waterSewerBill;
		private Double electrictyBill;
		private Double rent;

		public Builder waterSewerBill(Double value) {
			this.waterSewerBill = value;
			return this;
		}

		public Builder electrictyBill(Double value) {
			this.electrictyBill = value;
			return this;
		}

		public Builder rent(Double value) {
			this.rent = value;
			return this;
		}

		public Expenses build() {
			return new Expenses(rent, electrictyBill, waterSewerBill);
		}

	}

}
