package task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Properties;

import common.CustomException;
import common.Helper;

public class FileProcess {
		public File getFile(String path,String name) throws IOException {
			File directory = new File(path);
			if (!directory.exists()) {
			    directory.mkdirs();
			}

			File file = new File(directory, name);
			if (!file.exists()) {
			    file.createNewFile();
			}

			return file;

		}
		public void writeContent(File fileName,String[] content) throws CustomException {
			try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName)) ){
				for(String line:content) {
					writer.write(line);
					writer.newLine();	
				}
			}catch(IOException e) {
				throw new CustomException("Exception in writing file in writeContent",e);
			}
		}
		
		
		public Map<?,?> createProperties() {
			return new Properties();
		}
		public Object put(Object key,Object value,Map<?,?> properties) throws CustomException {
			Helper.validate(properties);
			return ((Properties) properties).put(key,value);
		}
		public void store(File fileName,Map<?,?> properties) throws CustomException {
			Helper.validate(properties);
			Helper.validate(fileName);
			try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName)) ){
				((Properties) properties).store(writer, null);
					
			}catch(IOException e) {
				throw new CustomException("Exception in store",e);
			}
		}
		public void load(File fileName,Map<?,?> properties) throws CustomException {
			Helper.validate(properties);
			Helper.validate(fileName);
			try(BufferedReader writer=new BufferedReader(new FileReader(fileName)) ){
				((Properties) properties).load(writer);
					
			}catch(IOException e) {
				throw new CustomException("Exception in load",e);
			}
		}
		
		
		public  ZonedDateTime localTime() {
			//return Instant.ofEpochMilli(localTimeMilli()).atZone(ZoneId.systemDefault());
			return ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		}
		public long localTimeMilli() {
			return Instant.now().toEpochMilli(); //System.currentTimeMillis();
		}
		public String zoneTime(String country) {
			return ZonedDateTime.now(ZoneId.of(country)).toString();
		}
		public String getDayOfWeek(long milli) {
			return localTime().getDayOfWeek().toString();
		}
		public String getMonth(long milli) {
			return localTime().getMonth().toString();
		}
		public String getYear(long milli) {
			return Integer.toString(localTime().getYear());
		}
}
