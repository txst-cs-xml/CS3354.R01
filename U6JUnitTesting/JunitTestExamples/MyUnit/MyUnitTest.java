import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyUnitTest {
    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo", result);
    }
}