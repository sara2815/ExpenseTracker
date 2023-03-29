package ui;

import model.Account;
import model.Category;
import model.Transaction;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.ArrayList;

//creates a Frame that allows us to filter transactions by Type.

public class FilteredHistoryGraphics extends JInternalFrame implements ActionListener {
    JList earningsHistory = new JList();
    JList expensesHistory = new JList();
    JPanel viewHistoryPanel = new JPanel();
    Account currentAcc = new Account("dummy", 0);
    JPanel options = new JPanel();
    JButton close = new JButton("Close");
    // New: the five panels
    JPanel hedPanel = new JPanel();
    JButton expensesButton = new JButton("Expenses");
    JButton earningsButton = new JButton("Earnings");

    //EFFECTS: Sets up the Panel
    //MODIFIES: this
    public FilteredHistoryGraphics(Account acc) {
        this.currentAcc = acc;
        expensesButton.setVisible(true);
        earningsButton.setVisible(true);
        close.setVisible(true);
        expensesButton.setBackground(Color.white);
        earningsButton.setBackground(Color.white);
        options.add(expensesButton);
        options.add(earningsButton);
        close.setBackground(Color.white);
        options.add(close);
        viewHistoryPanel.add(options);
        setBackground(Color.decode("#C29540"));
        setBorder(new LineBorder(Color.decode("#C29540"), 10));
        hedPanel.setVisible(true);
        this.add(viewHistoryPanel);
        this.setLocation(300, 300);
        this.pack();
        setUpVisuals();
        //adds new transaction to the account
    }

    //EFFECTS: Sets up the visual appearance of the Panel. Adds all the components
    //MODIFIES: this and current account

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void setUpVisuals() {
        viewPastEarnings();
        viewPastExpenses();
        viewHistoryPanel.add(earningsHistory);
        viewHistoryPanel.add(expensesHistory);
        earningsHistory.setVisible(true);
        expensesHistory.setVisible(false);
        viewHistoryPanel.setVisible(true);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        earningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                earningsHistory.setVisible(true);
                expensesHistory.setVisible(false);
                setTitle("Past Earnings");
            }
        });
        expensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expensesHistory.setVisible(true);
                earningsHistory.setVisible(false);
                setTitle("Past Expenses");
            }
        });
    }

    //EFFECTS: Creates new Scrollable JList that has the past Earning History and puts it on panel.
    //MODIFIES:this
    public void viewPastEarnings() {
        ArrayList<String> oldEarningsNames = new ArrayList<String>();
        for (Transaction t : currentAcc.getEarningsHistory()) {
            oldEarningsNames.add(" Name:          "
                    + t.getTitle()
                    + "\t          Amount : $"
                    + t.getAmount()
                    + "\t          Date: " + t.getDate());
        }
        String[] oldEarnings = new String[oldEarningsNames.size()];
        oldEarningsNames.toArray(oldEarnings);
        this.earningsHistory = new JList(oldEarnings);
        this.earningsHistory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.earningsHistory.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.earningsHistory.setVisibleRowCount(-1);
        Font font = new Font("Verdana", Font.BOLD, 13);
        this.earningsHistory.setFont(font);
        this.earningsHistory.setForeground(Color.WHITE);
        this.earningsHistory.setBackground(Color.decode("#C29540"));
        viewHistoryPanel.setBackground(Color.decode("#C29540"));
        JScrollPane earningListScroller = new JScrollPane(this.earningsHistory);
        viewHistoryPanel.add(earningListScroller);
    }

    //EFFECTS: Creates a Scrollable JList of all past Expenses and places it on panel
    //MODIFIES: this
    public void viewPastExpenses() {
        ArrayList<String> oldExpenseNames = new ArrayList<String>();
        for (Transaction t : currentAcc.getExpensesHistory()) {
            String operator = "-";
            if (t.getTransactionType() == Category.EARNING) {
                operator = "";
            }
            oldExpenseNames.add(" Name:          " + t.getTitle() + "          Amount : $" + operator
                    + t.getAmount() + "\t          Date: " + t.getDate());
        }
        String[] oldExpenses = new String[oldExpenseNames.size()];
        oldExpenseNames.toArray(oldExpenses);
        this.expensesHistory = new JList(oldExpenses);
        this.expensesHistory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.expensesHistory.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.expensesHistory.setVisibleRowCount(-1);
        Font font = new Font("Verdana", Font.BOLD, 13);
        this.expensesHistory.setFont(font);
        this.expensesHistory.setForeground(Color.WHITE);
        this.expensesHistory.setBackground(Color.decode("#C29540"));
        viewHistoryPanel.setBackground(Color.decode("#C29540"));
        JScrollPane expenseListScroller = new JScrollPane(this.expensesHistory);
        viewHistoryPanel.add(expenseListScroller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // must override but performs no special actions in this case.

    }
}