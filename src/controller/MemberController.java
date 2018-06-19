package controller;
import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
import service.*;

public class MemberController {
	enum MemberButt {
		EXIT, JOIN, ADD, // create //JOIN은 일바유저 추가 ADD는 직원추가
		LIST, FIND_BY_ID, FIND_BY_NAME, COUNT, // read ALL, ONE, SOME
		UPDATE, // update
		WITHDRAWAL // delete
	};

	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl(); // sub class의 datatype 을 super class로 정의
		MemberBean member = null;
		UserBean userMember = null;
		StaffBean staffMember = null;
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
				userMember = new UserBean();
				userMember.setName(JOptionPane.showInputDialog("Name?"));
				userMember.setUid(JOptionPane.showInputDialog("ID?"));
				userMember.setPass(JOptionPane.showInputDialog("Pass?"));
				userMember.setSsn(JOptionPane.showInputDialog("SSN?"));
				userMember.setAddr(JOptionPane.showInputDialog("ADRS?"));
				userMember.setPhone(JOptionPane.showInputDialog("PHONE?"));
				userMember.setEmail(JOptionPane.showInputDialog("EMAIL?"));
				service.createUserMember(userMember);
				break;
			case ADD:
				staffMember = new StaffBean();
				staffMember.setName(JOptionPane.showInputDialog("Name?"));
				staffMember.setUid(JOptionPane.showInputDialog("ID?"));
				staffMember.setPass(JOptionPane.showInputDialog("Pass?"));
				staffMember.setSsn(JOptionPane.showInputDialog("SSN?"));
				staffMember.setAddr(JOptionPane.showInputDialog("ADRS?"));
				staffMember.setPhone(JOptionPane.showInputDialog("PHONE?"));
				staffMember.setEmail(JOptionPane.showInputDialog("EMAIL?"));
				service.createStaffMember(staffMember);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.memberlist());
				break;
			case FIND_BY_ID:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setPass(JOptionPane.showInputDialog("Pass?"));
				JOptionPane.showMessageDialog(null,service.memberFindById(member));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null,service.memberFindByName(JOptionPane.showInputDialog("Name?")));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null,service.getCount());
				break;
			case UPDATE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setPass(
						   (JOptionPane.showInputDialog("Pass?"))
									+ "/" + 
						   (JOptionPane.showInputDialog("New Pass?")));
				
				JOptionPane.showMessageDialog(null,service.memberUpdate(member));
				break;
			case WITHDRAWAL:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID?"));
				member.setPass(
						   (JOptionPane.showInputDialog("Pass?"))
									+ "/" + 
						   (JOptionPane.showInputDialog("Confirm Pass?")));
				
				JOptionPane.showMessageDialog(null,service.memberDelete(member));
				break;
			default:
				break;
			}
		}
	}
}
