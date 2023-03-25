package ui;

import model.Account;
import model.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


public class HistoryGraphics extends JInternalFrame implements ActionListener {
    JLabel heading = new JLabel("Past Transactions");
    JList history = new JList();
    JPanel viewHistoryPanel = new JPanel();
    Account currentAcc = new Account("dummy", 0);

    // New: the five panels

    JPanel hedPanel = new JPanel();

    public void makeHistoryPanel(Account acc) {
        this.currentAcc = acc;
        setTitle("All Past Transactions");
        setUpVisuals();
        //adds new transaction to the account
    }

    private void setUpVisuals() {
        setLayout(new FlowLayout());   // set layout manager for the JFrame
        hedPanel.add(heading);
        viewHistoryPanel.add(history);
        hedPanel.setVisible(true);
        viewHistoryPanel.setVisible(true);
        this.add(hedPanel);
        this.add(viewHistoryPanel);
        this.setLocation(400, 100);
        this.pack();
        viewPastTransactions();
    }

    public JList viewPastTransactions() {
        ArrayList<String> oldTransactionNames = new ArrayList<String>();
        for (Transaction t : currentAcc.getTransactionHistory()) {
            oldTransactionNames.add(t.getTitle());
        }
        String[] oldTransactions = new String[oldTransactionNames.size()];
        oldTransactionNames.toArray(oldTransactions);
        history = new JList(oldTransactions);

        history.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        history.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        history.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(history);
        viewHistoryPanel.add(listScroller);

        return history;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //

    }
}
