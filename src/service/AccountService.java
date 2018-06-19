package service;
import domain.*;
public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinusAccount(MinusAccountBean minusAccount);
	public void addList(AccountBean account);
	public void addMinusList(MinusAccountBean minusAccount);
	public AccountBean[] list();
	public MinusAccountBean[] minusList();
	public String createAccountNum();
	public String createRandom(int start, int end);
	public String createDate();
	public AccountBean findById(AccountBean account); //인터페이스에 없는 추상메소드를 할때는 controller에서 
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
	public String changePass(AccountBean account);
	public String deleteAccount(AccountBean account);
}