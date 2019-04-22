package br.com.testes.dp.factory;

import br.com.testes.dp.strategy.TipoFolha;

public class TesteFactory {

	public static void main(String[] args) {
		Folha folha = FolhaFactory.createFolha(TipoFolha.NORMAL);
		
		System.out.println(folha);
		System.out.println(folha.getClass());

		Folha folhaDecimo = FolhaFactory.createFolha(TipoFolha.DECIMO);
		
		System.out.println(folhaDecimo);
		System.out.println(folhaDecimo.getClass());
		
		Folha folhaFerias = FolhaFactory.createFolha(TipoFolha.FERIAS);
		
		System.out.println(folhaFerias);
		System.out.println(folhaFerias.getClass());
	}
}
