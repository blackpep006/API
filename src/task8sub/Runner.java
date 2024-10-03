package task8sub;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import common.CustomException;
import common.Helper;
import task8.POJO;
public class Runner {
	private static final Logger logger = Logger.getLogger(Runner.class.getName());
	public void q7() throws CustomException {
		POJO pojo=new POJO();
		pojo.setString(Helper.getString());
		pojo.setNumber(Helper.getInteger());
		System.out.println(pojo);
	}
    public void q8() throws CustomException{
    	try {
    		Class<?> pojoClass=Class.forName("task8.POJO");
    		Constructor<?> overloadedConstructor = pojoClass.getConstructor(String.class, int.class);
    		Object pojoInstance = overloadedConstructor.newInstance(Helper.getString(), Helper.getInteger());
    		logger.info("object :"+pojoInstance);
    		
    		Constructor<?> defaultConstructor = pojoClass.getConstructor();
    		Object pojoInstance2 = defaultConstructor.newInstance();
    		Method setStringMethod=pojoClass.getMethod("setString", String.class);
    		setStringMethod.invoke(pojoInstance2,Helper.getString());
    		Method setNumberMethod=pojoClass.getMethod("setNumber", int.class);
    		setNumberMethod.invoke(pojoInstance2,Helper.getInteger());
    		logger.info("object :"+pojoInstance2);
    	}catch(Exception e) {
    		throw new CustomException("Exception in q8",e);
    	}
    }
}
