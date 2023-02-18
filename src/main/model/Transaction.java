package model;

import java.time.LocalDate;

public class Transaction {
    //fields
    private String title;
    private LocalDate date;
    private int amount;
    private Category transactionType;
    private String description;

    //constructor
    // REQUIRES: amount > 0
    // EFFECTS: creates earning  with a generic title, date, amount as 0, and category type.
    public Transaction(String name, LocalDate date, int amount, String description, Category type) {
        this.title = name;
        this.date = date;
        this.amount = amount;
        this.transactionType = type;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public Enum<Category> getTransactionType() {
        return transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAmount(int x) {
        this.amount = x;
    }

    public void setTitle(String transactionName) {
        this.title = transactionName;
    }

    public void setTransactionType(Enum type) {
        this.transactionType = (Category) type;
    }

    public void setDate(LocalDate transactionDate) {
        this.date = transactionDate;
    }
}