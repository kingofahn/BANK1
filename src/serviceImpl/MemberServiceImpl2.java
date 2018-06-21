package serviceImpl;

import java.util.*;
import domain.*;
import service.MemberService2;

public class MemberServiceImpl2 implements MemberService2 {
	Map<String, MemberBean> map; // generic타입으로 list를 만든다.

	public MemberServiceImpl2() {
		map = new HashMap<>();
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("999");
		map.put(staff.getUid(), staff);
	}

	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(), user);
	}

	@Override
	public Map<String, MemberBean> list() {
		return map;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		for(Map.Entry<String, MemberBean> e:map.entrySet()) { // Entry는 키값은 날리고 value만 있는 상태이다. 이것을 셋에 담는다.
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue()); // e.getValue()는 Instrance를 반환하고 set에 넣어도 인스턴스는 중복값으로 인식되지 않는다.
			}
		}
		Iterator<MemberBean> it = set.iterator(); // Iterator가 순서없이 뒤지는 것이다.
		while(it.hasNext()) {  	// hasNext() 값이 없으면 스톱한다.
			temp.add(it.next());
		}
		System.out.println();
		return temp;
	}

	@Override 
	public MemberBean findById(MemberBean member) {
		return map.get(member.getUid());
	}

	@Override
	public void updatePassword(MemberBean member) { // new pass만 가지고 있을 것 같음
		String id = member.getUid();
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		MemberBean mbr = map.get(id);
		if (mbr == null) {
			System.out.println("수정하려는 id가 없음!!");
		} else {
			if (oldPass.equals(mbr.getPass())) {
				mbr.setPass(newPass);
				map.put(id, mbr);
			} 
		}
	}

	@Override
	public void deleteMember(MemberBean member) {
		map.remove(member.getUid());
		// list.remove(search(member)); 위를 줄이면 아래와같이 할 수 있다.
	}
};