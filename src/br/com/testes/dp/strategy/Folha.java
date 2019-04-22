package br.com.testes.dp.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Folha {

	private TipoFolha tipoFolha;
	private Empregado empregado;
	private LocalDate dataFolha;
	private BigDecimal valorLiquido;
	private List<Lancamento> lancamentos;
	
	public Folha (TipoFolha tipoFolha, Empregado empregado, LocalDate dataFolha) {
		this.tipoFolha = tipoFolha;
		this.empregado = empregado;
		this.dataFolha = dataFolha;
	}
	
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public TipoFolha getTipoFolha() {
		return tipoFolha;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public LocalDate getDataFolha() {
		return dataFolha;
	}

	@Override
	public String toString() {
		return "Folha [tipoFolha=" + tipoFolha + ", empregado=" + empregado + ", dataFolha=" + dataFolha
				+ ", valorLiquido=" + valorLiquido + ", lancamentos=" + lancamentos + "]";
	}

	public void addLancamento(Evento evento, BigDecimal valor) {
		if(lancamentos == null) {
			lancamentos = new ArrayList<>();
		}
		
		Lancamento lancamento = getLancamento(evento);
		if(lancamento.getEvento() == null && lancamento.getValor() == null) {
			lancamentos.add(new Lancamento(evento, valor));
		}else {
			lancamento.setValor(valor);
		}
	}

	public Lancamento getLancamento(Evento evento) {
		Optional<Lancamento> lancamentoEncontrado = lancamentos.stream().filter(l -> l.getEvento().equals(evento)).findFirst();
		return lancamentoEncontrado.isPresent() ? lancamentoEncontrado.get() : new Lancamento();
	}
	
}
