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
	public void addMinusList(MinusAccountBean minusAccount) {
		minusList[count++] = minusAccount;
	}

	@Override
	public AccountBean[] list() {
		// String res ="";
		// for(int i=0; i<list.length;i++) {
		// res+= list[i]+"\n";
		// }
		// System.out.println("배열 내부 " + res);
		return list;
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
			} else {
				break;
			}
		}
		return acc;
	}

	@Override
	public AccountBean[] findByName(String name) {
		AccountBean[] arr = new AccountBean[countSameWord(name)];
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				arr[cnt] = list[i];
				cnt++;
			}
		}
		return arr;
	}

	@Override
	public int countSameWord(String word) {
		int temp = 0;
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				temp++;
			}
		}
		return temp;
	}

	@Override
	public String changePass(AccountBean account) {
		String msg = "";
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		account = findById(account);
		if (account.getUid() == null) {
			msg = "ID 존재무 혹은 비번 틀립";
		} else {
			if (pass.equals(newPass)) {
				msg = "변경실패";
			} else {
				account.setPass(newPass);
				msg = "변경완료";
			}
		}
		return msg;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String msg = "ID 존재무, 혹은 비번 틀림";
		String pass = account.getPass().split("/")[0];
		String confrimPass = account.getPass().split("/")[1];
		for (int i = 0; i < count; i++) {
			if (account.getUid().equals(list[i].getUid()) && pass.equals(list[i].getPass())
					&& confrimPass.equals(list[i].getPass())) {
				list[i] = list[--count];
				list[count] =null;
				msg = "삭제성공";
				break;
			} else {
				msg = "삭제실패";
			}
		}
		return msg;
	}
}