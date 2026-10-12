package edu.psu.se411.lab11_threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab11_threads.model.CryptoAccount;
import edu.psu.se411.lab11_threads.model.Transaction;

/**
 * Build and run using Maven goal:
 * clean package exec:java
 */
public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static Integer nbAccounts = 10;
    public static Double initialBalance = 1000.0;
    public static Integer nbTransactions = 10000;

    public static void main(String[] args) {

        logger.info("Application is starting...");

        // 1 - Create accounts
        CryptoAccount[] accounts =
                new CryptoAccount[nbAccounts];

        for (int i = 0; i < nbAccounts; i++) {

            accounts[i] =
                    new CryptoAccount(
                            "acc_" + i,
                            initialBalance
                    );
        }

        // Create array for all threads
        Thread[] threads =
                new Thread[nbTransactions];


        // 2 - Create all transactions in separate threads
        for (int i = 0; i < nbTransactions; i++) {

            CryptoAccount sender =
                    accounts[
                            (int) (Math.random() * nbAccounts)
                    ];

            CryptoAccount receiver =
                    accounts[
                            (int) (Math.random() * nbAccounts)
                    ];

            double amount =
                    Math.random() * 10 + 1;

            Transaction transaction =
                    new Transaction(
                            "Trx_" + i,
                            sender,
                            receiver,
                            amount
                    );

            threads[i] =
                    new Thread(transaction);

            threads[i].start();
        }


        // 3 - Wait for all threads to finish
        for (int i = 0; i < threads.length; i++) {

            try {

                threads[i].join();

            } catch (InterruptedException e) {

                logger.error(
                        "Thread interrupted",
                        e
                );
            }
        }


        // 4 - Verify total balance
        double totalBalance =
                getTotalBalance(accounts);

        System.out.println(
                "Expected balance: "
                + (nbAccounts * initialBalance)
        );

        System.out.println(
                "Actual balance: "
                + totalBalance
        );


        // Display every account
        for (CryptoAccount account : accounts) {

            System.out.println(
                    account.getId()
                    + " = "
                    + account.getBalance()
            );
        }


        logger.info("Application is closing...");
    }


    public static double getTotalBalance(
            CryptoAccount[] accounts) {

        double total = 0;

        for (CryptoAccount account : accounts) {

            total += account.getBalance();
        }

        return total;
    }
}