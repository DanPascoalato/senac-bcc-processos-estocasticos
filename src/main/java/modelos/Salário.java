package modelos;

import java.util.stream.Stream;

public class Salário {

	private Double salarioLinhaProducao;
	private Double salarioAdiministracao;
	private Double salarioServicosGerais;
	private Double salarioDiretor;
	private Integer funcionarioProducao;
	private Integer funcionarioAdiministracao;
	private Integer funcionarioGS;
	private Integer numerodeDiretores;


	private Salário(Double salarioLinhaProducao, Double salarioAdiministracao, Double salarioServicosGerais, Double salarioDiretor,
	                Integer funcionarioProducao, Integer funcionarioAdiministracao, Integer funcionarioGS, Integer numerodeDiretores) {
		this.salarioLinhaProducao = salarioLinhaProducao;
		this.salarioAdiministracao = salarioAdiministracao;
		this.salarioServicosGerais = salarioServicosGerais;
		this.salarioDiretor = salarioDiretor;
		this.funcionarioProducao = funcionarioProducao;
		this.funcionarioAdiministracao = funcionarioAdiministracao;
		this.funcionarioGS = funcionarioGS;
		this.numerodeDiretores = numerodeDiretores;
	}

	public Double getSubtotal() {
		return Stream.of(
			salarioLinhaProducao * funcionarioProducao,
			salarioAdiministracao * funcionarioAdiministracao,
			salarioServicosGerais * funcionarioGS,
			salarioDiretor * numerodeDiretores
		).reduce(0.0, (a, b) -> a + b);
	}

	public Double getsalarioLinhaProducao() {
		return salarioLinhaProducao;
	}

	public Double getsalarioAdiministracao() {
		return salarioAdiministracao;
	}

	public Double getsalarioServicosGerais() {
		return salarioServicosGerais;
	}

	public Double getsalarioDiretor() {
		return salarioDiretor;
	}

	public Integer getfuncionarioProducao() {
		return funcionarioProducao;
	}

	public Integer getfuncionarioAdiministracao() {
		return funcionarioAdiministracao;
	}

	public Integer getfuncionarioGS() {
		return funcionarioGS;
	}

	public Integer getnumerodeDiretores() {
		return numerodeDiretores;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Double salarioLinhaProducao;
		private Double salarioAdiministracao;
		private Double salarioServicosGerais;
		private Double salarioDiretor;
		private Integer funcionarioProducao;
		private Integer funcionarioAdiministracao;
		private Integer funcionarioGS;
		private Integer numerodeDiretores;

		public Builder salarioLinhaProducao(Double salario) {
			this.salarioLinhaProducao = salario;
			return this;
		}

		public Builder administrationalary(Double salary) {
			this.salarioAdiministracao = salary;
			return this;
		}

		public Builder generalServicesSalary(Double salary) {
			this.salarioServicosGerais = salary;
			return this;
		}

		public Builder salarioDiretor(Double salario) {
			this.salarioDiretor = salario;
			return this;
		}

		public Builder funcionarioProducao(Integer numerodefuncionarios) {
			this.funcionarioProducao = numerodefuncionarios;
			return this;
		}

		public Builder funcionarioAdiministracao(Integer numerodefuncionarios) {
			this.funcionarioAdiministracao = numerodefuncionarios;
			return this;
		}

		public Builder employeesInGeneralServices(Integer numberOfEmployees) {
			this.funcionarioGS = numberOfEmployees;
			return this;
		}

		public Builder numberOfDirectors(Integer numberOfDirectors) {
			this.numerodeDiretores = numberOfDirectors;
			return this;
		}

		public Salário construir() {
			return new Salário(salarioLinhaProducao, salarioAdiministracao, salarioServicosGerais, salarioDiretor,
				funcionarioProducao, funcionarioAdiministracao, funcionarioGS, numerodeDiretores);
		}

	}
}
