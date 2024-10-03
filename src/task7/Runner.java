package task7;

import java.util.Map;
import java.util.Scanner;
import task6.Custom;
import common.CustomException;
import common.Helper;

public class Runner {
    private Process process;
    private Scanner input;

    public Runner() {
        process = new Process();
        input = new Scanner(System.in);
    }

    private String getKeyString() {
        System.out.print("Enter Key: ");
        return input.next();
    }

    private String getValueString() {
        System.out.print("Enter Value: ");
        return input.next();
    }

    private int getKeyInteger() {
        System.out.print("Enter Key: ");
        return input.nextInt();
    }

    private int getValueInteger() {
        System.out.print("Enter Value: ");
        return input.nextInt();
    }

    public void q1() throws CustomException {
        Map<String, String> map = process.createMap();
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q2() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q3() throws CustomException {
        Map<Integer, Integer> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyInteger(), getValueInteger(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q4() throws CustomException {
        Map<String, Integer> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueInteger(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q5() throws CustomException {
        Map<String, Custom> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), new Custom(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q6() throws CustomException {
        Map<String, String> map = process.createMap();
        map.put("strNullValue", null);
        int size = 2;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q7() throws CustomException {
        Map<String, String> map = process.createMap();
        map.put(null, "value");
        int size = 2;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q8() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println("The map contains is " + process.containsKey(Helper.getString(), map));
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q9() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println("The map contains is " + process.containsValue(Helper.getString(), map));
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q10() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        for (String key : process.keySet(map)) {
            System.out.print("For " + key + " ");
            process.replace(key, getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q11() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println("The value got is " + process.get(Helper.getString(), map));
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q12() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println("The value got is " + process.get(Helper.getString(), map));
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q13() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        String defau = "ZOHO";
        System.out.println("The value got is " + process.getOrDefault(Helper.getString(), defau, map));
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q14() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        process.remove(Helper.getString(), map);
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q15() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        process.remove(getKeyString(), getValueString(), map);
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q16() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        process.replace(getKeyString(), getValueString(), map);
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q17() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        process.replace(getKeyString(), getValueString(), Helper.getString(), map);
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
    }

    public void q18() throws CustomException {
        Map<String, String> map = process.createMap();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.put(getKeyString(), getValueString(), map);
        }
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        Map<String, String> newMap = process.createMap();
        process.putAll(newMap, map);
        System.out.println(map);
        System.out.println("Length is " + process.length(map));
        System.out.println(newMap);
        System.out.println("Length is " + process.length(newMap));
    }
    public void q19()throws CustomException{
            Map<String,String> map=process.createMap();
            int size=3;
            for(int i=0;i<size;i++) {
            	process.put(getKeyString(),getValueString(),map);
            }
            for(Map.Entry<String,String> entry:process.entrySet(map)) {
            	System.out.print("Key :"+entry.getKey());
            	System.out.println("  Value:"+entry.getValue());
            }
            System.out.println(map);
            System.out.println("Length is "+process.length(map));
        
    }
    public void q20()throws CustomException{
            Map<String,String> map=process.createMap();
            int size=3;
            for(int i=0;i<size;i++) {
            	process.put(getKeyString(),getValueString(),map);
            }
            System.out.println(map);
            System.out.println("Length is "+process.length(map));
            process.clear(map);
            System.out.println(map);
            System.out.println("Length is "+process.length(map));
        
    }
	public static void main(String[] args) {
		try {
	        Runner runner=new Runner();
	        runner.q20();
	    	}catch(CustomException e) {
	    		e.printStackTrace();
	    }
	}

}
