package controller;
import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
import service.*;

public class MemberController {
	public void join() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		member = new UserBean();
		member.setName(JOptionPane.showInputDialog("Name?"));
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setPass(JOptionPane.showInputDialog("Pass?"));
		member.setSsn(JOptionPane.showInputDialog("SSN?"));
		member.setAddr(JOptionPane.showInputDialog("ADRS?"));
		member.setPhone(JOptionPane.showInputDialog("PHONE?"));
		member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
		service.createUser((UserBean) member);
	}

	public void add() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("Name?"));
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setPass(JOptionPane.showInputDialog("Pass?"));
		member.setSsn(JOptionPane.showInputDialog("SSN?"));
		member.setAddr(JOptionPane.showInputDialog("ADRS?"));
		member.setPhone(JOptionPane.showInputDialog("PHONE?"));
		member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
		service.createStaff((StaffBean) member);
	}

	public void list() {
		MemberService service = new MemberServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}

	public void findById() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		JOptionPane.showMessageDialog(null, service.findById(member));
	}

	public void findByName() {
		MemberService service = new MemberServiceImpl();
		JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("name?")));
	}

	public void update() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setUid(JOptionPane.showInputDialog("OldPass?") + "/" + (JOptionPane.showInputDialog("NewPass?")));
		service.updatePassword(member);
	}

	public void withdrawal() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setUid(JOptionPane.showInputDialog("Pass?"));
		service.deleteMember(member);
	}
}