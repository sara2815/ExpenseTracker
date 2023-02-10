package model;

import java.time.LocalDate;

public class Expenses extends Transaction {
    //fields
    private int totalExpenses;


    //REQUIRES: a non-zero amount
    //MODIFIES: balance and totalEarnings
    //EFFECTS: Increases balance and totalEarnings by amount.
    public void makePurchases(int amount) {
        totalExpenses = totalExpenses + amount;
    }

}
