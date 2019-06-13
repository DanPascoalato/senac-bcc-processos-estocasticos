package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Product;
import br.senac.sp.probabilidade.model.Sales;

import java.util.List;
import java.util.Random;

public interface Simulation {

	List<Sales> computeSalesOf(Product... products);

	static Integer rng(Integer maxLimit) {
		return new Random().nextInt(maxLimit + 1);
	}

}
