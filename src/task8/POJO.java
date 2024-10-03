package task8;

import common.CustomException;
import common.Helper;

public class POJO {
	private String string;
	private int number;
	public POJO(){
		
	}
	public POJO(String string,int value){
		this.string=string;
		this.number=value;
	}
	public String getString() {
		return this.string;
	}
	public void setString(String string) throws CustomException {
		Helper.validate(string);
		this.string=string;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) throws CustomException {
		Helper.validate(number);
		this.number=number;
	}
	@Override
	public String toString() {
		return "str :"+string+"   num :"+number;
	}
}
