package DB;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pojo.Condition;
import pojo.Account;
import pojo.Branch;
import pojo.Customer;
import pojo.Employee;
import pojo.SQLArguments;
import pojo.Transaction;
import pojo.User;
import util.CustomException;
import util.Helper;
public class APIs {
	private SQLArguments arguments;
	public int createAccount(Account account) throws CustomException {
		account.setCreatedBy(Helper.getUserData().getId());
		account.setCreatedTime(Helper.getCurrentTime());
		return DAOImp.insert(account);
	}
	
	public int createCustomer(Customer customer) throws CustomException {
		customer.setCreatedBy(Helper.getUserData().getId());
		customer.setCreatedTime(Helper.getCurrentTime());
		return DAOImp.insert(customer);
	}
	
	public int createEmployee(Employee employee) throws CustomException {
		employee.setCreatedBy(Helper.getUserData().getId());
		employee.setCreatedTime(Helper.getCurrentTime());
		return DAOImp.insert(employee);
	}
	
	public int createBranch(Branch branch) throws CustomException {
		branch.setCreatedBy(Helper.getUserData().getId());
		branch.setCreatedTime(Helper.getCurrentTime());
		return DAOImp.insert(branch);
	}
	
	public int createTransactionWithInBank(int fromAccount,int toAccount,int amount) throws CustomException {
		Account fromAccountDetails=getAccount(fromAccount);
		if(fromAccountDetails.getBalance()<amount) {
			throw new CustomException("Ammount Insufficient");
		}
		Account toAccountDetails=getAccount(toAccount);
		
		Transaction trans=new Transaction();
		trans.setAccountId(fromAccount);
		trans.setTransferAccountId(toAccount);
		trans.setCustomerId(fromAccountDetails.getUserId());
		trans.setAmountTransferred(amount);
		trans.setBalance(fromAccountDetails.getBalance()-amount);
		trans.setRemark("Debited");
		trans.setCreatedBy(Helper.getUserData().getId());
		trans.setTime(Helper.getCurrentTime());
		int id=DAOImp.insert(trans);
		fromAccountDetails.setBalance(fromAccountDetails.getBalance()-amount);
		updateAccount(fromAccountDetails);
		
		trans.setAccountId(toAccount);
		trans.setTransferAccountId(fromAccount);
		trans.setCustomerId(toAccountDetails.getUserId());
		trans.setBalance(toAccountDetails.getBalance()+amount);
		trans.setRemark("Credicted");
		trans.setTransactionId(id);
		DAOImp.insert(trans);
		toAccountDetails.setBalance(toAccountDetails.getBalance()+amount);
		updateAccount(toAccountDetails);
		return id;
	}
	public int createTransactionOutsideBank(int fromAccount,int toAccount,int amount) throws CustomException{
		Account fromAccountDetails=getAccount(fromAccount);
		if(fromAccountDetails.getBalance()<amount) {
			throw new CustomException("Ammount Insufficient");
		}
		Transaction trans=new Transaction();
		trans.setAccountId(fromAccount);
		trans.setCustomerId(fromAccountDetails.getUserId());
		trans.setAmountTransferred(amount);
		trans.setBalance(fromAccountDetails.getBalance()-amount);
		trans.setRemark("Debited");
		trans.setCreatedBy(Helper.getUserData().getId());
		trans.setTime(Helper.getCurrentTime());
		int id=DAOImp.insert(trans);
		fromAccountDetails.setBalance(fromAccountDetails.getBalance()-amount);
		updateAccount(fromAccountDetails);
		return id;
	}
	public int createTransactionWithdraw(int accountId,int amount) throws CustomException{
		Account fromAccountDetails=getAccount(accountId);
		if(fromAccountDetails.getBalance()<amount) {
			throw new CustomException("Ammount Insufficient");
		}
		Transaction trans=new Transaction();
		trans.setAccountId(accountId);
		trans.setCustomerId(fromAccountDetails.getUserId());
		trans.setAmountTransferred(amount);
		trans.setBalance(fromAccountDetails.getBalance()-amount);
		trans.setRemark("Withdraw");
		trans.setCreatedBy(Helper.getUserData().getId());
		trans.setTime(Helper.getCurrentTime());
		int id=DAOImp.insert(trans);
		fromAccountDetails.setBalance(fromAccountDetails.getBalance()-amount);
		updateAccount(fromAccountDetails);
		return id;
	}
	public int createTransactionDeposite(int accountId,int amount) throws CustomException{
		Account fromAccountDetails=getAccount(accountId);
		if(fromAccountDetails.getBalance()<amount) {
			throw new CustomException("Ammount Insufficient");
		}
		Transaction trans=new Transaction();
		trans.setAccountId(accountId);
		trans.setCustomerId(fromAccountDetails.getUserId());
		trans.setAmountTransferred(amount);
		trans.setBalance(fromAccountDetails.getBalance()+amount);
		trans.setRemark("Deposit");
		trans.setCreatedBy(Helper.getUserData().getId());
		trans.setTime(Helper.getCurrentTime());
		int id=DAOImp.insert(trans);
		fromAccountDetails.setBalance(fromAccountDetails.getBalance()+amount);
		updateAccount(fromAccountDetails);
		return id;
	}
	
	public void updateAccount(Account account) throws CustomException {
		account.setModifiedBy(Helper.getUserData().getId());
		account.setModifiedTime(Helper.getCurrentTime());
		DAOImp.updateObject(account);
	}
	public void updateBranch(Branch branch) throws CustomException {
		branch.setModifiedBy(Helper.getUserData().getId());
		branch.setModifiedTime(Helper.getCurrentTime());
		DAOImp.updateObject(branch);
	}
	public void updateCustomer(Customer customer) throws CustomException {
		customer.setModifiedBy(Helper.getUserData().getId());
		customer.setModifiedTime(Helper.getCurrentTime());
		DAOImp.updateObject(customer);
	}
	public void updateEmployee(Employee employee) throws CustomException {
		employee.setModifiedBy(Helper.getUserData().getId());
		employee.setModifiedTime(Helper.getCurrentTime());
		DAOImp.updateObject(employee);
	}
	public void deleteCustomer(int id) throws CustomException {
		arguments=new SQLArguments();
		arguments.setUpdate(Arrays.asList(new Condition("status","inactive")));
		arguments.setWhere(Arrays.asList(new Condition("id",id)));
		arguments.setClazz(pojo.Customer.class);
		DAOImp.update(arguments);
	}
	public void deleteEmployee(int id) throws CustomException {
		arguments=new SQLArguments();
		arguments.setUpdate(Arrays.asList(new Condition("status","inactive")));
		arguments.setWhere(Arrays.asList(new Condition("id",id)));
		arguments.setClazz(pojo.Employee.class);
		DAOImp.update(arguments);
	}
	public void deleteAccount(int id) throws CustomException {
		arguments=new SQLArguments();
		arguments.setUpdate(Arrays.asList(new Condition("status","inactive")));
		arguments.setWhere(Arrays.asList(new Condition("id",id)));
		arguments.setClazz(pojo.Account.class);
		DAOImp.update(arguments);
	}
	public void deleteBranch(int id) throws CustomException {
		arguments=new SQLArguments();
		arguments.setUpdate(Arrays.asList(new Condition("status","inactive")));
		arguments.setWhere(Arrays.asList(new Condition("id",id)));
		arguments.setClazz(pojo.Branch.class);
		DAOImp.update(arguments);
	}
	
	//get

	public Account getAccount(int accountNo) throws CustomException {
		arguments=new SQLArguments();
		arguments.setWhere(Arrays.asList(new Condition("id",accountNo),new Condition("status","active")));
		arguments.setClazz(Account.class);
		return (Account) DAOImp.get(arguments).get(0);
	}

	public Customer getCustomer(int id) throws CustomException{
		arguments=new SQLArguments();
		arguments.setWhere(Arrays.asList(new Condition("customer.id",id),new Condition("status","active")));
		arguments.setClazz(pojo.Customer.class);
		arguments.setJoinTable(pojo.User.class);
		arguments.setJoinCondition("user.id=customer.id");
		return (Customer) DAOImp.get(arguments).get(0);
	}
	
	public Employee getEmployee(int id) throws CustomException{
		arguments=new SQLArguments();
		arguments.setWhere(Arrays.asList(new Condition("employee.id",id),new Condition("status","active")));
		arguments.setClazz(pojo.Employee.class);
		arguments.setJoinTable(pojo.User.class);
		arguments.setJoinCondition("user.id=employee.id");
		return (Employee) DAOImp.get(arguments).get(0);
	}
	
	public Branch getBranch(int branchId) throws CustomException {
		arguments=new SQLArguments();
		arguments.setWhere(Arrays.asList(new Condition("id",branchId),new Condition("status","active")));
		arguments.setClazz(pojo.Branch.class);
		return (Branch) DAOImp.get(arguments).get(0);
	}
	
	public List<Transaction> getTransactionForAccountAndCustomer(Integer accountId,Integer customerId) throws CustomException{
		arguments=new SQLArguments();
		arguments.setClazz(pojo.Transaction.class);
		List<Condition> condtion=new ArrayList<>();
		if(accountId!=null) {
			condtion.add(new Condition("account_id",accountId));
		}
		if(customerId!=null) {
			condtion.add(new Condition("customer_id",customerId));
		}
		arguments.setWhere(condtion);
		return DAOImp.get(arguments);
	}
	
	public List<Account> getAccountForBranchAndCustomer(Integer branchId,Integer customerId) throws CustomException{
		arguments=new SQLArguments();
		arguments.setClazz(pojo.Account.class);
		List<Condition> condtion=new ArrayList<>();
		if(branchId!=null) {
			condtion.add(new Condition("account_id",branchId));
		}
		if(customerId!=null) {
			condtion.add(new Condition("customer_id",customerId));
		}
		arguments.setWhere(condtion);
		return DAOImp.get(arguments);
	}
	public List<Employee> getEmployeeForBranch(int id) throws CustomException{
		arguments=new SQLArguments();
		arguments.setClazz(Employee.class);
		arguments.setJoinTable(pojo.User.class);
		arguments.setWhere(Arrays.asList(new Condition("branch_id",id)));
		arguments.setJoinCondition("user.id=employee.id");
		return DAOImp.get(arguments);
	}
	public List<Branch> getBranchForManager(int id) throws CustomException{
		arguments=new SQLArguments();
		arguments.setClazz(pojo.Branch.class);
		arguments.setWhere(Arrays.asList(new Condition("manager_id",id)));
		return DAOImp.get(arguments);
	}
	public String checkPassword(String username,String password) throws CustomException {
		arguments=new SQLArguments();
		arguments.setClazz(pojo.User.class);
		arguments.setWhere(Arrays.asList(new Condition("username",username)));
		User user=(User) DAOImp.get(arguments).get(0);
		if(user.getPassword().equals(password)) {
			Helper.setUserData(user);
			return user.getRole();
		}
		return null;
	}
}
