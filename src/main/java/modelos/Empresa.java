package modelos;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private Integer capacidade;
	private Gastos gastosMensais;
	private Salário salarioMensal;
	private List<Vendas> vendas;

	public Empresa(Integer capacidade, Gastos gastosMensais, Salário salarioMensal, List<Vendas> vendas) {
		this.capacidade = capacidade;
		this.gastosMensais = gastosMensais;
		this.salarioMensal = salarioMensal;
		this.vendas = vendas;
	}

	public Double getLucroem(Month mes) {
		return getGanhoem(mes) - getCustoTotalem(mes);
	}

	public Double getGanhoem(Month mes) {
		return vendas.get(mes.getValue()-1).getGanhoSub();
	}

	public Double getCustoTotalem(Month mes) {
		return vendas.get(mes.getValue()-1).getGastoSub()
			+ getMonthlyExpenses().getSubtotal()
			+ getMonthlyPayroll().getSubtotal();
	}

	public Gastos getMonthlyExpenses() {
		return gastosMensais;
	}

	public Salário getMonthlyPayroll() {
		return salarioMensal;
	}

	public Integer getCapacity() {
		return capacidade;
	}

	public List<Vendas> getSales() {
		return vendas;
	}

	public static Construtor construtor() {
		return new Construtor();
	}

	public static class Construtor {
		private Integer capacidade;
		private Gastos gastos;
		private Salário salario;
		private List<Vendas> vendas = new ArrayList<>();

		public Construtor capacidade(Integer capacidade) {
			this.capacidade = capacidade;
			return this;
		}

		public Construtor gastos(Gastos gastos) {
			this.gastos = gastos;
			return this;
		}

		public Construtor salario(Salário salario) {
			this.salario = salario;
			return this;
		}

		public Construtor vendas(Vendas vendas) {
			this.vendas.add(vendas);
			return this;
		}

		public Construtor tatalVendas(List<Vendas> vendas) {
			this.vendas = vendas;
			return this;
		}

		public Empresa build() {
			return new Empresa(capacidade, gastos, salario, vendas);
		}
	}
}
