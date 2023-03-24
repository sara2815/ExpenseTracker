package ui;

import model.Account;
import model.Category;
import model.Transaction;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;


public class HistoryGraphics extends JInternalFrame implements ActionListener {
    JLabel heading = new JLabel("Past Transactions");
    JList history = new JList();
    JPanel viewHistoryPanel = new JPanel();
    JButton viewHistoryButton = new JButton("View Past Transactions");
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
        viewHistoryPanel.add(viewHistoryButton);
        hedPanel.setVisible(true);
        viewHistoryPanel.setVisible(true);
        this.add(hedPanel);
        this.add(viewHistoryPanel);
        this.setLocation(400,  300);
        this.pack();
        viewHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPastTransactions();
            }
        });
    }

    public JList viewPastTransactions() {
        System.out.println("Should show transactions");
        return history;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //

    }
}
