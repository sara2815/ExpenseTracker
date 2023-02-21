package ui;

import model.Account;
import model.Category;
import model.Transaction;

import java.util.Scanner;

public class FinancialTracker {
    private Scanner input;
    private Scanner input2;
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
        String newCommand = null;

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
            processNameCommand(command);
            displaySecondMenu();
            newCommand = input.next();
            newCommand = newCommand.toLowerCase();
            if (newCommand.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(newCommand);
            }
        }
        System.out.println("\nGoodbye! Thank you for visiting our FinancialTracker!");

    }


    //MODIFIES: this
    //EFFECTS: initializes  and processes name input to make new account.
    private void processNameCommand(String command) {
        String dummyAccountName = command;
        acc = new Account(command, 0);
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String newCommand) {
        if (newCommand.equals("transaction")) {
            makeTransaction();
        } else if (newCommand.equals("balance")) {
            viewBalance();
        } else if (newCommand.equals("history")) {
            doHistory();
        } else {
            System.out.println("User typo made or keyword doesn't match. Please try again!");
        }
    }

    private void doHistory() {
        if (acc.getTransactionHistory() == null) {
            System.out.println("You have no past transactions.");
        } else {
            System.out.println("Here are all the transactions you have made in the past:");
            acc.getTransactionHistory();
            System.out.println("If you want to view only your expense history enter A. If you want to view"
                    + "only your earnings history, enter B. If you want to return to the Main Menu, enter C.");
            String whichHistory = input.nextLine();
            if (whichHistory.equals("A")) {
                acc.getExpensesHistory();
            } else if (whichHistory.equals("B")) {
                acc.getEarningsHistory();
            } else if (whichHistory.equals("C")) {
                displaySecondMenu();
            } else {
                System.out.println("Selection does not match with options. Please try again!");
            }

        }
    }

    private void viewBalance() {
        System.out.println("Your current balance is $" + acc.getBalance());
    }


    private void displayMenu() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        System.out.println("\nHi! Welcome to our Financial Tracker!");
        System.out.println("\nPlease enter your name to view your Financial Tracker.");
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
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void makeTransaction() {
        System.out.println("Please enter a name for this transaction.");
        double prevBalance = acc.getBalance();
        String title = insertWords();
        int month = 0;
        String desc = "";
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        Category category = selectCategory();
        System.out.println("Please enter the month the transaction was made in as a number. Ie January -> 1, "
                + "February -> 2 etc.");
        month = input.nextInt();
        System.out.println("Please enter a description of your transaction. If you do not want to, enter -> no");
        desc = insertWords();
        if (amount < 0.0) {
            System.out.println("Cannot deposit negative amount...\n");
        } else {
            Transaction t = new Transaction(title, month, amount, desc, category);
            acc.addTransaction(t);
            System.out.println("\nYour previous balance was: $"
                    + prevBalance + "\t Your current balance, after making transaction is: $" + acc.getBalance());

        }
    }

    private Category selectCategory() {
        String category = "";
        while (category.equals("")) {
            System.out.print("If this is an expense, enter A. If it is an earning enter B.");
            category = input.next();
            category = category.toLowerCase();
        }
        if (category.equals("A")) {
            return Category.EXPENSE;
        } else if (category.equals("B")) {
            return Category.EARNING;
        } else {
            System.out.println("Selection did not match options. Choosing default option of expense.");
            return Category.EXPENSE;
        }
    }

    private String insertWords() {
        String title = "";

        while (title.equals("")) {
            title = input.next();
            title = title.toLowerCase();
        }
        if (title.equals("no")) {
            return "untitled";
        } else {
            return title;
        }
    }
}


