class CustomException extends Exception {
    // Constructor that accepts a custom message
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (CustomException e) {
            System.err.println("CustomException caught: " + e.getMessage());
        }
    }

    public static int divide(int numerator, int denominator) throws CustomException {
        if (denominator == 0) {
            throw new CustomException("Division by zero is not allowed.");
        }
        return numerator / denominator;
    }
}
