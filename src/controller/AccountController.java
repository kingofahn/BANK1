package controller;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;
import serviceImpl.*;
import service.*;

public class AccountController {
	enum AccountButt {
		EXIT, ACCOUNT, MINUS_ACCOUNT, LIST, FIND_BY_ID, FIND_BY_NAME, MINUS_LIST, CHANGE_PASS,DELETE_ACCOUNT
	};

	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();  //  sub class의 datatype 을 super class로 정의
		AccountBean account =null;
		MinusAccountBean minusAccount = null;
		while (true) {
			AccountButt select = (AccountButt) JOptionPane.showInputDialog(null, "BANK", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUS_ACCOUNT, AccountButt.LIST, AccountButt.MINUS_LIST, AccountButt.FIND_BY_ID,
							AccountButt.FIND_BY_NAME , AccountButt.CHANGE_PASS, AccountButt.DELETE_ACCOUNT},
							null);
		 
			switch (select) {
			case EXIT:
				return;

			case ACCOUNT:
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("Name?"));
				account.setUid(JOptionPane.showInputDialog("ID?"));
				account.setPass(JOptionPane.showInputDialog("Pass?"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT:
				minusAccount = new MinusAccountBean();
				minusAccount.setName(JOptionPane.showInputDialog("Name?"));
				minusAccount.setUid(JOptionPane.showInputDialog("ID?"));
				minusAccount.setPass(JOptionPane.showInputDialog("Pass?"));
				minusAccount.setLimit(Integer.parseInt(JOptionPane.showInputDialog("Limit?")));
				service.createMinusAccount(minusAccount);
				break;
			case MINUS_LIST:
				JOptionPane.showMessageDialog(null, service.minusList());
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_NAME: 
				JOptionPane.showMessageDialog(null,service.findByName(JOptionPane.showInputDialog("Name?")));
				break;
			case FIND_BY_ID:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("ID?"));
				account.setPass(JOptionPane.showInputDialog("Pass?"));
				JOptionPane.showMessageDialog(null, service.findById(account));
				break;
			case CHANGE_PASS:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("ID?"));
				account.setPass(
						   (JOptionPane.showInputDialog("Pass?"))
									+ "/" + 
						   (JOptionPane.showInputDialog("New Pass?")));
				JOptionPane.showMessageDialog(null,service.changePass(account));
				break;
			case DELETE_ACCOUNT: 
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("ID?"));
				account.setPass(
						   (JOptionPane.showInputDialog("Pass?"))
									+ "/" + 
						   (JOptionPane.showInputDialog("Confirm Pass?")));
				JOptionPane.showMessageDialog(null, service.deleteAccount(account));
				
				break;
			default :break;
			}
		}
	}
}