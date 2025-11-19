import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {
    @Test
    public void testMultiply1() {
        // MyClass is tested
        MyClass tester = new MyClass();
        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
    
    }

    @Test
    public void testMultiply2() {
        // MyClass is tested
        MyClass tester = new MyClass();
        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
    
    }

    @Test
    public void testMultiply3() {
        // MyClass is tested
        MyClass tester = new MyClass();
        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    
    }
}
