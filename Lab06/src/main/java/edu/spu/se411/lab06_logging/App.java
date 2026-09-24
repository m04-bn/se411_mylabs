package edu.spu.se411.lab06_logging;

import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;
import edu.spu.se411.lab06_logging.model.WalletAccount;

public class App {
	

	public static void main(String[] args) {
		
		WalletAccount account = new WalletAccount(1000);
        try {
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
	}

}
