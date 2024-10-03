package task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.CustomException;
import common.Helper;

public class RegixProcess {
	public boolean mobileNumberVerification(String inputString) throws CustomException {
		Helper.validate(inputString);
		return matches(inputString,"^[789]\\d{9}$");
	}
	public boolean isAlphaNumeric(String inputString) throws CustomException {
		Helper.validate(inputString);
		return matches(inputString,"^[\\da-zA-Z]+$");
	}
	public boolean startsWith(String inputString,String matchingString) throws CustomException {
		Helper.validate(inputString);
		Helper.validate(matchingString);
		return matches(inputString,"^"+Pattern.quote(matchingString)+".*$");
	}
	public boolean contains(String inputString,String matchingString) throws CustomException {
		Helper.validate(inputString);
		Helper.validate(matchingString);
		return matches(inputString,"^.*"+Pattern.quote(matchingString)+".*$");
	}
	public boolean endsWith(String inputString,String matchingString) throws CustomException {
		Helper.validate(inputString);
		Helper.validate(matchingString);
		return matches(inputString,"^.*"+Pattern.quote(matchingString)+"$");
	}
	public boolean exactMatch(String inputString,String matchingString) throws CustomException {
		Helper.validate(inputString);
		Helper.validate(matchingString);
		return matches(inputString,"^"+Pattern.quote(matchingString)+"$");
	}
	public int matchIgnoreCase(List<String> list,String matchingString) throws CustomException {
		Helper.validate(list);
		Helper.validate(matchingString);
		int size=list.size(),count=0;
		for(int i=0;i<size;i++) {
			if(matches(list.get(i),"(?i)"+Pattern.quote(matchingString))) {
				count++;
			}
		}
		return count;
	}
	public int lengthMatch(List<String> list,int start,int end) throws CustomException {
		Helper.validate(list);
		Helper.validate(start);
		Helper.validate(end);
		int size=list.size(),count=0;
		for(int i=0;i<size;i++) {
			if(matches(list.get(i),"^[a-zA-Z0-9]{"+start+","+end+"}$")) {
				count++;
			}
		}
		return count;
	}
	public boolean isEmail(String inputString) throws CustomException {
		Helper.validate(inputString);
		return matches(inputString,"^.+@.+\\..+$");
	}
	public Map<String,Integer> matchTwoList(List<String> list1,List<String> list2){
		Map<String,Integer> map=new HashMap<>();
		int size=list1.size();
		for(String string:list2) {
			for(int i=0;i<size;i++) {
				if(matches(string,Pattern.quote(list1.get(i)))) {
					map.put(string,i);
					break;
				}
			}
		}
		return map;
	}
	public List<String> getAllTags(String inputString) throws CustomException{
		Helper.validate(inputString);
		String regex = "<[^>]+>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        List<String> tags = new ArrayList<>();

        while (matcher.find()) {
            tags.add(matcher.group());
        }
        return tags;
	}
	private boolean matches(String inputString,String patternString){
		return Pattern.compile(patternString).matcher(inputString).matches();
	}
}
