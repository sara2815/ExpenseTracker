package ui;

import model.Account;
import model.Category;
import model.Transaction;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class FinancialTracker {
    private Scanner input;
    private Scanner inputName;
    private Account acc;


    //EFFECTS: run the financial tracker application
    public FinancialTracker() {
        runFinancialTracker();
    }


    // MODIFIES: this
    // EFFECTS: Processes user input
    private void runFinancialTracker() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye! Thank you for visiting our FinancialTracker!");

    }


    //MODIFIES: this
    //EFFECTS: processes user commands
    private void processCommand(String command) {
        if (command.equals("transaction")) {
            makeTransaction();
        } else if (command.equals("balance")) {
            getAccountBalance();
        } else if (command.equals("expenses")) {
            getAccountExpensesBalance();
        } else if (command.equals("earnings")) {
            getAccountEarningsBalance();
        } else if (command.equals("history")) {
            getAccountTransactionHistory();
        } else {
            System.out.println("User input typo or selection type is not valid.");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void initialize() {
        acc = new Account(inputName, 0);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void displayMenu() {
        System.out.println("\nHi! Welcome to our Financial Tracker!");
        System.out.println("\nSelect from the following command options:");
        System.out.println("\ttransaction");
        System.out.println("\tbalance");
        System.out.println("\texpenses");
        System.out.println("\tearnings");
        System.out.println("\thistory");
        System.out.println("\tquit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void makeTransaction() {
        Account selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        if (amount >= 0.0) {
            Transaction t = new Transaction();
            selected.it(amount);
        } else {
            System.out.println("Cannot deposit negative amount...\n");
        }

        printBalance(selected);
    }


    }


}
