package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;
import serviceImpl.*;
import service.*;

public class AccountController {
	public void account() {
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("Name?"));
		account.setUid(JOptionPane.showInputDialog("ID?"));
		account.setPass(JOptionPane.showInputDialog("Pass?"));
		service.createAccount(account);
	}
	
	public void list() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}

	public void findByName() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog("Name?"))));
	}

	public void findById() {
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		JOptionPane.showMessageDialog(null, service.findById(account));
	}

	public void changePass() {
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		account.setPass((JOptionPane.showInputDialog("old Pass?") + "/" + (JOptionPane.showInputDialog("New Pass?"))));
		service.update(account);
	}

	public void deleteAccount() {
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		service.delete(account);
	}
}