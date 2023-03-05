package model;

import java.util.LinkedList;

import model.Account;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents all users that have used the financial tracker.
public class UserCollection implements Writable {
    //fields
    private LinkedList<Account> allUsers;


    //constructor
//EFFECTS: Constructs a new list of all users.
    public UserCollection() {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("allUsers", accountsToJson());
        return json;
    }


    // EFFECTS: returns accounts in this allUser as a JSON array
    public JSONArray accountsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Account a : allUsers) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }

    public LinkedList<Account> getAllUsers() {
        return allUsers;
    }
}