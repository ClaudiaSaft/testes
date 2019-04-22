package br.com.testes.dp.factory;

import br.com.testes.dp.strategy.TipoFolha;

public class FolhaFactory {

	public static Folha createFolha(TipoFolha tipoFolha) {
		switch (tipoFolha) {
		case NORMAL:
			return new FolhaNormal();
		case DECIMO:
			return new FolhaDecimo();

		default:
			throw new RuntimeException("TIPO DE FOLHA INVALIDO");
		}
	}

}
