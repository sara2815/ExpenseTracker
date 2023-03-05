package ui;

import model.Account;
import model.AllUser;
import model.Category;
import model.Transaction;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

// Handles the user input based console system for the Financial tracker.

public class FinancialTracker {
    private static final String JSON_STORE = "./data/FINANCIALTRACKER.json";
    private Scanner input;
    private AllUser alluser;
    private Account acc;
    private String nameCommand;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    //EFFECTS: run the financial tracker application
    public FinancialTracker() throws FileNotFoundException {
        input = new Scanner(System.in);
        alluser = new AllUser();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runFinancialTracker();
    }


    // MODIFIES: this
    // EFFECTS: Processes user input
    private void runFinancialTracker() {
        boolean keepGoing = true;
        String command = null;
        String newCommand = null;
        displayMenu();
        nameCommand = input.next();
        processNameCommand(nameCommand);


        while (keepGoing) {
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
    //EFFECTS: processes name input to make new account and initializes balance as 0.
    private void processNameCommand(String command) {
        alluser = new AllUser();
        acc = new Account(command, 0);
        alluser.addAccount(acc);
    }


    // MODIFIES: this
    // EFFECTS: processes user commands on displaySecondMenu
    private void processCommand(String newCommand) {
        if (newCommand.equals("transaction")) {
            makeTransaction();
        } else if (newCommand.equals("balance")) {
            viewBalance();
        } else if (newCommand.equals("history")) {
            doHistory();
        } else if (newCommand.equals("save")) {
            saveAllUser();
        } else if (newCommand.equals("load")) {
            loadAllUser();
        } else {
            System.out.println("User typo made or keyword doesn't match. Please try again!");
        }
    }

    //EFFECTS: produces the past transaction history of the user. User can choose to view specifically
    // the earning or expense history as well if the transaction history is not empty.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void doHistory() {
        if (acc.getTransactionHistory().isEmpty()) {
            System.out.println("You have no past transactions.");
        } else {
            System.out.println("\t TRANSACTION HISTORY"
                    + "\n To view all past transactions --> A"
                    + "\n To only view your expense history -- > B."
                    + "\n To only view only your earnings history --> C"
                    + "\n To return to the Main Menu -->  D.");
            String whichHistory = input.next();
            input.nextLine();
            if (whichHistory.equals("A")) {
                viewTransactions(acc.getTransactionHistory());
            } else if (whichHistory.equals("B")) {
                if (acc.getExpensesHistory().isEmpty()) {
                    System.out.println("You have no past expenses.");
                } else {
                    viewTransactions(acc.getExpensesHistory());
                }
            } else if (whichHistory.equals("C")) {
                if (acc.getEarningsHistory().isEmpty()) {
                    System.out.println("You have no past earnings.");
                } else {
                    viewTransactions(acc.getEarningsHistory());
                }
            } else if (whichHistory.equals("D")) {
                displaySecondMenu();
            } else {
                System.out.println("Selection does not match with options. Please try again!");
            }
        }
    }

    //EFFECTS: produces each transaction to user. Basically allows user to see a transaction.
    private void viewTransactions(LinkedList<Transaction> transactions) {
        for (Transaction t : transactions) {
            String type = "";
            if (t.getTransactionType() == Category.EXPENSE) {
                type = "expense";
            } else {
                type = "earning";
            }
            System.out.println("\n Title:" + t.getTitle()
                    + "\n Amount:" + t.getAmount()
                    + "\n Month of Transaction: " + t.getDate()
                    + "\n Description:" + t.getDescription()
                    + "\n Type:" + type);
        }

    }

    // EFFECTS: displays the current balance of the account.
    private void viewBalance() {
        System.out.println("Your current balance is $" + acc.getBalance());
    }


    // EFFECTS: displays the menu to user prompting them to enter their name.
    private void displayMenu() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        System.out.println("\nHi! Welcome to our Financial Tracker!");
        System.out.println("\nPlease enter your name to view your Financial Tracker.");
    }

    // EFFECTS: displays the menu to user prompting them to choose which course of action to undertake
    //such as making a transaction, checking balance, viewing history or quiting.
    private void displaySecondMenu() {
        System.out.println("\nHi! Please enter one of the following keywords:");
        System.out.println("\ttransaction -> To make a new transaction ");
        System.out.println("\tbalance -> To view your current balance");
        System.out.println("\thistory -> To view your past transaction history");
        System.out.println("\tsave -> To save your recent changes");
        System.out.println("\tload -> To load your previous changes back.");
        System.out.println("\tquit -> To exit the Financial Tracker application.");
    }

    // MODIFIES: account
    // EFFECTS: conducts a deposit transaction, changing balance accordingly and adding transaction to account history.
    private void makeTransaction() {
        System.out.println("Please enter a name for this transaction.");
        double prevBalance = acc.getBalance();
        String title = insertWords();
        int month = 0;
        String desc = "";
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        Category category = selectCategory();
        System.out.println("\nPlease enter the month the transaction was made in as a number."
                + "\nIe January -> 1 , February -> 2 etc.");
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

    // EFFECTS: selects the category of transaction based on user input
    private Category selectCategory() {
        String category = "";
        while (category.equals("")) {
            System.out.print("If this is an expense, enter A. If it is an earning enter B.");
            category = input.next();
            category = category.toLowerCase();
        }
        if (category.equals("a")) {
            return Category.EXPENSE;
        } else if (category.equals("b")) {
            return Category.EARNING;
        } else {
            System.out.println("Selection did not match options. Choosing default option of expense.");
            return Category.EXPENSE;
        }
    }

    //REQUIRES: User must input some string in response.
    //EFFECTS: Used to input words or description based on user input.
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


    // EFFECTS: saves the account to file
    private void saveAllUser() {
        try {
            jsonWriter.open();
            jsonWriter.write(alluser);
            jsonWriter.close();
            System.out.println("Saved " + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads allUser from file
    private void loadAllUser() {
        try {
            alluser = jsonReader.read();
            System.out.println("Loaded " + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}