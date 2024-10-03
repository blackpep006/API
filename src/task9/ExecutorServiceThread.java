package task9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ExecutorServiceThread extends Thread{
	Logger logger=Logger.getLogger(ExecutorServiceThread.class.getName());
	public void run() {
		logger.info("Starting "+getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Ending "+getName());
	}
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int i=0;i<1000;i++) {
			service.execute(new ExecutorServiceThread());
		}
	}
	
}
