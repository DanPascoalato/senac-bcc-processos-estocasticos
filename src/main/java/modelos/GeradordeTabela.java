package modelos;

import simuladores.Report;
import simuladores.Simulacao1;
import simuladores.Simulacao2;

import java.io.IOException;

public class GeradordeTabela {

	public static void main(String[] args) throws IOException {
		Componente componenteA = new Componente("A", 15.00);
		Componente componenteB = new Componente("B", 25.00);

		Produto p1 = Produto.construtor()
			.componente(componenteA, 2)
			.componente(componenteB, 1)
			.precoUnidade(70.00)
			.build();

		Produto p2 = Produto.construtor()
			.componente(componenteA, 2)
			.componente(componenteB, 3)
			.precoUnidade(70.00)
			.build();

		Empresa empresa = Empresa.construtor()
			.capacidade(400)
			.gastos(controiGastos())
			.salario(controiSalario())
			.build();

		Empresa companySimA = new Simulacao1(empresa).calculeVendasde(p1, p2);
		Empresa companySimB = new Simulacao2(empresa).calculeVendasde(p1, p2);

		Report.geraReporte(companySimA, "PE-q5-exa.csv");
		Report.geraReporte(companySimB, "PE-q5-exb.csv");
	}
	
	private static Gastos controiGastos() {
		return Gastos.construtor()
			.aluguel(3500.00)
			.contaEletrica(900.00)
			.contaAgua(600.00)
			.construir();
	}
	
	private static Salário controiSalario() {
		return Salário.builder().salarioLinhaProducao(3500.00).administrationalary(4000.00).generalServicesSalary(2000.00).salarioDiretor(6000.00)
			.funcionarioProducao(5).funcionarioAdiministracao(2).employeesInGeneralServices(2).numberOfDirectors(1)
			.construir();
	}

	

}
