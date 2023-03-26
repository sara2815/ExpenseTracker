package ui;

import model.Account;
import model.Category;
import model.Transaction;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


public class HistoryGraphics extends JInternalFrame implements ActionListener {
    JList history = new JList();
    JList earningHistory = new JList();
    JPanel viewHistoryPanel = new JPanel();
    Account currentAcc = new Account("dummy", 0);
    String command;

    // New: the five panels

    JPanel hedPanel = new JPanel();

    public void makeHistoryPanel(Account acc, String heading) {
        this.currentAcc = acc;
        this.command = heading;
        setTitle(heading);
        setUpVisuals();
        //adds new transaction to the account
    }

    private void setUpVisuals() {
        setLayout(new FlowLayout());   // set layout manager for the JFrame
        setBackground(Color.decode("#C29540"));
        setBorder(new LineBorder(Color.decode("#C29540"), 10));
        viewHistoryPanel.setVisible(true);
        history.setVisible(true);
        viewHistoryPanel.add(history);
        hedPanel.setVisible(true);
        viewHistoryPanel.setVisible(true);
        this.add(viewHistoryPanel);
        this.setLocation(400, 100);
        this.pack();
        if (command.equals("Past Earnings")) {
            viewPastEarnings();
        } else if (command.equals("All Past Transactions")) {
            viewPastTransactions();
        }
    }

    private JList viewPastEarnings() {
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
        earningHistory = new JList(oldEarnings);
        earningHistory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        earningHistory.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        earningHistory.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(history);
        viewHistoryPanel.add(listScroller);
        return earningHistory;
    }

    public JList viewPastTransactions() {
        ArrayList<String> oldTransactionNames = new ArrayList<String>();
        for (Transaction t : currentAcc.getTransactionHistory()) {
            String operator = "-";
            if (t.getTransactionType() == Category.EARNING) {
                operator = "";
            }
            oldTransactionNames.add(" Name:          " + t.getTitle() + "          Amount : $" + operator
                    + t.getAmount()  + "\t          Date: " + t.getDate());
        }
        String[] oldTransactions = new String[oldTransactionNames.size()];
        oldTransactionNames.toArray(oldTransactions);
        history = new JList(oldTransactions);
        history.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        history.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        history.setVisibleRowCount(-1);
        history.setBackground(Color.decode("#C29540"));
        Font font = new Font("Verdana", Font.BOLD, 12);
        history.setFont(font);
        history.setForeground(Color.WHITE);
        history.setBackground(Color.decode("#C29540"));
        history.setBorder(new LineBorder(Color.decode("#C29540"), 10));
        viewHistoryPanel.setBackground(Color.decode("#C29540"));
        viewHistoryPanel.setBorder(new LineBorder(Color.decode("#C29540"), 10));
        JScrollPane listScroller = new JScrollPane(history);
        viewHistoryPanel.add(listScroller);
        return history;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //

    }
}
