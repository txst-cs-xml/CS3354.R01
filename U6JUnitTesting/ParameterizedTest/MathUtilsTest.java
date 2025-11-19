import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10}) // Test with these inputs
    void testIsEven(int number) {
        // Assert that the number is even
        assertTrue(MathUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, false",
        "4, true",
        "5, false"
    })
    void testIsEvenWithExpectedOutput(int number, boolean expected) {
        // Assert that the actual result matches the expected result
        assertEquals(expected, MathUtils.isEven(number));
    }

}
