package controller;

import javax.swing.JOptionPane;

import domain.Account;
import service.*;
import serviceImpl.*;
enum AccountButt {
	EXIT, ACCOUNT, MINUS_ACCOUNT,DEPOSIT,WITHDRAW,LIST
}
public class AccountController {
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		while(true){
			switch((AccountButt)JOptionPane.showInputDialog(
                    null,
                    "Choice of Account Type",
                    "Select Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new AccountButt[]{
                    	AccountButt.EXIT, 
            			AccountButt.ACCOUNT, 
            			AccountButt.LIST	
                    },null)){
					case EXIT : return;
		            case ACCOUNT : 
		            	Account account = service.createAccount( //값을 줬으니 a가 받아야 한다.
		            			JOptionPane.showInputDialog("NAME?"),
		            			JOptionPane.showInputDialog("ID?"),
		            			JOptionPane.showInputDialog("PASS?"));
		            	service.addList(account);
		            	break;
		            case LIST : 
		            	JOptionPane.showMessageDialog(null,service.showResult());
		            	break;
					default:
						break;
		        
		     }
		}
	}
}