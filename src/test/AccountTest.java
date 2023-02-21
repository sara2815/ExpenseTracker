
import model.Account;
import model.Category;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    Account a1;
    Transaction t1;
    Transaction t2;
    Transaction t3;
    Transaction t4;


    @BeforeEach
    void runBefore() {
        a1 = new Account("Aarushi", 0);
        t1 = new Transaction("tuition", 1, 200, "Expensive", Category.EXPENSE);
        t2 = new Transaction("job", 2, 800, "Expensive", Category.EARNING);
        t3 = new Transaction("friends", 3, 200, "Owed Money to Lisa",
                Category.EXPENSE);
        t4 = new Transaction("biryani", 4, 400, "bought takeout",
                Category.EXPENSE);
    }

    @Test
// TODO:TestAddTransactionEmptyExpense adds transaction of Expense type to empty list
    //TODO: Outcome transaction history has one item, expensesHistory has one item, totalExpenses is increased by
    // transaction amount and balance is now reduced by amount (should be negative).
    public void TestAddTransactionEmptyExpense() {
        //check transactions type
        assertEquals(t1.getTransactionType(), Category.EXPENSE);
        //check that list is empty
        assertEquals(a1.getTransactionHistory().size(), 0);
        //add transaction
        a1.addTransaction(t1);
        //check transactionHistory
        assertEquals(a1.getTransactionHistory().size(), 1);
        //check expensesHistory
        assertEquals(a1.getExpensesHistory().size(), 1);
        //check balance
        assertEquals(a1.getBalance(), 0.0 - t1.getAmount());
        //check totalExpense
        assertEquals(a1.getTotalExpense(), t1.getAmount());
        //check totalEarnings, should be 0
        assertEquals(a1.getTotalEarnings(), 0.0);

    }

    @Test
    // TODO:TestAddTransactionEmptyEarnings adds transaction of Earning type to empty list
    //TODO: Outcome transaction history has one item, earningsHistory has one item, totalEarnings is increased by
    // transaction amount and balance is now increased by amount.
    public void TestAddTransactionEmptyEarnings() {
        //check transactions type
        assertEquals(t2.getTransactionType(), Category.EARNING);
        //check that list is empty
        assertEquals(a1.getTransactionHistory().size(), 0);
        //add transaction
        a1.addTransaction(t2);
        //check transactionHistory
        assertEquals(a1.getTransactionHistory().size(), 1);
        //check expensesHistory should be 0
        assertEquals(a1.getExpensesHistory().size(), 0);
        //check earningsHistory it should have t2
        assertEquals(a1.getEarningsHistory().size(), 1);
        //check balance
        assertEquals(a1.getBalance(), t2.getAmount());
        //check totalEarnings
        assertEquals(a1.getTotalEarnings(), t2.getAmount());
        //check totalExpenses should be 0
        assertEquals(a1.getTotalExpense(), 0);

    }

    // TODO:TestAddTransactionExpenseMultiple adds transaction of Expense type to list with multiple existing transactions
    //TODO: of different types.
    //TODO: Outcome transaction history should add an additional item, balance should be decreased by Expense,
    //TODO: totalExpenses should be increased by the amount of transaction and transaction added to expenseHistory
    public void TestAddTransactionExpenseMultiple() {
        //add transactions
        a1.addTransaction(t2);
        a1.addTransaction(t3);
        a1.addTransaction(t4);
        //check transactions type
        assertEquals(t1.getTransactionType(), Category.EXPENSE);
        //check that list size
        int dummyVariable = a1.getTransactionHistory().size();
        //check balance
        double dummyBalance = a1.getBalance();
        double prevExpenseTotal = a1.getTotalExpense();
        double prevEarningTotal = a1.getTotalEarnings();
        //add transaction of expense type
        a1.addTransaction(t1);
        //check transactionHistory has added t1
        assertTrue(a1.getTransactionHistory().contains(t1));
        assertEquals(a1.getTransactionHistory(), dummyVariable + 1);
        //check expensesHistory
        assertTrue(a1.getExpensesHistory().contains(t1));
        //check balance
        assertEquals(a1.getBalance(), dummyBalance - t1.getAmount());
        //check totalExpense
        assertEquals(a1.getTotalExpense(), prevExpenseTotal + t1.getAmount());
        //check totalEarnings, should be unaffected
        assertEquals(a1.getTotalEarnings(), prevEarningTotal);

    }

    // TODO:TestAddTransactionEarningMultiple adds transaction of Earning type to list with multiple existing transactions
    //TODO: of different types.
    //TODO: Outcome transaction history should add an additional item, balance should be increase by Expense,
    //TODO: totalEarnings should be increased by the amount of transaction and transaction added to earningsHistory
    public void TestAddTransactionEarningMultiple() {
        //add transactions
        a1.addTransaction(t1);
        a1.addTransaction(t3);
        a1.addTransaction(t4);
        //check transactions type
        assertEquals(t2.getTransactionType(), Category.EARNING);
        //check that list size
        int dummyVariable = a1.getTransactionHistory().size();
        //check balance
        double dummyBalance = a1.getBalance();
        double prevExpenseTotal = a1.getTotalExpense();
        double prevEarningTotal = a1.getTotalEarnings();
        //add transaction of expense type
        a1.addTransaction(t2);
        //check transactionHistory has added t2
        assertTrue(a1.getTransactionHistory().contains(t2));
        assertEquals(a1.getTransactionHistory(), dummyVariable + 1);
        //check earningsHistory
        assertTrue(a1.getEarningsHistory().contains(t2));
        //check balance
        assertEquals(a1.getBalance(), dummyBalance + t2.getAmount());
        //check totalEarnings
        assertEquals(a1.getTotalEarnings(), prevEarningTotal + t2.getAmount());
        //check totalEarnings, should be unaffected
        assertEquals(a1.getTotalEarnings(), prevExpenseTotal);

    }
}
