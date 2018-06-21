package view;

import javax.swing.JOptionPane;

import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class Index {

	enum MemberButt {
		EXIT, JOIN, ADD, // create //JOIN은 일바유저 추가 ADD는 직원추가
		LIST, FIND_BY_ID, FIND_BY_NAME, COUNT, // read ALL, ONE, SOME
		UPDATE, // update
		WITHDRAWAL // delete
	};

	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl(); // sub class의 datatype 을 super class로 정의
		MemberBean member = null;
		while (true) {
			MemberButt select = (MemberButt) JOptionPane.showInputDialog(null, "BANK", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null,
					new MemberButt[] { MemberButt.EXIT, MemberButt.JOIN, MemberButt.ADD, MemberButt.LIST,
							MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME, MemberButt.COUNT, MemberButt.UPDATE,
							MemberButt.WITHDRAWAL },
					null);

			switch (select) {
			case EXIT:
				return;
			case JOIN:
				member = new UserBean();
				member.setName(JOptionPane.showInputDialog("Name?"));
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setPass(JOptionPane.showInputDialog("Pass?"));
				member.setSsn(JOptionPane.showInputDialog("SSN?"));
				member.setAddr(JOptionPane.showInputDialog("ADRS?"));
				member.setPhone(JOptionPane.showInputDialog("PHONE?"));
				member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
				service.createUser((UserBean) member);
				break;
			case ADD:
				member = new StaffBean();
				member.setName(JOptionPane.showInputDialog("Name?"));
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setPass(JOptionPane.showInputDialog("Pass?"));
				member.setSsn(JOptionPane.showInputDialog("SSN?"));
				member.setAddr(JOptionPane.showInputDialog("ADRS?"));
				member.setPhone(JOptionPane.showInputDialog("PHONE?"));
				member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
				service.createStaff((StaffBean) member);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				JOptionPane.showMessageDialog(null, service.findById(member));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("name?")));
				break;
			case UPDATE:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setUid(
						JOptionPane.showInputDialog("OldPass?") + "/" + (JOptionPane.showInputDialog("NewPass?")));
				service.updatePassword(member);
				break;
			case WITHDRAWAL:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setUid(JOptionPane.showInputDialog("Pass?"));
				service.deleteMember(member);
				break;
			default:
				break;
			}
		}
	}
}