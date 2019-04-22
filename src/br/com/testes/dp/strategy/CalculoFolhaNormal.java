package br.com.testes.dp.strategy;

import java.math.BigDecimal;

public class CalculoFolhaNormal implements CalculoFolha{

	private static final BigDecimal QUANTIDADE_SEMANAS_MES = BigDecimal.valueOf(5L);

	private Folha folha;
	
	@Override
	public void calcularFolha(Folha folha) {
		this.folha = folha;
		
		calcularSalarioBruto();
		calcularValeTransporte();
		calcularSalarioLiquido();
	}

	private void calcularSalarioBruto() {
		BigDecimal valorSemanal = folha.getEmpregado().calcularValorSemanal();
		folha.addLancamento(Evento.SALARIO_BRUTO, valorSemanal.multiply(QUANTIDADE_SEMANAS_MES));
	}
	
	private void calcularValeTransporte() {
		if(folha.getEmpregado().isValeTransporte()) {
			folha.addLancamento(Evento.VALE_TRANSPORTE, folha.getEmpregado().getValeTransporteMensal());
		}
	}

	private void calcularSalarioLiquido() {
		Lancamento lancamentoSalarioBruto = folha.getLancamento(Evento.SALARIO_BRUTO);
		BigDecimal valorValeTransporte = folha.getLancamento(Evento.VALE_TRANSPORTE).getValor();
			
		folha.addLancamento(Evento.SALARIO_LIQUIDO, lancamentoSalarioBruto.getValor().subtract(valorValeTransporte));
	}

}
