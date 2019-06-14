package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produto {

	private List<Componente> componentes;
	private Double precoUnidade;

	private Produto(List<Componente> componentes, Double precoUnidade) {
		this.componentes = componentes;
		this.precoUnidade = precoUnidade;
	}

	public Double getGastoProducao() {
		return componentes.stream()
			.map(Componente::getGastoProducao)
			.reduce(0.0, (a,b) -> a+b);
	}


	public List<Componente> getComponente() {
		return componentes;
	}

	public Double getPrecoUnidade() {
		return precoUnidade;
	}

	public static Construtor construtor() {
		return new Construtor();
	}

	public static class Construtor {

		private List<Componente> componentes = new ArrayList<>();
		private Double precoUnidade;

		public Construtor componente(Componente componente, Integer qtd) {
			this.componentes.addAll(Collections.nCopies(qtd, componente));
			return this;
		}

		public Construtor precoUnidade(Double precoUnidade) {
			this.precoUnidade = precoUnidade;
			return this;
		}

		public Produto build() {
			return new Produto(componentes, precoUnidade);
		}

	}

}
