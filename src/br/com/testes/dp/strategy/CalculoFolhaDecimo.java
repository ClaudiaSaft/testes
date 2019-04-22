package br.com.testes.dp.strategy;

import java.math.BigDecimal;

public class CalculoFolhaDecimo implements CalculoFolha{

	private static final BigDecimal QUANTIDADE_SEMANAS_MES = BigDecimal.valueOf(5L);
	private static final BigDecimal PERCENTUAL_DECIMO_SALARIO_BRUTO = BigDecimal.valueOf(0.2);

	private Folha folha;
	
	@Override
	public void calcularFolha(Folha folha) {
		this.folha = folha;
		
		calcularSalarioBruto();
		calcularDecimoTerceiro();
		calcularValeTransporte();
		calcularSalarioLiquido();
	}

	private void calcularSalarioBruto() {
		BigDecimal valorSemanal = folha.getEmpregado().calcularValorSemanal();
		folha.addLancamento(Evento.SALARIO_BRUTO, valorSemanal.multiply(QUANTIDADE_SEMANAS_MES));
	}
	
	private void calcularDecimoTerceiro() {
		Lancamento lancamentoSalarioBruto = folha.getLancamento(Evento.SALARIO_BRUTO);
		folha.addLancamento(Evento.DECIMO_TERCEIRO, lancamentoSalarioBruto.getValor().multiply(PERCENTUAL_DECIMO_SALARIO_BRUTO));
	}

	private void calcularValeTransporte() {
		if(folha.getEmpregado().isValeTransporte()) {
			folha.addLancamento(Evento.VALE_TRANSPORTE, folha.getEmpregado().getValeTransporteMensal());
		}
	}

	private void calcularSalarioLiquido() {
		Lancamento lancamentoSalarioBruto = folha.getLancamento(Evento.SALARIO_BRUTO);
		BigDecimal valorValeTransporte = folha.getLancamento(Evento.VALE_TRANSPORTE).getValor();
		BigDecimal valorDecimoTerceiro = folha.getLancamento(Evento.DECIMO_TERCEIRO).getValor();
			
		folha.addLancamento(Evento.SALARIO_LIQUIDO, lancamentoSalarioBruto.getValor().subtract(valorValeTransporte).subtract(valorDecimoTerceiro));
	}
}
