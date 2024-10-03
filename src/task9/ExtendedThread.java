package task9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedThread extends Thread {
	private static final Logger logger = Logger.getLogger(ExtendedThread.class.getName());
	
	private int sleepTime;
	private boolean dummyState = true;

	public ExtendedThread() {
		sleepTime = 1000;
	}

	public ExtendedThread(int time) {
		sleepTime = time;
	}

	public void setDummyState(boolean value) {
		dummyState = value;
	}

	public boolean isRunning() {
		return dummyState;
	}

	public void run() {
		
//		  logger.info("TTName :"+getName()); 
//		  logger.info("TTPriority :"+getPriority());
//		  logger.info("TTState :"+getState());
		 

		/*
		 * logger.info("Before sleep Name :"+getName()); try { Thread.sleep(sleepTime);
		 * }catch(InterruptedException e) {
		 * logger.log(Level.SEVERE,"Exception in ExtendedThread",e); }
		 * logger.info("Aftersleep Name :"+getName());
		 */
		
		  while (dummyState) {
		  
			  //logger.info(getName()+" is running");
		  
			  try { 
				  Thread.sleep(sleepTime); 
			  }catch(InterruptedException e) {
				  logger.log(Level.SEVERE,"Exception in ExtendedThread",e); 
			  }
		  }		 
		  logger.info(getName()+" is stopped");
		 
	}
}
