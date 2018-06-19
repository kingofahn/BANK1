package serviceImpl;

import domain.AccountBean;
import domain.MemberBean;
import domain.StaffBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean[] list;
	int count;

	public MemberServiceImpl() {
		list = new MemberBean[10000];
		count = 0;
	}

	@Override
	public void createUserMember(MemberBean member) {
		addList(member);
	}

	public void createStaffMember(StaffBean member) {
		addList(member);
	}

	private void addList(MemberBean member) {
		list[count++] = member;
	}

	@Override
	public MemberBean[] memberlist() {
		return list;
	}

	@Override
	public MemberBean memberFindById(MemberBean member) {
		MemberBean mbr = new MemberBean();
		for (int i = 0; i < count; i++) {
			if (member.getUid().equals(list[i].getUid()) && member.getPass().equals(list[i].getPass())) {
				mbr = list[i];
				break;
			}
		}
		return mbr;
	}

	@Override
	public MemberBean[] memberFindByName(String name) {
		MemberBean[] arr = new MemberBean[countSameWord(name)];
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				arr[cnt++] = list[i];
			}
		}
		return arr;
	}

	public int countSameWord(String name) {
		int sameWord = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				sameWord++;
			}
		}
		return sameWord;
	}

	@Override
	public String memberUpdate(MemberBean member) {
		String msg = "";
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		member.setPass(oldPass);
		member = memberFindById(member);
		if (member.getUid() == null) {
			msg = "ID 없거나 비번 틀림";
		} else {
			if (oldPass.equals(newPass)) {
				msg = "변경실패";
			} else {
				member.setPass(newPass);
				msg = "변경완료";
			}
		}
		return msg;
	}

	@Override
	public String memberDelete(MemberBean member) {
		String msg = "";
		String pass = member.getPass().split("/")[0];
		String confirmPass = member.getPass().split("/")[1];
		member.setPass(pass);
		member = memberFindById(member);
		for (int i = 0; i < count; i++) {
			if (list[i].getUid().equals(member.getUid()) && pass.equals(list[i].getPass())
					&& pass.equals(confirmPass)) {
				list[i] = list[--count];
				list[count] = null;
				msg = "Completed";
				break;
			} else {
				msg = "Error";
			}
		}
		return msg;

	}

	@Override
	public String getCount() {
		return count+"명";
	}
}
