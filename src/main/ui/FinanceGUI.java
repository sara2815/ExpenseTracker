package ui;

import model.Account;
import model.Category;
import model.Transaction;
import model.UserCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Runs GUI

public class FinanceGUI extends JFrame {
    private static final String JSON_STORE = "./data/FINANCIALTRACKER.json";
    private UserCollection allUser;
    private Account acc;
    private String name;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private JDesktopPane desktop;
    private UserCollection user;
    private JInternalFrame controlPanel;


    public FinanceGUI() {
        desktop = new JDesktopPane();
        allUser = new UserCollection();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
        controlPanel.setLayout(new BorderLayout());

        controlPanel.setSize(300, 300);

        setContentPane(desktop);
        setTitle("Financial Tracker");
        setSize(WIDTH, HEIGHT);

        String loadAnswer = JOptionPane.showInputDialog(null,
                "Do you want to load your data? ",
                "WELCOME TO FINANCIAL TRACKER!",
                JOptionPane.QUESTION_MESSAGE);

        handleAnswer(loadAnswer);
    }

    public void handleAnswer(String answer) {
        String load = answer.toLowerCase();
        if (load.equals("yes")) {
            loadAllUser();
        }
        setUpAccount();
        displaySecondMenu();
    }

    private void displaySecondMenu() {
        addButtonPanel();
        addMenu();
        addTransactionDisplayPanel();

        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        controlPanel.add(addButtonPanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);

    }

    private JPanel addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(transactionButton());
        buttonPanel.add(historyButton());


        return buttonPanel;
    }
//EFFECTS: Creates a button that when clicked allows user to see all the past transactions they have made.
    private JButton historyButton() {
        //
        JButton history = new JButton("View Past Transactions");
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryGraphics historyGraphics = new HistoryGraphics();
                historyGraphics.viewPastTransactions(acc);
            }
        });

        return history;
    }

    //EFFECTS: creates a transaction button that allows the user to make a new transaction to add to their account.
    //MODIFIES: this, and the user's account.
    private JButton transactionButton() {
        JButton transaction = new JButton("New Transaction");
        transaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionGraphics newTransaction = new TransactionGraphics();
                newTransaction.makeTransactionPanel(acc);
                newTransaction.setVisible(true);
                newTransaction.setSize(500, 250);
                desktop.add(newTransaction);
            }
        }
        );
        return transaction;
    }

    private void centreOnScreen() {
    }

    private void addKeyPad() {
    }

    private void addMenu() {
    }

    private void addTransactionDisplayPanel() {
    }

    // MODIFIES: this
    // EFFECTS: loads allUser from file
    private void loadAllUser() {
        try {
            allUser = jsonReader.read();
            System.out.println("Loaded " + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: if account already exists in user, brings that up else creates new account.
    private void setUpAccount() {
        String command = JOptionPane.showInputDialog(null,
                "Please enter your name ",
                "WELCOME TO FINANCIAL TRACKER!",
                JOptionPane.QUESTION_MESSAGE);

        acc = new Account(command, 0);
        for (Account account : allUser.getAllUsers()) {
            if (account.getName().equals(command)) {
                acc = account;
            }
        }
        allUser.addUser(acc);
        name = acc.getName();
    }

    /**
     * Represents action to be taken when user wants to add a new code
     * to the system.
     */


    private class RemoveTransactionAction implements Icon, Action {
        @Override
        public Object getValue(String key) {
            return null;
        }

        @Override
        public void putValue(String key, Object value) {

        }

        @Override
        public void setEnabled(boolean b) {

        }

        @Override
        public boolean isEnabled() {
            return false;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {

        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {

        }

        @Override
        public int getIconWidth() {
            return 0;
        }

        @Override
        public int getIconHeight() {
            return 0;
        }
    }

}