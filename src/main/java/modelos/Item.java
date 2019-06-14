package modelos;

public class Item {

	private Produto produto;
	private Integer quantidade;

	public Item(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Double getGanhoSub() {
		return produto.getPrecoUnidade() * quantidade;
	}

	public Double getGastoSub() {
		return produto.getGastoProducao() * quantidade;
	}

	public Double getProfitSubtotal() {
		return getGanhoSub() - getGastoSub();
	}

	public Produto getProduct() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
}
