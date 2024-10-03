package task8.SingletonClasses;

import java.io.Serializable;

public class BillPugh implements Serializable,Cloneable{
	private static final long serialVersionUID = 1L;

	private BillPugh() {

    }

    private static class SingletonHelper {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for singleton.");
    }
	
	protected Object readResolve() {
		return getInstance();
	}
}
