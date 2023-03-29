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

//sets up appearance and functions of the panel that brings up all past transactions added

public class HistoryGraphics extends JInternalFrame implements ActionListener {
    JList history = new JList();
    JList filteredHistory = new JList();
    JPanel viewHistoryPanel = new JPanel();
    Account currentAcc = new Account("dummy", 0);
    String command;
    JButton close = new JButton("Close");
    // New: the five panels
    JPanel hedPanel = new JPanel();

    //EFFECTS: Sets up the Panel
    //MODIFIES: this
    public HistoryGraphics(Account acc, String heading) {
        this.currentAcc = acc;
        this.command = heading;
        setTitle(heading);
        setUpVisuals();
        //adds new transaction to the account
    }

    //EFFECTS: Sets up the visual appearance of the Panel. Adds all the components
    //MODIFIES: this
    public void setUpVisuals() {
        setBackground(Color.decode("#C29540"));
        setBorder(new LineBorder(Color.decode("#C29540"), 10));
        history.setVisible(true);
        viewHistoryPanel.setLayout(new BoxLayout(viewHistoryPanel, BoxLayout.PAGE_AXIS));
        viewHistoryPanel.add(history);
        hedPanel.setVisible(true);
        close.setBackground(Color.white);
        viewHistoryPanel.add(close);
        viewHistoryPanel.setVisible(true);
        this.add(viewHistoryPanel);
        this.setLocation(400, 100);
        this.pack();
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        viewPastTransactions();
    }


    //EFFECTS: Creates a Scrollable JList of all past Transactions and places it on panel
    //MODIFIES: this
    public void viewPastTransactions() {
        ArrayList<String> oldTransactionNames = new ArrayList<String>();
        for (Transaction t : currentAcc.getTransactionHistory()) {
            String operator = "-";
            if (t.getTransactionType() == Category.EARNING) {
                operator = "";
            }
            oldTransactionNames.add(" Name:          " + t.getTitle() + "          Amount : $" + operator
                    + t.getAmount() + "\t          Date: " + t.getDate());
        }
        String[] oldTransactions = new String[oldTransactionNames.size()];
        oldTransactionNames.toArray(oldTransactions);
        history = new JList(oldTransactions);
        history.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        history.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        history.setVisibleRowCount(-1);
        Font font = new Font("Verdana", Font.BOLD, 13);
        history.setFont(font);
        history.setForeground(Color.WHITE);
        history.setBackground(Color.decode("#C29540"));
        viewHistoryPanel.setBackground(Color.decode("#C29540"));
        JScrollPane listScroller = new JScrollPane(history);
        viewHistoryPanel.add(listScroller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // must override but performs no special actions.

    }
}
