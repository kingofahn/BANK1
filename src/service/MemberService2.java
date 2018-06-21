package service;
import java.util.List;
import java.util.Map;

import domain.*;
public interface MemberService2 {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public Map<String,MemberBean> list();  //Arraylist의 최상위 개념인 List로 써야 한다. StaffBean UserBean이 아닌 MemberBean을 쓰는 이유이다.
	public List<MemberBean> findByName(String name);
	public MemberBean findById(MemberBean member);
	public void updatePassword(MemberBean member);
	public void deleteMember(MemberBean member);
}
