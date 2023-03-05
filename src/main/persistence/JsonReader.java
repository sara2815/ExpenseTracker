package persistence;

import model.UserCollection;
import model.Category;
import model.Account;
import model.Transaction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads account from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads account from file and returns it;
    // throws IOException if an error occurs reading data from file
    public UserCollection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAllUser(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses account from JSON object and returns it
    private UserCollection parseAllUser(JSONObject jsonObject) {
        UserCollection au = new UserCollection();
        addAccounts(au, jsonObject);
        return au;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addAccounts(UserCollection au, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("allUsers");
        for (Object json : jsonArray) {
            JSONObject nextAccount = (JSONObject) json;
            addAccount(au, nextAccount);
        }
    }

    private void addAccount(UserCollection au, JSONObject nextAccount) {
        String userName = nextAccount.getString("userName");
        double balance = nextAccount.getDouble("balance");
        double totalEarnings = nextAccount.getDouble("totalEarnings");
        double totalExpense = nextAccount.getDouble("totalExpense");
        Account a = new Account(userName, balance, totalEarnings, totalExpense);
        addTransactions(a, nextAccount.getJSONArray("transactionHistory"));
        au.addUser(a);
    }

    // MODIFIES: account
    // EFFECTS: parses transactions from the JSON object and adds them to the account
    private void addTransactions(Account a, JSONArray jsonArray) {
        for (Object json : jsonArray) {
            JSONObject nextTransaction = (JSONObject) json;
            addTransaction(a, nextTransaction);
        }
    }

    // MODIFIES: account
    // EFFECTS: parses transaction from JSON object and adds it to the account
    private void addTransaction(Account a, JSONObject jsonObject) {
        String name = jsonObject.getString("title");
        int date = jsonObject.getInt("date");
        double amount = jsonObject.getDouble("amount");
        String description = jsonObject.getString("description");
        Category category = Category.valueOf(jsonObject.getString("transactionType"));
        Transaction t =
                new Transaction(name, date, amount, description, category);
        a.addTransaction(t);
    }
}

