package br.com.testes.timer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

public class Helper extends TimerTask {
	
	public static HelperProcess helperProcess = HelperProcess.INICIALIZADA;
	public static LocalDateTime localDateTime = LocalDateTime.now(); 
	public static Integer endHour = LocalDateTime.now().getHour() + 3; 
	
	public void run() {

		startProcess();
		
		executingProcess();
		
		endProcess();
	}

	private void executingProcess() {
		System.out.println("Executing: " + helperProcess + " - " + new Date());
		
		do {
			localDateTime.plusSeconds(1);
			System.out.println(localDateTime.toString());
		} while (localDateTime.getHour() < endHour);
	}

	private void endProcess() {
		synchronized (Test.obj) {
			helperProcess = HelperProcess.FINALIZADA;
			System.out.println("End: " + helperProcess + " - " + new Date());
			Test.obj.notify();
		}
	}

	private void startProcess() {
		System.out.println("Started: " + helperProcess + " - " + new Date());
		helperProcess = HelperProcess.EXECUTANDO;
	}

}