package model;

import java.util.LinkedList;

import model.Account;
import org.json.JSONArray;

// Represents all users that have used the financial tracker.
public class AllUser {
    //fields
    private LinkedList<Account> allUsers;


    //constructor
//EFFECTS: Constructs a new list of all users.
    public AllUser() {
        allUsers = new LinkedList<Account>();
    }

    //MODIFIES: this
    //EFFECTS: adds Account to list of all Users.
    public void addUser(Account a) {
        allUsers.add(a);
    }

    //MODIFIES: this
    //EFFECTS: removes Account from list of all Users.
    public void removeUser(Account a) {
        allUsers.remove(a);
    }

    //EFFECTS: produces the Account that we are looking for


    // EFFECTS: returns accounts in this allUser as a JSON array
    public JSONArray accountsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Account a : allUsers) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }

    public void addAccount(Account a) {
        allUsers.add(a);
    }
}
