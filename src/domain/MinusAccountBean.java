package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE = "마이너스통장";
	public int limit; // 대출한도

	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setLimit(int limit) {
		this.limit = -limit;
	}

	public int getLimit() {
		return limit;
	}

	public String toString() {
		return String.format("%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 잔액 : %s 원 \n 한도 : %s 원 \n비밀번호 : ****** ",
				BANK_NAME, accountType, accountNo, name, createDate, money, limit);
	}
}