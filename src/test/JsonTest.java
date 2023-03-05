import model.Category;

import model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkAccount(String name, int balance , Account acc) {
        assertEquals(name, acc.getName());
        assertEquals(balance, acc.getBalance());
    }
}
