package br.senac.sp.probabilidade.question;

import br.senac.sp.probabilidade.model.Company;
import br.senac.sp.probabilidade.model.Product;

import java.util.Random;

public interface Simulation {

	Company computeSalesOf(Product... products);

	static Integer rng(Integer maxLimit) {
		return new Random().nextInt(maxLimit + 1);
	}

}
