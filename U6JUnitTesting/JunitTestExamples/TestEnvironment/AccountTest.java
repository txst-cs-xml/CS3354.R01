import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    public static Account account = null;
    
    @BeforeAll
    public static void createEnvironMent() {
        account = new Account();
        System.out.println("Set Up Environment");
    }
    
    @AfterAll
    public static void clearEnvironMent() {
        account = null;
        System.out.println("Cleared Environment");
    }
    @Test
    public void testTransact1() {
        assertTrue(account.transact(5).getBalanceAmount() == 5);
    }

    @Test
    //@Disabled("This test is under development and should be ignored for now.")
    public void testTransact2() {
        assertFalse(account.transact(5).getBalanceAmount() == 5);
    }

    @Test
    public void testTransact3() {
        assertTrue(account.transact(5).getBalanceAmount() == 15);
    }

}

