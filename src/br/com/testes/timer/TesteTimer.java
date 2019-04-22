package br.com.testes.timer;

public class TesteTimer {

	public static void main(String[] args) throws Exception {
		
		new ProcessoSemTimeout().executarProcesso();
		
		new ProcessoComTimeout().executarProcesso();
	}
}
