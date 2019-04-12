package br.com.testes.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
	
	//Example: https://www.geeksforgeeks.org/java-util-timer-class-java/
	private static final Long TIMEOUT_THREAD_1_MIN = 60000L;
	protected static Test obj;

	public static void main(String[] args) throws InterruptedException {
		obj = new Test();

		Timer timer = createTimer(new Helper());
		
		System.out.println("Timer running");
		
		synchronized (obj) {
			System.out.println("Wait main Thread");
			obj.wait(TIMEOUT_THREAD_1_MIN);

			//Cancela o timer, porem o que esta em execucao, vai continuar ate terminar.
			System.out.println("Cancel main Thread: " + Helper.helperProcess + " - " + new Date());
			timer.cancel();

			System.out.println("Purge main Thread");
			// purge is used to remove all cancelled tasks from the timer'stak queue
			System.out.println(timer.purge());
		}
	}

	private static Timer createTimer(TimerTask task) {
		Timer timer = new Timer();
		timer.schedule(task, new Date());
		return timer;
	}
}