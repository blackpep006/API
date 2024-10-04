package task11;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import common.CustomException;
import common.Helper;

public class DBRunner {
	DBProcess process;
	Scanner input;
	String DBName="Employee";
	DBRunner(){
		process=new DBProcess();
		input=new Scanner(System.in);
	}
    private void printResultSet(List<Employee> result) throws SQLException {
    	int size=result.size();
    	for(int i=0;i<size;i++) {
    		System.out.println(result.get(i));
    	}
    }
    public void q1() throws CustomException {
    	 process.createTable(DBName);
    }
    public void q2() throws CustomException {
   	 	int size=1;
   	 	for(int i=0;i<size;i++){
   	 		System.out.print("Enter ur ID:");
   	 		int id=input.nextInt();
   	 		System.out.print("Enter ur Name:");
	 		String name=input.next();
	 		System.out.print("Enter ur mobile:");
	 		String mobileNo=input.next();
	 		System.out.print("Enter ur Email:");
	 		String email=input.next();
	 		System.out.print("Enter ur dept:");
	 		String dept=input.next();
   	 		process.addDetail(DBName,id,name,mobileNo,email,dept);
   	 	}
   }
    public void q3() throws CustomException, SQLException {
    	System.out.print("Enter the Name:");
    	String name=input.next();
   	 	printResultSet(process.getDetailForName(DBName,name));
   }
    public void q4() throws CustomException {
    	System.out.print("Enter the id:");
    	int id=input.nextInt();
    	System.out.print("Enter the column You have to update:");
    	String column=input.next();
    	System.out.print("Enter the value:");
    	String value=input.next();
   	 	process.update(DBName,id,column,value);
   }
    public void q5() throws CustomException, SQLException {
    	printResultSet(process.firstNData(DBName,Helper.getInteger()));
    }
    public void q6() throws CustomException, SQLException {
    	System.out.print("Enter the column You have to update:");
    	String column=input.next();
    	System.out.print("Enter the ASC/DESC:");
    	String value=input.next();
    	printResultSet(process.firstNDataWithSort(DBName,column,value,Helper.getInteger()));
    }
    public void q7() throws CustomException, SQLException {
    	process.deleteWithId(DBName,Helper.getInteger());
    }
    public void q9() throws CustomException {
    	String dependentName="dependent";
    	process.createDepadentTable(DBName,dependentName);
    }
    public void q10() throws CustomException {
    	int size=2;
    	String dependentName="dependent";
   	 	for(int i=0;i<size;i++){
   	 		System.out.print("Enter ur ID:");
   	 		int id=input.nextInt();
   	 		System.out.print("Enter ur Name:");
	 		String name=input.next();
	 		System.out.print("Enter ur age:");
	 		int age=input.nextInt();
	 		System.out.print("Enter ur relation:");
	 		String relation=input.next();
   	 		process.addDetailForDependent(dependentName,id, name, age,relation);
   	 	}
    }
    public void q11() throws CustomException {
    	String dependentName="dependent";
    	System.out.print("Enter the id:");
    	int id=input.nextInt();
    	process.dependentDetailsOf(dependentName,id);
    }
    public void q12() throws CustomException {
    	String dependentName="dependent";
    	System.out.print("Enter a number:");
    	process.dependentDetailsOfFirstNEmployees(dependentName, input.nextInt());
    }
    
	public static void main(String[] args) {
		DBRunner runner=new DBRunner();
		try {
			runner.q5();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
