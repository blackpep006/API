package task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.CustomException;
import common.Helper;
import common.LoggerConfig;
public class RegixRunner {
	private static Logger logger=Logger.getLogger(RegixRunner.class.getName());
	Scanner input;
	RegixProcess process;
	public RegixRunner(){
		input=new Scanner(System.in);
		process=new RegixProcess();
	}
	public void q1() throws CustomException {
		logger.info("Is phone number :"+process.mobileNumberVerification(Helper.getString()));
	}
	public void q2() throws CustomException {
		logger.info("Is AlphaNumeric:"+process.isAlphaNumeric(Helper.getString()));
	}
	public void q3() throws CustomException {
		String inputString=Helper.getString();
		String matchingString=Helper.getString();
		logger.info("Is StartsWith :"+process.startsWith(inputString,matchingString));
		inputString=Helper.getString();
		matchingString=Helper.getString();
		logger.info("Is contains :"+process.contains(inputString,matchingString));
		inputString=Helper.getString();
		matchingString=Helper.getString();
		logger.info("Is endsWith :"+process.endsWith(inputString,matchingString));
		inputString=Helper.getString();
		matchingString=Helper.getString();
		logger.info("Is exactMatch :"+process.exactMatch(inputString,matchingString));
	}
	public void q4() throws CustomException {
		List<String> list=new ArrayList<String>();
		int size=Helper.getInteger();
		for(int i=0;i<size;i++) {
			list.add(Helper.getString());
		}
		String matchingString=Helper.getString();
		logger.info("No of matches :"+process.matchIgnoreCase(list,matchingString));
	}
	public void q5() throws CustomException {
		String inputString=Helper.getString();
		logger.info("Is email:"+process.isEmail(inputString));
	}
	public void q6() throws CustomException {
		List<String> list=new ArrayList<String>();
		int size=Helper.getInteger();
		for(int i=0;i<size;i++) {
			list.add(Helper.getString());
		}
		int start=1,end=6;
		logger.info("No of matches :"+process.lengthMatch(list,start,end));
	}
	public void q7() throws CustomException {
		List<String> list1=new ArrayList<String>();
		int size=Helper.getInteger();
		for(int i=0;i<size;i++) {
			list1.add(Helper.getString());
		}
		System.out.println("For list2 :");
		List<String> list2=new ArrayList<String>();
		for(int i=0;i<size;i++) {
			list2.add(Helper.getString());
		}
		logger.info("Map :"+process.matchTwoList(list1,list2));
	}
	public void q8() throws CustomException {
		logger.info("List :"+process.getAllTags(Helper.getLine()));
	}
	public static void main(String[] args) {
		//new LoggerConfig();
		RegixRunner runner=new RegixRunner();
		try {
			runner.q3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE,"Exception in main",e);
		}
	}
}
