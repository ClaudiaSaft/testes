package br.com.testes.dp.factory;

import br.com.testes.dp.strategy.TipoFolha;

public class FolhaDecimo extends Folha{

	@Override
	public void setTipoFolhaCriado() {
		tipoFolha =  TipoFolha.DECIMO;
	}
}
