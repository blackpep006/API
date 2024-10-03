package task8.SingletonClasses;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingletonClass implements Serializable,Cloneable{
	private static final long serialVersionUID = 1L;
	private static SingletonClass instance;
	private SingletonClass() {
		
	}
	public static SingletonClass getInstance() {//swami
		if(instance==null) {
			synchronized(SingletonClass.class) {
				instance=new SingletonClass();
			}
		}
		return instance;
	}
	@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for singleton.");
    }
	
	protected Object readResolve() {
		return getInstance();//swami
	}
	
	protected void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); 
        if (instance == null) {
            instance = this; 
        }
    }
}

/*
public class SingletonClass {
	private static final Singleton INSTANCE = new Singleton();

	private Singleton() {}

	public static Singleton getInstance() {
    	return INSTANCE;
	}
}



public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}



*/