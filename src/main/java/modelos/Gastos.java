package modelos;

public class Gastos {

	private Double aluguel;
	private Double contaEletrica;
	private Double contadeAgua;

	private Gastos(Double aluguel, Double contaEletrica, Double contadeAgua) {
		this.aluguel = aluguel;
		this.contaEletrica = contaEletrica;
		this.contadeAgua = contadeAgua;
	}

	public Double getSubtotal() {
		return aluguel + contaEletrica + contadeAgua;
	}

	public Double getRent() {
		return aluguel;
	}

	public Double getElectricityBill() {
		return contaEletrica;
	}

	public Double getWaterSewerBill() {
		return contadeAgua;
	}

	public static Construtor construtor() {
		return new Construtor();
	}

	public static class Construtor {
		private Double contaAgua;
		private Double contaEletrica;
		private Double aluguel;

		public Construtor contaAgua(Double value) {
			this.contaAgua = value;
			return this;
		}

		public Construtor contaEletrica(Double value) {
			this.contaEletrica = value;
			return this;
		}

		public Construtor aluguel(Double valor) {
			this.aluguel = valor;
			return this;
		}

		public Gastos construir() {
			return new Gastos(aluguel, contaEletrica, contaAgua);
		}

	}

}
