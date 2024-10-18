package pojo;


public class Transaction  extends Bank{
	private Integer transactionId;
	private Integer accountId;
	private Integer transferAccountId; 
	private Integer customerId;
	private Integer balance;
	private Integer amountTransferred;
	private String remark;
	private Long time;
	private Integer createdBy;


    public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransferAccountId() {
        return transferAccountId;
    }

    public void setTransferAccountId(int transferAccountId) {
        this.transferAccountId = transferAccountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmountTransferred() {
        return amountTransferred;
    }

    public void setAmountTransferred(int amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", transferAccountId=" + transferAccountId +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", amountTransferred=" + amountTransferred +
                ", remark='" + remark + '\'' +
                ", time=" + time +
                ", createdBy=" + createdBy +
                '}';
    }

}

