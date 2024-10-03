package task9;

public class LocalThread {
	private static ThreadLocal<String> threadLocal=ThreadLocal.withInitial(()->"default");
	public static void setValue(String name) {
		threadLocal.set(name);
	}
	public static String getValue() {
		return threadLocal.get();
	}
	public static void clearValue() {
	    threadLocal.remove();
	}
}
