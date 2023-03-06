
import model.Transaction;
import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    Transaction t1;
    Transaction t2;
    Transaction t3;
    Transaction t4;

    @BeforeEach
    void runBefore() {
        t1 = new Transaction("tuition", 1, 200, "Expensive", Category.EXPENSE);
        t2 = new Transaction("job", 2, 800, "Expensive", Category.EARNING);
        t3 = new Transaction("friends", 3, 200, "Owed Money to Lisa",
                Category.EXPENSE);
        t4 = new Transaction("biryani", 4, 400, "bought takeout",
                Category.EXPENSE);
    }

    @Test
// TODO:TestGetTitle
    //TODO: Returns title.
    public void TestGetTitle() {
        //check title of transaction
        assertEquals(t1.getTitle(), "tuition");
    }

    @Test
// TODO:TestGetAmount
    //TODO: Returns amount of transaction.
    public void TestGetAmount() {
        //check amount of transaction
        assertEquals(t2.getAmount(), 800);
    }

    @Test
// TODO:TestGetTransactionType
    //TODO: Returns Transaction type - Category Enum.
    public void TestGetTransactionType() {
        //check transactions type
        assertEquals(t3.getTransactionType(), Category.EXPENSE);
        assertEquals(t2.getTransactionType(), Category.EARNING);
    }

    @Test
// TODO:TestGetDescription
    //TODO: Returns Transaction descirption
    public void TestGetDescription() {
        //check transactions type
        assertEquals(t3.getDescription(), "Owed Money to Lisa");
        assertEquals(t2.getDescription(), "Expensive");
    }

    @Test
// TODO:TestGetDate
    //TODO: Returns the month that transaction was made in
    public void TestGetDate() {
        //check the month the transaction was made in
        assertEquals(t1.getDate(), 1);
        assertEquals(t2.getDate(), 2);
    }

    @Test
// TODO:TestSetAmount
    //TODO: Sets amount of transaction to be as defined.
    public void TestSetAmount() {
        //check amount
        assertEquals(t3.getAmount(), 200);
        //set amount
        t3.setAmount(459);
        //check if amount has successfully been set.
        assertEquals(t3.getAmount(), 459);
    }

    @Test
// TODO:TestSetTitle
    //TODO: Sets title of transaction to be as defined.
    public void TestSetTitle() {
        //check title
        assertEquals(t3.getTitle(), "friends");
        //set title
        t3.setTitle("cry");
        //check if title has successfully been set.
        assertEquals(t3.getTitle(), "cry");
    }

    @Test
// TODO:TestSetTransactionType
    //TODO: Sets transaction type to be as defined.
    public void TestSetTransactionType() {
        //check transactionType
        assertEquals(t4.getTransactionType(), Category.EXPENSE);
        //sets transactionType
        t4.setTransactionType(Category.EARNING);
        //check if amount has successfully been set.
        assertEquals(t4.getTransactionType(), Category.EARNING);
    }
    @Test
// TODO:TestSetDate
    //TODO: Sets date month of transaction to be as defined.
    public void TestSetDate() {
        //check transaction month
        assertEquals(t2.getDate(), 2);
        //set transaction date
        t3.setDate(12);
        //check if amount has successfully been set.
        assertEquals(t3.getDate(), 12);
    }
}

