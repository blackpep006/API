package task6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import common.CustomException;

public class ArrayListReflection {
	@SuppressWarnings("unchecked")
	public <T> List<T> createList() throws CustomException{
		try {
		Class<?> arrayList=Class.forName("java.util.ArrayList");
		Constructor<?> defaultConstructor=arrayList.getConstructor();
		
        return (List<T>)defaultConstructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
			throw new CustomException("In ArraryList reflection",e);
		}
    }
}
