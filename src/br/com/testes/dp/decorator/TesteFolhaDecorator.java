package br.com.testes.dp.decorator;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.testes.dp.strategy.CalculoFolhaNormal;
import br.com.testes.dp.strategy.Empregado;
import br.com.testes.dp.strategy.Folha;
import br.com.testes.dp.strategy.TipoFolha;

public class TesteFolhaDecorator {

	public static void main(String[] args) {
		Empregado empregado = new Empregado(1L, "Emp1", BigDecimal.valueOf(40),	BigDecimal.valueOf(40), true, BigDecimal.valueOf(100));
		
		System.out.println("--------- FOLHA NORMAL SEM DECORATOR ---------");
		Folha folhaNormal = new Folha(TipoFolha.NORMAL, empregado, LocalDate.now());
		
		new CalculoFolhaNormal().calcularFolha(folhaNormal);
		
		folhaNormal.getLancamentos().forEach(l -> System.out.println(l.getEvento() + " - " + l.getValor()));

		
		System.out.println("\n\n--------- FOLHA NORMAL COM DECORATOR ---------");
		Folha folhaNormalComDecorator = new Folha(TipoFolha.NORMAL, empregado, LocalDate.now());
		
		new PromocaoValeTransporteDecorator(new CalculoFolhaNormal()).calcularFolha(folhaNormalComDecorator);
		
		folhaNormalComDecorator.getLancamentos().forEach(l -> System.out.println(l.getEvento() + " - " + l.getValor()));
		
	}
}
