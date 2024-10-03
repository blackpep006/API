package task8;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.CustomException;
import common.Helper;
import task8.SingletonClasses.SingletonClass;
import task8sub.Runner;

public class FileRunner {
	private FileProcess process;
	private Scanner input;
	private static final Logger logger = Logger.getLogger(FileRunner.class.getName());
	public FileRunner() {
		process=new FileProcess();
		input=new Scanner(System.in);
	}
    private String getKeyString() {
    	logger.info("Enter Key: ");
        return input.next();
    }

    private String getValueString() {
    	logger.info("Enter Value: ");
        return input.next();
    }
	public void q1() throws CustomException, IOException { 
        File fileName=process.getFile(System.getProperty("user.dir"), "/sample.txt");
		int size=3;
		String[] content=new String[size];
		for(int i=0;i<size;i++) {
			content[i]=Helper.getLine();
		}
		process.writeContent(fileName,content);
		logger.info("done");
	}
	public void q2() throws CustomException, IOException {
		File fileName=process.getFile(System.getProperty("user.dir"),"myProps.txt");
		Map<?,?> properties=process.createProperties();
		int size=3;
		for(int i=0;i<size;i++) {
			process.put(getKeyString(), getValueString(), properties);
		}
		process.store(fileName,properties);
		logger.info("done");
	}
	public void q3() throws CustomException, IOException {
		File fileName=process.getFile("./","myProps.txt");
		Map<?,?> properties=process.createProperties();
		process.load(fileName,properties);
		logger.info("properties "+properties);
	}
	public void q4() throws CustomException, IOException {
		String directory = System.getProperty("user.home") + "/myDir/"; 
		File fileName=process.getFile(directory, "/sample.txt");
		int size=3;
		String[] content=new String[size];
		for(int i=0;i<size;i++) {
			content[i]=Helper.getLine();
		}
		process.writeContent(fileName,content);
		logger.info("q1");
		
		fileName=process.getFile(directory,"myProps.txt");
		Map<?,?> properties=process.createProperties();
		for(int i=0;i<size;i++) {
			process.put(getKeyString(), getValueString(), properties);
		}
		process.store(fileName,properties);
		logger.info("q2");
		
		Map<?,?> properties2=process.createProperties();
		process.load(fileName,properties2);
		logger.info("properties "+properties2);
	}
	public void q5() {
		ToStringImplementation toStringImplementation=new ToStringImplementation(Helper.getString());
		logger.info("Object :"+toStringImplementation);
	}
	public void q6() {
		POJO pojo=new POJO(Helper.getString(),Helper.getInteger());
		logger.info("Object :"+pojo);
	}
	//7,8
	public void q9() {
		for (Rainbow color : Rainbow.values()) {
			logger.info("Color code of "+color+" is "+color.getColor());
        }
		
	}
	public void q10(){
		SingletonClass single=SingletonClass.getInstance();
		logger.info("Object :"+single);
		single=SingletonClass.getInstance();
		logger.info("Object :"+single);
	}
	public void q11() {
		logger.info("local time :"+process.localTime());
		logger.info("Local time in milli :"+process.localTimeMilli());
		logger.info(process.zoneTime("America/New_York"));
		logger.info(process.zoneTime("Europe/London"));
		logger.info(process.getDayOfWeek(process.localTimeMilli()));
		logger.info(process.getMonth(process.localTimeMilli()));
		logger.info(process.getYear(process.localTimeMilli()));
	}
	public static void main(String[] args) {
		try {
			FileRunner runner=new FileRunner();
			//runner.q1();
			Runner runner8=new Runner();
			//runner8.q8();
			//runner8.q7();
			System.out.println(""+System.currentTimeMillis());
			System.out.println(""+Instant.now().toEpochMilli());
			System.out.println(""+ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli());
			System.out.println(""+ZonedDateTime.now(ZoneId.of("GMT")).toInstant().toEpochMilli());
			
			System.out.println(Instant.ofEpochMilli(Instant.now().toEpochMilli()).atZone(ZoneId.systemDefault()));
			System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
			SingletonClass single;
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in main",e);
		}
	}
}
