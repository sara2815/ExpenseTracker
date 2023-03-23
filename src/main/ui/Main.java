package ui;
//Main. Runs the financial tracker.

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            //new FinancialTracker();
            new FinancialTracker();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
