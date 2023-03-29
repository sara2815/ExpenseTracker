package ui;

import model.Account;
import model.Category;
import model.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

//sets up appearance and functions of the panel that allows user to add new transactions
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
    JLabel balanceTextField;

    // New: the five panels

    JPanel hedPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel amountPanel = new JPanel();
    JPanel datePanel = new JPanel();
    JPanel descriptionPanel = new JPanel();

    //EFFECTS: constructor
    public  TransactionGraphics(JLabel balance) {
        super();
        balanceTextField = balance;

    }

    //EFFECTS: Creates the transaction panel and sets up appearance and visuals.
    public void makeTransactionPanel(Account acc) {
        this.currentAccount = acc;
        setTitle("Create a new transaction");
        setLayout(new FlowLayout());   // set layout manager for the JFrame
        close.setBackground(Color.white);
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
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(makeDescription);
        setUpAppearance();
    }

    //EFFECTS: Creates new transaction.
    //MODIFIES: this as well as the user's account.
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
        balanceTextField.setText("Current Balance: $" + currentAccount.getBalance());

    }

    //EFFECTS: sets up the visual appearance of the various components on the panel.
    public void setUpAppearance() {
        makeTransactionType(transactionTypeLabel, r1, r2);
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
                setVisible(false);
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
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
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
        // must override but doesn't do anything
    }
}
