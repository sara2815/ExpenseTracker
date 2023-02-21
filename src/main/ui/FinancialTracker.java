package ui;

import model.Account;
import model.Category;
import model.Transaction;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class FinancialTracker {
    private Scanner input;
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

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processNameCommand(command);
                displaySecondMenu();
                command = input.next();
                command = command.toLowerCase();
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye! Thank you for visiting our FinancialTracker!");

    }


    //MODIFIES: this
    //EFFECTS: initializes  and processes name input to make new account.
    private void processNameCommand(String command) {
        String dummyAccountName = command;
        acc = new Account(command, 0);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("transaction")) {
            makeTransaction();
        } else if (command.equals("balance")) {
            viewBalance();
        } else if (command.equals("history")) {
            doHistory();
        } else {
            System.out.println("User typo made or keyword doesn't match. Please try again!");
        }

    }

    private void doHistory() {
    }

    private void viewBalance() {
    }


    private void displayMenu() {
        System.out.println("\nHi! Welcome to our Financial Tracker!");
        System.out.println("\nPlease enter your name to view your Financial Tracker. Enter quit if you want to leave "
                + "Financial Tracker.");
    }


    private void displaySecondMenu() {
        System.out.println("\nHi! Please enter one of the following keywords:");
        System.out.println("\ttransaction -> To make a new transaction ");
        System.out.println("\tbalance -> To view your current balance");
        System.out.println("\thistory -> To view your past transaction history");
        System.out.println("\tquit -> To exit the Financial Tracker application.");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void makeTransaction() {
        System.out.println("Please enter a name or title for this transaction. "
                + "This will help you find particular transactions later");
        String title = input.nextLine();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        System.out.print("If this is an expense, enter A. If it is an earning enter B.");
        String category = input.nextLine();
        System.out.println("Please enter the month the transaction was made in as a number. Ie January -> 1, "
                + "February -> 2 etc.");
        int month = input.nextInt();
        System.out.println("Please enter a description of your transaction. If you do not want to, enter -> no");
        String desc = input.nextLine();
        if (amount < 0.0) {
            System.out.println("Cannot deposit negative amount...\n");
        }
        if (desc == "no") {
            desc = "no description";
        }
        if (category == "A") {
            Transaction transaction = new Transaction(title, month, amount, desc,
                    Category.EXPENSE);
        } else {
            Transaction transaction = new Transaction(title, month, amount, desc,
                    Category.EARNING);
        }
    }

}
