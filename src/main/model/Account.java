package model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Account {

    //fields
    private String userName;
    private int balance;
    private int totalEarnings;
    private int totalExpense;
    private LinkedList<Transaction> transactionHistory;
    private LinkedList<Transaction> earningsHistory;
    private LinkedList<Transaction> expensesHistory;


    //constructor
//EFFECTS: Constructs a new account with a userName of "No Name", a balance of 0 and an empty transaction history.
    public Account() {
        this.userName = "No Name";
        this.balance = 0;
        transactionHistory = new LinkedList<Transaction>();
    }

    //REQUIRES: nothing
    //MODIFIES: transactionHistory, balance and either totalEarnings or totalExpense.
    //EFFECTS: adds transaction to the start of the transactionHistory list. If the transaction is an Expense,
    // it subtracts the amount from balance and adds amount to totalExpenses. If transaction is Earnings, it adds the
    // amount to balance and to totalEarnings.
    public void addTransaction(Transaction t) {
        transactionHistory.addFirst(t);
        if (t.getTransactionType() == Category.EXPENSE) {
            expensesHistory.addFirst(t);
            balance = balance - t.getAmount();
            totalExpense = totalExpense + t.getAmount();
        } else {
            earningsHistory.addFirst(t);
            balance = balance + t.getAmount();
            totalEarnings = totalEarnings + t.getAmount();
        }
    }
}
