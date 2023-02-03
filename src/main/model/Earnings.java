package model;

public class Earnings {
    //fields
    private String title;
    private char date;
    private int amount;
    private String category;

    //constructor
    // REQUIRES: amount > 0
    // EFFECTS: creates earning  with a generic title, date, amount as 0, and category type.
    public Earnings() {
        this.title = "Give it a name";
        this.date = 000000;
        this.amount = 0;
        this.category = "General";
    }

}
