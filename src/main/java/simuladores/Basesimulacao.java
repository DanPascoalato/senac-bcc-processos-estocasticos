package simuladores;

import java.util.Random;

import modelos.Empresa;
import modelos.Produto;

public interface Basesimulacao {

	Empresa calculeVendasde(Produto... products);

	static Integer rng(Integer maxLimit) {
		return new Random().nextInt(maxLimit + 1);
	}

}
