package domain;

public class Account {
	protected int money;
	protected String name, uid, pass, createDate, accountType, accountNum;

	public void setName(String name) {
		this.name = name;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNo(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getUid() {
		return uid;
	}

	public String getPass() {
		return pass;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNo() {
		return accountNum;
	}

	public String toString() {
			return String.format("계좌번호 : %s\n" 
								+ "이름 : %s\n" 
								+ "생성일 : %s\n" 
								+ "잔액 : %d\n",
								accountNum, 
								name, 
								createDate, 
								money);
	}
}
