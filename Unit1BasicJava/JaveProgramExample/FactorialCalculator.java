/**
 * This class provides a method to calculate the factorial of a given integer.
 */
public class FactorialCalculator {

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n The non-negative integer for which the factorial is to be calculated.
     * @return The factorial of the input integer.
     */
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    /**
     * The main entry point of the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Input number for which factorial will be calculated
        int number = 5;

        // Calculate factorial
        long factorial = calculateFactorial(number);

        // Display the result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
