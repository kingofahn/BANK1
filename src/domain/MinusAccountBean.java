package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE="마이너스통장";
	
	@Override
	public void setAccountType(String accountType) {
		this.accountType=accountType;
	}
}