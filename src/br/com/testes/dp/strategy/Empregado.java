package br.com.testes.dp.strategy;

import java.math.BigDecimal;

public class Empregado {

	private Long uidEmpregado;
	private String nome;
	private BigDecimal quantidadeHorasSemanal;
	private BigDecimal valorHora;
	private boolean valeTransporte;
	private BigDecimal valeTransporteMensal;
	
	public Empregado() {
		
	}

	public Empregado(Long uidEmpregado, String nome, BigDecimal quantidadeHorasSemanal, BigDecimal valorHora, boolean valeTransporte, BigDecimal valeTransporteMensal) {
		this.uidEmpregado = uidEmpregado;
		this.nome = nome;
		this.quantidadeHorasSemanal = quantidadeHorasSemanal;
		this.valorHora = valorHora;
		this.valeTransporte = valeTransporte;
		this.valeTransporteMensal = valeTransporteMensal;
	}
	
	public Long getUidEmpregado() {
		return uidEmpregado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getQuantidadeHorasSemanal() {
		return quantidadeHorasSemanal;
	}
	
	public BigDecimal getValorHora() {
		return valorHora;
	}
	
	public boolean isValeTransporte() {
		return valeTransporte;
	}
	
	public BigDecimal getValeTransporteMensal() {
		return valeTransporteMensal;
	}

	@Override
	public String toString() {
		return "Empregado [uidEmpregado=" + uidEmpregado + ", nome=" + nome + ", quantidadeHorasSemanal="
				+ quantidadeHorasSemanal + ", valorHora=" + valorHora + ", valeTransporte=" + valeTransporte
				+ ", valeTransporteMensal=" + valeTransporteMensal + "]";
	}

	public BigDecimal calcularValorSemanal() {
		return quantidadeHorasSemanal.multiply(valorHora);
	}
}
