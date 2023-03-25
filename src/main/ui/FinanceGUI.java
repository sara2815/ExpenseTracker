package ui;

import model.Account;
import model.Category;
import model.Transaction;
import model.UserCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

//Runs GUI

public class FinanceGUI extends JFrame {
    private static final String JSON_STORE = "./data/FINANCIALTRACKER.json";
    private UserCollection allUser;
    private Account acc;
    private String name;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;


    public FinanceGUI() {
        desktop = new JDesktopPane();
        desktop.setBackground(Color.decode("#2B6D72"));
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
        showfirstPage();
        addButtonPanel();
        addMenu();
        addTransactionDisplayPanel();
        controlPanel.setBackground(Color.WHITE);
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        controlPanel.add(addButtonPanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);

    }

    private void showfirstPage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Image/FINANCIAL_TRACKER.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageDisplay frame = new ImageDisplay(image);
        frame.showImage(3);
    }

    private JPanel addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        transactionButton().setBackground(Color.WHITE);
        historyButton().setBackground(Color.WHITE);
        buttonPanel.add(transactionButton());
        buttonPanel.add(historyButton());
        buttonPanel.add(saveButton());


        return buttonPanel;
    }

    //EFFECTS: Creates a button that when clicked allows user to see all the past transactions they have made.
    private JButton saveButton() {
        //
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

        });
        return save;
    }

    private void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(allUser);
            jsonWriter.close();
            System.out.println("Saved " + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //EFFECTS: Creates a button that when clicked allows user to see all the past transactions they have made.
    private JButton historyButton() {
        //
        JButton history = new JButton("View Past Transactions");
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryGraphics historyGraphics = new HistoryGraphics();
                historyGraphics.makeHistoryPanel(acc);
                historyGraphics.setVisible(true);
                historyGraphics.setSize(500, 250);
                desktop.add(historyGraphics);
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