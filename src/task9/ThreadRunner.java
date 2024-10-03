package task9;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.CustomException;
import common.Helper;
import common.LoggerConfig;

public class ThreadRunner {
	public static synchronized void deadlock1() throws InterruptedException{
		Thread.sleep(1000);
		RunnableThread.deadlock2();
		Thread.sleep(1000);
		return;
	}
	
	
	private static final Logger logger = Logger.getLogger(ThreadRunner.class.getName());
	private  void printThreadStates(int count,int sleepTime) throws InterruptedException{
		for(int k=0;k<count;k++) {
			Thread.sleep(sleepTime);
			logger.info("Thread states:");
			Thread.getAllStackTraces().keySet().forEach(thread -> {
				logger.info(thread.getName() + " - State: " + thread.getState());
				logger.info(thread.getName() + " - State: " + thread.getState());
	            for (StackTraceElement element : thread.getStackTrace()) {
	                logger.info("\tat " + element);
	            }
			});
		}
    }
	private void printThreadStates(List<ExtendedThread> array,int count,int time) throws InterruptedException {
		Thread.sleep(12000);
		int size=array.size();
		for(int k=0;k<count;k++) {
			Thread.sleep(time);
			System.out.println("Thread states:");
			for(int i=0;i<size;i++) {
				ExtendedThread thread=array.get(i);
				logger.info(thread.getName() + " - State: " + thread.getState());
			}
		}
	}
	public void q1() {
		ExtendedThread thread=new ExtendedThread();
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
		thread.start();
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
	}
	public void q2() throws InterruptedException {
		RunnableThread runnableThread=new RunnableThread();
		Thread thread=new Thread(runnableThread);
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
		thread.start();
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
	}
	public void q3() {
		ExtendedThread thread=new ExtendedThread();
		thread.setName("ExtendedThread");
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
		thread.start();
		logger.info("Name :"+thread.getName());	
		logger.info("Priority :"+thread.getPriority());
		logger.info("State :"+thread.getState());
		
		
		RunnableThread runnableThread=new RunnableThread();
		Thread thread2=new Thread(runnableThread);
		thread2.setName("runnableThread");
		logger.info("Name :"+thread2.getName());	
		logger.info("Priority :"+thread2.getPriority());
		logger.info("State :"+thread2.getState());
		thread2.start();
		logger.info("Name :"+thread2.getName());	
		logger.info("Priority :"+thread2.getPriority());
		logger.info("State :"+thread2.getState());
	}
	public void q4() {
		int size=5;
		ExtendedThread thread;
		for(int i=0;i<size;i++) {
			thread=new ExtendedThread();
			thread.setName("ExtendedThread "+i);
			thread.start();
		}
		
		RunnableThread runnableThread=new RunnableThread();;
		Thread thread2;
		for(int i=0;i<size;i++) {
			thread2=new Thread(runnableThread);
			thread2.setName("RunnableThread "+i);
			thread2.start();
		}
	}
	public void q5() {
		int size=5;
		ExtendedThread thread;
		for(int i=0;i<size;i++) {
			thread=new ExtendedThread(Helper.getInteger());
			thread.setName("ExtendedThread "+i);
			thread.start();
		}
		
		RunnableThread runnableThread=new RunnableThread(Helper.getInteger());;
		Thread thread2;
		for(int i=0;i<size;i++) {
			thread2=new Thread(runnableThread);
			thread2.setName("RunnableThread "+i);
			thread2.start();
		}
	}
	public void q6() throws InterruptedException {
		ExtendedThread thread=new ExtendedThread();
		thread.setName("ExtendedThread");
		
		RunnableThread runnableThread=new RunnableThread();
		Thread thread2=new Thread(runnableThread);
		thread2.setName("runnableThread");
		
		thread.start();
		thread2.start();
		
		//Thread.sleep(120000); 
		
            printThreadStates(3,6000);
        
	}
	public void q7(){
		List<ExtendedThread> array=new ArrayList<>();
		int count=10;
		for(int i=0;i<count;i++) {
			ExtendedThread thread=new ExtendedThread();
			thread.setName("ExtendedThread "+(i+1));
			thread.start();
			array.add(thread);
		}
		new Thread(()-> {	
			try {
				printThreadStates(10,25000);
			} catch (InterruptedException e) {
				throw new RuntimeException(new CustomException("In q7", e));
			}
		}).start();
		new Thread(()-> {
			try {
				stopThread(array,30000);
				Thread.sleep(10000);
				taskCompleted(array);
				printThreadStates(1,0);
			} catch (InterruptedException e) {
				throw new RuntimeException(new CustomException("In q7", e));
			}
		}).start();
	}
	
	public void q8() throws InterruptedException{
		new Thread(()->{
			try {
				deadlock1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				RunnableThread.deadlock2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		Thread.sleep(10000);
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        
        if (deadlockedThreads != null) {
            for (long threadId : deadlockedThreads) {
                System.out.println("Deadlocked thread ID: " + threadId);
            }
        } else {
            System.out.println("No deadlocked threads detected.");
        }
		printThreadStates(10,4500);
	}
	public void q9() throws InterruptedException {
		RunnableThread runnable=new RunnableThread();
		for(int i=0;i<4;i++) {
			Thread thread=new Thread(runnable);
			thread.start();
		}
		Thread.sleep(10000);
		runnable.setDummyState(false);
	}
	private void stopThread(List<ExtendedThread> array,int time) throws InterruptedException {
		for(int i=0;i<array.size();i++) {
				Thread.sleep(time);
			
			array.get(i).setDummyState(false);
		}
	}
	private void taskCompleted(List<ExtendedThread> array) {
		int size=array.size();
		for(int i=0;i<size;i++) {
			if(array.get(i).isRunning()) {
				return;
			}
		}
		logger.info("All task Terminated");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new LoggerConfig();
		ThreadRunner runner=new ThreadRunner();
		try {
			
			runner.q9();
			
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Exception in main",e);
			
		}
	}

}
