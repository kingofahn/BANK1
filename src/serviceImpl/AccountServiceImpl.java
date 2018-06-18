package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountBean[] list;
	MinusAccountBean[] minusList;
	int count;

	public AccountServiceImpl() { // 아래 메소드에서 초기화를 하게되면 누적되지 않는 문제가 있어서 일단 생성자에 초기화.
		list = new AccountBean[10000];
		minusList = new MinusAccountBean[10000];
		count = 0;
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setAccountNo(createAccountNum());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setCreateDate(createDate());
		addList(account);
	}

	@Override
	public void createMinusAccount(MinusAccountBean minusAccount) {
		minusAccount.setAccountNo(createAccountNum());
		minusAccount.setAccountType(minusAccount.ACCOUNT_TYPE);
		minusAccount.setCreateDate(createDate());
		addMinusList(minusAccount);
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
		return list;
	}
	
	public void addMinusList(MinusAccountBean minusAccount) {
		minusList[count++] = minusAccount;
	}

	@Override
	public MinusAccountBean[] minusList() {
		return minusList;
	}
	
	
	
	@Override
	public String createAccountNum() {
		String accountNum = "";
		for (int i = 0; i < 3; i++) {
			accountNum += (i != 2) ? String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "-"
					: String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "";
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
	public AccountBean findById(AccountBean account) {
		AccountBean acc = new AccountBean();
		for (int i = 0; i < count; i++) {
			if (account.getUid().equals(list[i].getUid()) && (account.getPass().equals(list[i].getPass()))) {
				acc = list[i];
				break;
			}
		}
		return acc;
		// 배열 list를 looping 하면서
		// id가 일치하고 비번이 일치한
		// 그 객체를 리턴한다.
		// 일단 일치하는 값이 없는 상황은 나중에 처리
	}

	@Override
	public AccountBean[] findByName(String name) {
		AccountBean[] arr = new AccountBean[countSameWord(name)];
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				arr[i]=list[i];
			}
		}
		return arr;
	}

	public String findByNameResult(AccountBean[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i].toString() + "\n";
		}
		return result;
	}
	
	@Override
	public int countSameWord(String word) {
		int temp = 0; 
		String result = "";
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				temp++;
			}
		}
		return temp;
	}
}