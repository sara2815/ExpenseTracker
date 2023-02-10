package model;

import java.time.LocalDate;

public class Transaction {
    //fields
    public String title;
    public LocalDate date;
    public int amount;
    public String category;

    //constructor
    // REQUIRES: amount > 0
    // EFFECTS: creates earning  with a generic title, date, amount as 0, and category type.
    public Transaction() {
        this.title = "Give it a name";
        this.date = LocalDate.of(2023, 1, 1);
        this.amount = 0;
        this.category = "General";
    }

    public int getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }
}