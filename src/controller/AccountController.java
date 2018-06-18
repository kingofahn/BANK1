package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;
import serviceImpl.*;
import service.*;

public class AccountController {
	enum AccountButt {
		EXIT, ACCOUNT, MINUS_ACCOUNT, LIST
	};

	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		while (true) {
			AccountButt select = (AccountButt) JOptionPane.showInputDialog(null, "BANK", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUS_ACCOUNT, AccountButt.LIST },
					null);
			switch (select) {
			case EXIT:
				return;

			case ACCOUNT:
				AccountBean account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("Name?"));
				account.setUid(JOptionPane.showInputDialog("ID?")); 
				account.setUid(JOptionPane.showInputDialog("Pass?"));
				service.addList(service.createAccount(account));
				break;
			case MINUS_ACCOUNT:
				MinusAccountBean minusAccount = new MinusAccountBean();
				minusAccount.setName(JOptionPane.showInputDialog("Name?"));
				minusAccount.setUid(JOptionPane.showInputDialog("ID?")); 
				minusAccount.setUid(JOptionPane.showInputDialog("Pass?"));
				service.addList(service.createMinusAccount(minusAccount));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.showResult(service.list()));
				break;
			}
		}
	}
}