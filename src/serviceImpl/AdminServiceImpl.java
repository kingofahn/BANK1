package serviceImpl;

import java.util.*;
import domain.*;
import service.*;

public class AdminServiceImpl implements AdminService {
	private Map<String, AccountBean> accountTable;
	private Map<String, MemberBean> memberTable;

	public AdminServiceImpl() {
		accountTable = new HashMap<>();
		memberTable = new HashMap<>();
	}

	public Map<String, AccountBean> accountList() {
		return accountTable;
	}

	public Map<String, MemberBean> memberList() {
		return memberTable;
	}
}
