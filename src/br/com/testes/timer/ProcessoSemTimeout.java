package br.com.testes.timer;

public class ProcessoSemTimeout extends ThreadTimer{

	private static final long UM_SEGUNDO = 1000L;

	@Override
	void processo() throws InterruptedException {
		Thread.sleep(UM_SEGUNDO);
	}

}
