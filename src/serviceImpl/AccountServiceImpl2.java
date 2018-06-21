package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.*;
import service.AccountService2;

public class AccountServiceImpl2 implements AccountService2 {
	Map<String, AccountBean> map;

	public AccountServiceImpl2() {
		map = new HashMap<>();
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setCreateDate(createDate());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setAccountNo(createAccountNo());
		map.put(account.getUid(), account);
	}

	public void createMinus(MinusAccountBean mAccount) {
		mAccount.setCreateDate(createDate());
		mAccount.setAccountType(MinusAccountBean.ACCOUNT_TYPE);
		mAccount.setAccountNo(createAccountNo());
		map.put(mAccount.getUid(), mAccount);
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
	public Map<String, AccountBean> list() {
		return map;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> temp = new ArrayList<>();
		Set<AccountBean> set = new HashSet<>();
		for(Map.Entry<String, AccountBean> e:map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());
			}
		}
		Iterator<AccountBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}
	@Override
	public AccountBean findById(AccountBean account) {
		return map.get(account.getUid());
	}

	@Override
	public void delete(AccountBean account) {
		map.remove(account.getUid());
	}

	@Override
	public void update(AccountBean account) {
		String id = account.getUid();
		String oldPass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		AccountBean acc = map.get(id);
		if (acc == null) {
			System.out.println("Null!");
		} else {
			if (oldPass.equals(acc.getPass())) {
				acc.setPass(newPass);
				map.put(id, acc);
			}
		}
	}
}