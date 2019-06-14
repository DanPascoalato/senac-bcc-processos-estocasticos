package modelos;

public class Componente {

	private String nome;
	private Double custoProducao;

	public Componente(String nome, Double custoProducao) {
		this.nome = nome;
		this.custoProducao = custoProducao;
	}

	public String getNome() {
		return nome;
	}

	public Double getGastoProducao() {
		return custoProducao;
	}
}
