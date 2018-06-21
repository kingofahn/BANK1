package serviceImpl;
import java.util.List;
import java.util.ArrayList;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService {
	List<MemberBean> list; // generic타입으로 list를 만든다.

	public MemberServiceImpl() {
		list = new ArrayList<MemberBean>();
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("999");
		list.add(staff);
	}

	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		list.add(user);
	}

	@Override
	public List<MemberBean> list() {
		return list;
	}

	@Override
	public List<MemberBean> findByName(String param) {
		List<MemberBean> temp = new ArrayList<>();
		for (MemberBean e : list) {
			if (param.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
		
//	public List<MemberBean> temp = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			if (param.equals(list.get(i).getName())) {
//				temp.add(list.get(i));
//			}
//		}
//		return temp;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean mbr = new MemberBean();
		for (MemberBean e : list) {
			if (member.getUid().equals(e.getUid())) {
				mbr = e;
				break;
			}
		}
		return mbr;
		
//		MemberBean mbr = new MemberBean();
//		for (int i = 0; i < list.size(); i++) {
//			if (member.getUid().equals(list.get(i).getUid())) {
//				mbr = list.get(i);
//				break;
//			}
//		}
//		return mbr;
	}

	@Override
	public void updatePassword(MemberBean member) { // new pass만 가지고 있을 것 같음
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		MemberBean mbr = new MemberBean();
		mbr.setPass(oldPass);
		list.get(list.indexOf(findById(mbr))).setPass(newPass);
	}

	@Override
	public void deleteMember(MemberBean member) {
		list.remove(list.indexOf(findById(member)));
		// list.remove(search(member)); 위를 줄이면 아래와같이 할 수 있다.
	}
}
