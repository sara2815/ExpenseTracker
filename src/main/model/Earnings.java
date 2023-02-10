package model;

import java.time.LocalDate;

public class Earnings extends Transaction {
    //fields
    private int totalEarnings;


    //REQUIRES: a non-zero amount
    //MODIFIES: balance and totalEarnings
    //EFFECTS: Increases balance and totalEarnings by amount.
    public void depositEarnings(int amount) {
        totalEarnings = totalEarnings + amount;
    }

}
