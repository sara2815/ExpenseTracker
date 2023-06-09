package model;

import org.json.JSONObject;
import persistence.Writable;

//Represents a singular transaction, be it expense or earning. Contains information about amount, date, type,
//description and a title.
public class Transaction implements Writable {
    //fields
    private String title;
    private int date;
    private double amount;
    private Category transactionType;
    private String description;

    //constructor
    // REQUIRES: amount > 0
    // EFFECTS: creates earning  with a generic title, date, amount as 0, and category type.
    public Transaction(String name, int date, double amount, String description, Category type) {
        this.title = name;
        this.date = date;
        this.amount = amount;
        this.transactionType = type;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Enum<Category> getTransactionType() {
        return transactionType;
    }

    public int getDate() {
        return date;
    }

    public void setAmount(double x) {
        this.amount = x;
    }

    public void setTitle(String transactionName) {
        this.title = transactionName;
    }

    public void setTransactionType(Enum type) {
        this.transactionType = (Category) type;
    }

    public void setDate(int transactionMonth) {
        this.date = transactionMonth;
    }

    @Override
    public JSONObject toJson() {

        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("date", date);
        json.put("amount", amount);
        json.put("transactionType", transactionType);
        json.put("date", date);
        json.put("description", description);
        return json;
    }
}