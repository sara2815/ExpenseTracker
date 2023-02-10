package model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Account {

    //fields
    private String userName;
    private int balance;
    private LinkedList<Transaction> transactionHistory;


    //constructor
//EFFECTS: Constructs a new account with a userName of "No Name", a balance of 0 and an empty transaction history.
    public Account() {
        this.userName = "No Name";
        this.balance = 0;
        transactionHistory = new LinkedList<Transaction>();

    }
}
