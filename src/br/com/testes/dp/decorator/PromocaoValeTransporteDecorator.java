package br.com.testes.dp.decorator;

import java.math.BigDecimal;

import br.com.testes.dp.strategy.CalculoFolha;
import br.com.testes.dp.strategy.Evento;
import br.com.testes.dp.strategy.Folha;

public class PromocaoValeTransporteDecorator implements CalculoFolha {

	private static final BigDecimal DOBRA_VALE_TRANSPORTE = BigDecimal.valueOf(2);
	private CalculoFolha calculoFolha;

	public PromocaoValeTransporteDecorator(CalculoFolha calculoFolha) {
		this.calculoFolha = calculoFolha;
	}

	@Override
	public void calcularFolha(Folha folha) {
		if(folha.getEmpregado().isValeTransporte()) {
			folha.addLancamento(Evento.PROMOCAO_VALE_TRANSPORTE, folha.getEmpregado().getValeTransporteMensal().multiply(DOBRA_VALE_TRANSPORTE));
		}
		
		calculoFolha.calcularFolha(folha);
		
		if(folha.getEmpregado().isValeTransporte()) {
			BigDecimal valorSalarioLiquido = folha.getLancamento(Evento.SALARIO_LIQUIDO).getValor();
			folha.addLancamento(Evento.SALARIO_LIQUIDO, valorSalarioLiquido.subtract(folha.getEmpregado().getValeTransporteMensal().multiply(DOBRA_VALE_TRANSPORTE)));
		}
	}

}
