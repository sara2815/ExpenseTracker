import model.Category;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import model.Transaction;
import model.Account;
import model.UserCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/FINANCIALTRACKER.json");
        try {
            UserCollection uc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyUserCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyUserCollection.json");
        try {
            UserCollection uc = reader.read();
            assertEquals(0, uc.numAccounts());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralUserCollection() {
        JsonReader reader = new JsonReader("./data/TestReaderGeneralUserCollection.json");
        try {
            UserCollection uc = reader.read();
            List<Account> accounts = uc.getAllUsers();
            assertEquals(1, accounts.size());
            checkAccount("adyesha", 20, 20, 0, uc.getAllUsers().get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}