package task9.threadlocal;

public class ClassB {
	ClassC cClass;
	ClassB(){
		cClass=new ClassC();
	}
	public String verifyAndGetData() {
		//verification
		
		return cClass.getDataFromDB();
	}
}
