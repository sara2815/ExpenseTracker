
import model.Category;
import model.UserCollection;
import model.Account;
import model.Transaction;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            UserCollection uc = new UserCollection();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyUserCollection() {
        try {
            UserCollection uc = new UserCollection();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyUserCollection.json");
            writer.open();
            writer.write(uc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyUserCollection.json");
            uc = reader.read();
            assertEquals(0, uc.numAccounts());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralUserCollection() {
        try {
            UserCollection uc = new UserCollection();
            uc.addUser(new Account( "adyesha", 20, 20, 0));
            uc.getAllUsers().get(1).addTransaction
                    (new Transaction("clothes", 1, 20, "untitled", Category.EARNING));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(uc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            uc = reader.read();
            LinkedList<Account> accounts = uc.getAllUsers();
            assertEquals(1, accounts.size());
            checkAccount("adyesha", 20, 20, 0, uc.getAllUsers().get(0));
            checkTransaction("clothes", 1, 20, "untitled", Category.EARNING,
                    uc.getAllUsers().get(0).getTransactionHistory().get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}