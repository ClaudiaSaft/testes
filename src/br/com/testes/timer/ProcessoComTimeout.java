package br.com.testes.timer;

public class ProcessoComTimeout extends ThreadTimer{

	private static final long TRES_MINUTOS = 30000L;

	@Override
	void processo() throws InterruptedException {
		Thread.sleep(TRES_MINUTOS);
	}

}
