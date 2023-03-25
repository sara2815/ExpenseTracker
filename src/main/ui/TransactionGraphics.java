package ui;

import model.Account;
import model.Category;
import model.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class TransactionGraphics extends JInternalFrame implements ActionListener {
    JLabel heading = new JLabel("New Transaction");
    JLabel titleLabel = new JLabel("Enter transaction name:   ");
    JLabel amountLabel = new JLabel("Enter total amount: $ ");
    JLabel dateLabel = new JLabel("Enter the month of transaction as a number: ");
    JLabel descriptionLabel = new JLabel("Enter a description of your transaction");
    JLabel transactionTypeLabel = new JLabel("Choose whether this transaction is an expense or earning : ");
    JPanel transactionTypePanel = new JPanel();
    JPanel createPanel = new JPanel();
    JTextField makeTitle = new JTextField(7);
    JTextField makeAmount = new JTextField(7);
    JTextField makeDate = new JTextField(7);
    JTextField makeDescription = new JTextField(20);
    JRadioButton r1 = new JRadioButton("Expense");
    JRadioButton r2 = new JRadioButton("Earning");
    Account currentAccount = new Account("dummy", 0);
    JButton doit = new JButton("Create!");
    JButton close = new JButton("Close");

    // New: the five panels

    JPanel hedPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel amountPanel = new JPanel();
    JPanel datePanel = new JPanel();
    JPanel descriptionPanel = new JPanel();

    public void makeTransactionPanel(Account acc) {
        this.currentAccount = acc;
        //makes transaction Panel
        setTitle("Create a new transaction");
        setUpAppearance();
        //adds new transaction to the account

    }

    private void createTransaction() {
        System.out.println("IT WORKS");
        String title = makeTitle.getText();
        String description = makeDescription.getText();
        double amount = Integer.parseInt(makeAmount.getText());
        int date = Integer.parseInt(makeDate.getText());
        Category newTransactionType = Category.EARNING;
        if ((r1.isSelected())) {
            newTransactionType = Category.EXPENSE;
        }
        Transaction t = new Transaction(title, date, amount, description, newTransactionType);
        currentAccount.addTransaction(t);
    }

    //EFFECTS: sets up the visuals.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void setUpAppearance() {
        setLayout(new FlowLayout());   // set layout manager for the JFrame
        close.setBackground(Color.red);
        makeTitle.setEditable(true);
        makeAmount.setEditable(true);
        makeDate.setEditable(true);
        makeDescription.setEditable(true);
        hedPanel.add(heading);
        titlePanel.add(titleLabel);
        titlePanel.add(makeTitle);
        amountPanel.add(amountLabel);
        amountPanel.add(makeAmount);
        datePanel.add(dateLabel);
        datePanel.add(makeDate);
        makeTransactionType(transactionTypeLabel, r1, r2);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(makeDescription);
        createPanel.add(doit);
        createPanel.add(close);
        hedPanel.setVisible(true);
        titlePanel.setVisible(true);
        amountPanel.setVisible(true);
        datePanel.setVisible(true);
        createPanel.setVisible(true);
        descriptionPanel.setVisible(true);
        addEverything(hedPanel, titlePanel, amountPanel, datePanel, descriptionPanel, transactionTypePanel);
        doit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTransaction();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    //EFFECTS: makes the transaction panel with editable fields for the user.
    private void makeTransactionType(JLabel transactionTypeLabel, JRadioButton r1, JRadioButton r2) {
        transactionTypePanel.add(transactionTypeLabel);
        transactionTypePanel.add(r1);
        transactionTypePanel.add(r2);
        transactionTypePanel.setVisible(true);
    }

    //EFFECTS: Adds all the individual panels to the frame to make a new Transaction builder form
    private void addEverything(JPanel hedPanel, JPanel titlePanel, JPanel amountPanel,
                               JPanel datePanel, JPanel descriptionPanel, JPanel transactionTypePanel) {
        this.add(hedPanel);
        this.add(titlePanel);
        this.add(amountPanel);
        this.add(datePanel);
        this.add(descriptionPanel);
        this.add(transactionTypePanel);
        this.add(createPanel);
        this.setLocation(400, 300);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
