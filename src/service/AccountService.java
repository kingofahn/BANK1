package service;
import domain.*;
public interface AccountService {
	public AccountBean createAccount(AccountBean account);
	public MinusAccountBean createMinusAccount(MinusAccountBean minusAccount);
	public void addList(AccountBean account);
	public AccountBean[] list();
	public String createAccountNum();
	public String createRandom(int start, int end);
	public String createDate();
	public String showResult(AccountBean[] list);
	public String toString(AccountBean account);
}