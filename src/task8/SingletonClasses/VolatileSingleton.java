package task8.SingletonClasses;

import java.io.Serializable;

public class VolatileSingleton  implements Serializable,Cloneable{
	private static final long serialVersionUID = 1L;
	private static volatile VolatileSingleton instance;
	private VolatileSingleton() {
		
	}
	public static VolatileSingleton getInstance() {
		if(instance==null) {
			synchronized(SingletonClass.class) {
				if (instance == null) {
					instance=new VolatileSingleton();
				}
			}
		}
		return instance;
	}
	@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for singleton.");
    }
	
	protected Object readResolve() {
		return getInstance();
	}
}
