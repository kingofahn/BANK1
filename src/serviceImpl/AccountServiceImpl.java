package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	List<AccountBean> list;

	public AccountServiceImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setCreateDate(createDate());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setAccountNo(createAccountNo());
		list.add(account);
	}

	@Override
	public String createAccountNo() {
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
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public List<AccountBean> serachByName(String param) {
		List<AccountBean> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (param.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean searchById(AccountBean account) {
		AccountBean acc = new AccountBean();
		for (int i = 0; i < list.size(); i++) {
			if (account.getUid().equals(list.get(i).getUid())) {
				acc = list.get(i);break;
			}
		}
		return acc;
	}
	@Override
	public void delete(AccountBean account) {
		list.remove(list.indexOf(searchById(account)));
	}

	@Override
	public void update(AccountBean account) {
		list.get(list.indexOf(searchById(account))).setPass(account.getPass());
	}

}