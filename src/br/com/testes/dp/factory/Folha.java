package br.com.testes.dp.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.testes.dp.strategy.Empregado;
import br.com.testes.dp.strategy.Evento;
import br.com.testes.dp.strategy.Lancamento;
import br.com.testes.dp.strategy.TipoFolha;

public abstract class Folha {

	protected TipoFolha tipoFolha;
	private Empregado empregado;
	private LocalDate dataFolha;
	private BigDecimal valorLiquido;
	private List<Lancamento> lancamentos;
	
	public Folha() {
		setTipoFolhaCriado();
	}
	
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public LocalDate getDataFolha() {
		return dataFolha;
	}

	public abstract void setTipoFolhaCriado();
	
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
