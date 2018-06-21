package service;
import java.util.List;
import java.util.Map;
import domain.*;
public interface AccountService2 {
	public void createAccount(AccountBean account);
	public void createMinus(MinusAccountBean account);
	public Map<String,AccountBean> list();
	public List<AccountBean> findByName(String param);
	public AccountBean findById(AccountBean account);
	public void delete(AccountBean account);
	public void update(AccountBean account);
	public String createRandom(int start, int end);
	public String createDate();
	public String createAccountNo();
}
