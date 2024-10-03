package task9.threadlocal;
import task9.LocalThread;
public class ClassA {
	ClassB bClass;
	ClassA(){
		bClass=new ClassB();
	}
	public String getData() {
		return bClass.verifyAndGetData();
	}
	public static void main(String[] args) {
		new Thread(()->{
			ClassA threadA=new ClassA();
			LocalThread.setValue(Thread.currentThread().getName());
			System.out.println(threadA.getData());
			LocalThread.clearValue();
		}).start();
		new Thread(()->{
			ClassA threadB=new ClassA();
			LocalThread.setValue(Thread.currentThread().getName());
			System.out.println(threadB.getData());
			LocalThread.clearValue();
		}).start();
	}

}
