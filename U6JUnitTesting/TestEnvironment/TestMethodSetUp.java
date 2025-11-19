import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestMethodSetUp {
    public static Account account = null;
    @BeforeEach
    public void createMethodEnvironMent() {
        account = new Account();
        System.out.println("Set Up Method Environment");
    }
    
    @AfterEach
    public void clearMethodEnvironMent(){
        account = null;
        System.out.println("Cleared Method Environment");
    }
    
    @Test
    public void transactBooleanTest() {
        assertTrue(account.transact(5).getBalanceAmount() == 5, "Test Failed Message");
    }
    
    @Test
    public void transactObjectTest() {
        Account accountOne = new Account();
        accountOne.transact(1000).transact(-1000);
        assertEquals(accountOne, accountOne, "Test Failed Message");
    }
}
