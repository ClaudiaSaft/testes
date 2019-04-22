package br.com.testes.timer;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ThreadTimer {
	
	private static final long SEGUNDOS_TIMEOUT = 20;
	
	abstract void processo() throws InterruptedException;
	
	public void executarProcesso() throws Exception {
		ExecutorService executor = null;
		try {
			executor = Executors.newSingleThreadExecutor();
			System.out.println("0---" + LocalDateTime.now());
			
			Future<Boolean> future = executor.submit(() -> {
				System.out.println("1---" + LocalDateTime.now());
			    
				processo();
				
			    return true;
			});
	
			Boolean finalizado = future.get(SEGUNDOS_TIMEOUT, TimeUnit.SECONDS);
		
			System.out.println("2---" + LocalDateTime.now() + " - finalizado: " + finalizado);
			
			if (finalizado) {
				System.out.println("Processo finalizado");
			}
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("3 TIMEOUT--- " + LocalDateTime.now());
			throw e;
		} finally {
			if(executor != null) {
				executor.shutdown();
			}
		}
	}

}
