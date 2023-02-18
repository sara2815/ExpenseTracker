package ui;

import model.Account;
import model.Transaction;

public class FinancialTracker {
    public static final String NEW = "new";
    public static final String CHECK_BALANCE = "balance";
    public static final String HISTORY = "past history";

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to your financial tracker");
        System.out.println("How can I help you today?");
        System.out.println("Enter" + NEW + "to add a new transaction");
        System.out.println("Enter" + NEW + "to add a new transaction");
        System.out.println("Enter" + CHECK_BALANCE + "to check your current balance");
        System.out.println("Enter" + HISTORY + "to view your transaction history so far.");

        }
    }
