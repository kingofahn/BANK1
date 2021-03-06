package service;
import java.util.List;
import domain.*;
public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public List<MemberBean> list();  //Arraylist의 최상위 개념인 List로 써야 한다. StaffBean UserBean이 아닌 MemberBean을 쓰는 이유이다.
	public List<MemberBean> findByName(String param);
	public MemberBean findById(MemberBean member);
	public void updatePassword(MemberBean member);
	public void deleteMember(MemberBean member);
}
