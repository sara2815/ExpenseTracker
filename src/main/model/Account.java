package model;

import java.util.LinkedList;

public class Account {

    //fields
    private String userName;
    private double balance;
    private double totalEarnings;
    private double totalExpense;
    private LinkedList<Transaction> transactionHistory;
    private LinkedList<Transaction> earningsHistory;
    private LinkedList<Transaction> expensesHistory;


    //constructor
//EFFECTS: Constructs a new account with a userName of "No Name", a balance of 0 and an empty transaction history.
    public Account(String name, int balance) {
        this.userName = name;
        this.balance = balance;
        expensesHistory = new LinkedList<Transaction>();
        earningsHistory = new LinkedList<Transaction>();
        transactionHistory = new LinkedList<Transaction>();
    }


    //REQUIRES: nothing
    //MODIFIES: transactionHistory, balance and either totalEarnings or totalExpense.
    //EFFECTS: adds transaction to the start of the transactionHistory list. If the transaction is an Expense,
    // it subtracts the amount from balance and adds amount to totalExpenses. If transaction is Earnings, it adds the
    // amount to balance and to totalEarnings.
    public void addTransaction(Transaction t) {
        transactionHistory.addFirst(t);
        if (t.getTransactionType() == Category.EARNING) {
            earningsHistory.addFirst(t);
            balance = balance + t.getAmount();
            totalEarnings = totalEarnings + t.getAmount();
        } else {
            expensesHistory.addFirst(t);
            balance = balance - t.getAmount();
            totalExpense = totalExpense + t.getAmount();
        }
    }

    //EFFECTS: returns the transaction history
    public LinkedList<Transaction> getTransactionHistory() {
        return transactionHistory;

    }

    //EFFECTS: returns the expenseHistory
    public LinkedList<Transaction> getExpensesHistory() {
        return expensesHistory;

    }

    public double getBalance() {
        return balance;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    //EFFECTS: returns the expenseHistory
    public LinkedList<Transaction> getEarningsHistory() {
        return earningsHistory;

    }
}
