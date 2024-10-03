package tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class TestRunner {

    public static void main(String[] args) {
        Class<?> testRunner;
        try {
            testRunner = Class.forName("task3.StringProcess");
            Constructor<?> defaultConstructor = testRunner.getConstructor();
            Object object = defaultConstructor.newInstance();
            Method[] methods = testRunner.getMethods();
            Random random=new Random();
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] argsToPass = new Object[parameterTypes.length];

                System.out.println("Invoking method: " + method.getName() + " with parameters: " + Arrays.toString(parameterTypes));

                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i] == String.class) {
                        argsToPass[i] = "Alpha"; 
                    } else if (parameterTypes[i] == int.class) {
                        argsToPass[i] = random.nextInt(10); 
                    } else if (parameterTypes[i] == char.class) {
                        argsToPass[i] = 'a'; 
                    } else {
                        argsToPass[i] = null; 
                    }
                }

                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(object, argsToPass);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Illegal argument provided: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // This is a github test
}
