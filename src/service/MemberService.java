package service;
import java.util.List;
import domain.*;
public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public List<MemberBean> list();  //Arraylist의 최상위 개념인 List로 써야 한다. StaffBean UserBean이 아닌 MemberBean을 쓰는 이유이다.
	public List<MemberBean> Search(String param);
	public MemberBean search(MemberBean member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
	
}
