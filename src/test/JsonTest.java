import model.Category;

import model.Account;
import model.Transaction;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkAccount(String name, double balance, double totalEarnings, double totalExpense, Account acc) {
        assertEquals(name, acc.getName());
        assertEquals(balance, acc.getBalance());
        assertEquals(totalEarnings, acc.getTotalEarnings() );
        assertEquals(totalExpense, acc.getTotalExpense());

    }
}