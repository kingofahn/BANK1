package serviceImpl;

import domain.Account;
import service.AccountService;
public class AccountServiceImpl implements AccountService{
	private Account[] list;
	private int count;
	public AccountServiceImpl() {
		list = new Account[10];	
	}
	@Override
	public Account createAccount(String name, String uid, String pass) {
		Account account = new Account(); // Account에 값을 넘겨주기 위해서
		account.setAccountNo(createAccountNum(createRandom(0,999)));
//		account.setAccountType(accountType); 구현불가
		account.setCreateDate(createDate());
//		account.setMoney(money); deposit 에서 처리
		account.setName(name);
		account.setPass(pass);
		account.setUid(uid);
		return account;
	}

	@Override
	public void addList(Account account) {
		list[count++] = account;
	}
	@Override
	public Account[] list() {
		Account[] arr = new Account[100];
		return arr;
	}
	@Override
	public String createAccountNum(String random) {
		String accountNum ="";
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		String random="";
		return random;
	}

	@Override
	public String createDate() {
		String date = "";
		// TODO Auto-generated method stub
		return date;
	}
	@Override
	public String showResult() {
		String result = "";
		for(int i=0; i<count;i++) {
			result+=list[i].toString();
		}
		return result;
	}
}
