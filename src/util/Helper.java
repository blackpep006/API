package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import pojo.User;

public class Helper {
	public static Map<String, Object> map;
	static {
        yamlToMap();
    }
	public static long getCurrentTime() {
        return System.currentTimeMillis();
    }
	private static void yamlToMap() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(System.getProperty("user.dir") + "/src/util/fieldColumnMap.yaml");

        try (InputStream input = new FileInputStream(file)) {
            map = (Map<String, Object>) mapper.readValue(input, new TypeReference<Map<String, Object>>() {}).get("bankClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private static ThreadLocal<User> userData=new ThreadLocal<>();
	public static void setUserData(User value) {
		userData.set(value);
    }
    
    public static User getUserData() {
        return userData.get();
    }
    
    public static void clearUserData() {
    	userData.remove();
    }
}
