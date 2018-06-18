package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountBean[] list;
	int count;
	String input;

	public AccountServiceImpl() { // 아래 메소드에서 초기화를 하게되면 누적되지 않는 문제가 있어서 일단 생성자에 초기화.
		list = new AccountBean[10000];
		count = 0;
		input ="";
	}

	@Override
	public AccountBean createAccount(AccountBean account) {
		account.setAccountNo(createAccountNum());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setCreateDate(createDate());
		return account;
	}
	
	@Override
	public MinusAccountBean createMinusAccount(MinusAccountBean minusAccount) {
		minusAccount.setAccountNo(createAccountNum());
		minusAccount.setAccountType(minusAccount.ACCOUNT_TYPE);
		minusAccount.setCreateDate(createDate());
		return minusAccount;
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
		return list;
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		for (int i = 0; i < 3; i++) {
			accountNum += (i != 2) ? String.format("%03d", Integer.parseInt(createRandom(1, 999))) + "-"
					: String.format("%03d", Integer.parseInt(createRandom(1, 999))) + "";
		}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.valueOf((int) (Math.random() * (end + 1)) + start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String showResult(AccountBean[] list) {
		String result = "";
		list = list();
		for (int i = 0; i < count; i++) {
			result += toString(list[i]) + "\n";
		}
		return result;
	}

	@Override
	public String toString(AccountBean account) {
		return String.format("%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 잔액 : %s 원 ", account.BANK_NAME,
				account.accountType, account.accountNo, account.name, account.createDate, account.money);
	}
}