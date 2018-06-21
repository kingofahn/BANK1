package controller;

import java.util.List;

import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
import service.*;

public class AdminController {
	enum AdminButt {
		EXIT, ADD, // create //JOIN은 일바유저 추가 ADD는 직원추가
		LIST, FIND_BY_ID, FIND_BY_NAME, COUNT, // read ALL, ONE, SOME
		UPDATE, // update
		REMOVE // delete
	};

	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl(); // sub class의 datatype 을 super class로 정의
		MemberBean member = null;
		while (true) {
			AdminButt select = (AdminButt) JOptionPane.showInputDialog(null, "BANK", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null,
					new AdminButt[] { 
							AdminButt.EXIT, 
							AdminButt.ADD, 
							AdminButt.LIST,
							AdminButt.FIND_BY_ID, 
							AdminButt.FIND_BY_NAME, 
							AdminButt.COUNT, 
							AdminButt.UPDATE,
							AdminButt.REMOVE },
					null);
			switch (select) {
			case EXIT:
				return;
			case ADD:
				break;
			case LIST:
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case COUNT:
				break;
			case UPDATE:
				break;
			case REMOVE:
				break;
			default:
				break;
			}
		}
	}
}