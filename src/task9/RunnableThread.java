package task9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable{
	public static synchronized void deadlock2() throws InterruptedException{
		Thread.sleep(1000);
		ThreadRunner.deadlock1();
		Thread.sleep(1000);
		return;
	}
	static int count=0;
	private static final Logger logger = Logger.getLogger(RunnableThread.class.getName());
	private int sleepTime;
	private boolean dummyState=true;
	public RunnableThread(){
		sleepTime=4500;
	}
	public RunnableThread(int time) {
		sleepTime=time;
	}
	public void setDummyState(boolean value) {
		dummyState=value;
	}
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		/*
		logger.info("Name: " + currentThread.getName());
		logger.info("Priority: " + currentThread.getPriority());
		logger.info("State: " + currentThread.getState());
		*/
		
		/*
		logger.info("Before sleep Name :"+currentThread.getName());
		try {
			Thread.sleep(sleepTime);
		}catch(InterruptedException e) {
			logger.log(Level.SEVERE,"Exception in RunnableThread",e);
		}
		logger.info("After sleep Name :"+currentThread.getName());
		*/
		LocalThread.setValue("runThread "+(count++ +1));
		while(dummyState) {
			logger.info(LocalThread.getValue()+" is running");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				logger.log(Level.SEVERE,"Exception in ExtendedThread",e);
			}
		}
		logger.info(LocalThread.getValue()+" is Terminated");
		LocalThread.clearValue(); 
	}
}


