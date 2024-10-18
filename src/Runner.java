import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import DB.*;
import pojo.*;
import util.CustomException;
import util.Helper;
public class Runner {
	public static void main(String[] args) throws CustomException{
		APIs apis=new APIs();
		//System.out.println(apis.getBranch(1));
		apis.deleteCustomer(43);
//		alpha dogggg
//		Customer cus = new Customer();
//		cus.setId(44);
//		cus.setUsername("cus7");
//		cus.setPassword("ggss2452key");
//		cus.setPhoneNo(9073439322L);
//		cus.setEmail("nnnn3@gmail.com");
//		cus.setPanNo("MITB1678F");
//		cus.setAadhar(935682802L);
//		cus.setAddress("maaem");
//		cus.setRole("customer");
//		cus.setStatus("inactive");
//		apis.updateCustomer(cus);
		//apis.deleteCustomer(44);
	}
	
	
//	public static void main(String[] args) throws CustomException {
//		CustomerDAOImp aaa=new CustomerDAOImp();
//		Customer cus = new Customer();
//		cus.setId(43);
//		cus.setUsername("cus6");
//		cus.setPassword("pass2452key");
//		cus.setPhoneNo(773439322L);
//		cus.setEmail("a3@gmail.com");
//		cus.setPanNo("GTTB1678F");
//		cus.setAadhar(1235682802L);
//		cus.setAddress("saaaem");
//		cus.setModifiedBy(5);
//		cus.setModifiedTime(Helper.getCurrentTime());
//		//DAOImp.updateObject(cus);
//		System.out.println(pojo.Account.class);
//		//System.out.println(cus.getClass().getSuperclass().get);
//		//aaa.delete(26);
//		//System.out.println(aaa.get(Arrays.asList("id"),Arrays.asList(16)).get(0));
//		
//		//Customer customer = new Customer(); // Create a new Customer object
//
//		/*
//		 * // Set properties using setters customer.setId(26);
//		 * customer.setUsername("cus3"); customer.setPassword("pass1");
//		 * customer.setRole(Role.customer); customer.setPhoneNo(1234567890L);
//		 * customer.setEmail("john.doe@example.com");
//		 * customer.setStatus(Status.inactive);
//		 * customer.setLastLogin(System.currentTimeMillis());
//		 * customer.setPanNo("ABCDE1234F"); customer.setAadhar(987654321012L);
//		 * customer.setAddress("123 Main St, City, Country");
//		 * 
//		 * SQLArguments sql=new SQLArguments(); sql.object= (customer); aaa.update(sql);
//		 */
//		//aaa.delete(11);
//	//aaa.add(cus);
//		//System.out.println(aaa.get(19));
////		EmployeeDAOImp bbb=new EmployeeDAOImp();
////		Employee emp = new Employee();
////		emp.setUsername("emp2");
////		emp.setPassword("pass");
////		emp.setRole(Role.employee);
////		emp.setPhoneNo(1234567890L);
////		emp.setEmail("jdoe@exaple.com");
////		emp.setBranchId(1);
////		bbb.add(emp);
//		
//		//Employee emp = new Employee(14, "emp1", "securePassword", Role.employee, 1234567890L, "jdoe@example.com", Status.active, 1, System.currentTimeMillis(), System.currentTimeMillis(), 1);
//		//bbb.update(emp);
//		
//		//System.out.println(bbb.get(14));
//		//bbb.delete(14);
//		
//		BranchDAOImp ccc=new BranchDAOImp();
//		//Branch branch = new Branch("IFSC1234", "udt Branch", "udumalpet", 5);
//		//ccc.add(branch);
//		
//		//Branch branch = new Branch(2,"IFSC123", "pollachi Branch", "pollachi", 5);
//		//ccc.update(branch);
//		
//		//System.out.println(ccc.get(2));
//		//ccc.delete(6);
//		
//		AccountDAOImp ddd=new AccountDAOImp();
//		Account account = new Account(8,16, 1000,Status.inactive, 1);
//		//ddd.update(account);
//
//		//Account account = new Account(2,16, 10000, Status.active, 1);
//		//ddd.update(account);
//		
//		//System.out.println(ddd.get(2));
//		//ddd.delete(2);
//		
//		TransactionDAOImp eee=new TransactionDAOImp();
//		//Transaction transaction = new Transaction(2, 3, 5, 16, 3000, 1000, "Transfer to savings");
//		//Transaction transaction2 = new Transaction(2, 5, 3, 19, 8000, 1000, "Transfer to savings");
//		//eee.add(transaction2);
//		//eee.add(transaction);	
//		
////		List<Transaction> temp=eee.get(1);
////		System.out.println(temp.get(0));
////		System.out.println(temp.get(1));
//		
//	/*	String url = "jdbc:mysql://localhost:3306/bank"; 
//	    String user = "root";
//	    String password = "Pass#word.09";
//		eee.delete(1);
//		try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet columns = metaData.getColumns(null, null, "account", null);
//            
//            while (columns.next()) {
//                String columnName = columns.getString("COLUMN_NAME");
//                String columnType = columns.getString("TYPE_NAME");
//                System.out.println("Column: " + columnName + ", Type: " + columnType);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        */
//		//System.out.println(Helper.map);
//		UserDAOImp xxx=new UserDAOImp();
//		//xxx.delete(20);
//	}
}
