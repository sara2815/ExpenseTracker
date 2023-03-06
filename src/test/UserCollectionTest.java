import model.Account;
import model.Transaction;

import model.Category;
import model.UserCollection;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCollectionTest {

    Account a1;
    Account a2;
    Account a3;
    Account a4;
    UserCollection au1;
    Transaction t1;
    Transaction t2;


    @BeforeEach
    void runBefore() {
        au1 = new UserCollection();
        a1 = new Account("Aarushi", 0);
        a2 = new Account("Adyesha", 0, 0, 0);
        a3 = new Account("Sandeep", 200);
        a4 = new Account("Tamanna", 300, 20, 280);
        t1 = new Transaction("tuition", 1, 200, "Expensive", Category.EXPENSE);
        t2 = new Transaction("job", 2, 800, "Expensive", Category.EARNING);

    }

    @Test
// TODO:TestNoAccounts in UserCollection
    public void TestAddNoUsers() {
        assertEquals(au1.getAllUsers().size(), 0);
    }

    @Test
// TODO:TestAddAccounts to UserCollection.
    public void TestAddMultipleUsers() {
        assertEquals(au1.numAccounts(), 0);
        //add accounts to UserCollection
        au1.addUser(a1);
        au1.addUser(a2);
        au1.addUser(a3);
        //check if it has been added correctly
        assertEquals(au1.getAllUsers().size(), 3);
        assertEquals(au1.getAllUsers().get(0), a1);

    }

    @Test
// TODO:TestRemoveUser from UserCollection
    public void TestRemoveUser() {
        assertEquals(au1.getAllUsers().size(), 0);
        //add accounts to UserCollection
        au1.addUser(a1);
        au1.addUser(a2);
        au1.addUser(a3);
        //check if it has been added correctly
        assertEquals(au1.getAllUsers().size(), 3);
        assertEquals(au1.getAllUsers().get(0), a1);
        //remove a1 from allUsers
        au1.removeUser(a1);
        //check that it has been removed
        assertEquals(au1.getAllUsers().size(), 2);
        assertEquals(au1.getAllUsers().get(0), a2);
        //remove a2 from allUsers
        au1.removeUser(a2);
        assertEquals(au1.getAllUsers().size(), 1);

    }
}
