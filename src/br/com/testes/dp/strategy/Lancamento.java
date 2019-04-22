package br.com.testes.dp.strategy;

import java.math.BigDecimal;

public class Lancamento {

	private Evento evento;
	private BigDecimal valor;
	
	public Lancamento() {
	}

	public Lancamento(Evento evento, BigDecimal valor) {
		this.evento = evento;
		this.valor = valor;
	}

	public Evento getEvento() {
		return evento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
