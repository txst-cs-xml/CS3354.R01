import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.time.Duration;

public class HelloWorldTest {

    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
        char[] actual = "Jupiter".toCharArray();
    
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void whenAssertingConditions_thenVerified() {
        assertTrue(5 > 4, "5 is greater the 4");
        assertTrue(null == null, "null is equal to null");
    }

    @Test
    public void testGetTheSameObject() {
        HelloWorld tester1 = new HelloWorld();
        HelloWorld tester2 = new HelloWorld();
        assertSame(tester1, tester1);
        assertNotSame(tester1, tester2);
    }

    @Test
    public void whenAssertingNotNull_thenTrue() {
        HelloWorld tester = new HelloWorld();
    
        assertNotNull(tester, "The tester should not be null");
    }

    @Test
    public void whenAssertingNull_thenTrue() {
        HelloWorld tester = null;
    
        assertNull(tester, "The tester should be null");
    }

    @Test
    public void whenFailingATest_thenFailed() {
        // Test not completed
        fail("FAIL - test not completed");
    }

    @Test
    public void givenMultipleAssertion_whenAssertingAll_thenOK() {
        HelloWorld tester1 = new HelloWorld();
        HelloWorld tester2 = new HelloWorld();
        assertAll(
        "heading",
        () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
        () -> assertEquals("java", "JAVA".toLowerCase()),
        () -> assertEquals(tester1, tester1, "null is equal to null")
        );
    }

    @Test
    public void givenTwoLists_whenAssertingIterables_thenEquals() {
        Iterable<String> al = new ArrayList<>(Arrays.asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(Arrays.asList("Java", "Junit", "Test"));
    
        assertIterableEquals(al, ll);
    }

    @Test
    public void whenAssertingEquality_thenNotEqual() {
        Integer value = 5; // result of an algorithm
         
        assertNotEquals(0, value, "The result cannot be 0");
    }
    
    @Test
    void testExpectedException() {
      assertThrows(NumberFormatException.class, () -> {
        Integer.parseInt("One");
      });
    }
    
    @Test
    public void whenAssertingTimeout_thenNotExceeded() {
        assertTimeout(
        Duration.ofSeconds(2), 
        () -> {
            // code that requires less then 2 seconds to execute
            Thread.sleep(1000);
        }
        );
    }


}
