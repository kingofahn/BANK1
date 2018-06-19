package service;

import domain.MemberBean;
import domain.StaffBean;

public interface MemberService {
	public void createUserMember(MemberBean member);
	public void createStaffMember(StaffBean staffMember);
	public MemberBean[] memberlist();
	public MemberBean memberFindById(MemberBean member);
	public MemberBean[] memberFindByName(String name);
	public String memberUpdate(MemberBean member);
	public String memberDelete(MemberBean member);
	public String getCount();
}
