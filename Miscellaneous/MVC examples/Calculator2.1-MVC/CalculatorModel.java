// The Model: Handles calculations
public class CalculatorModel {
    private double lastValue;
    private String lastOperator;
    private boolean startNewValue;

    public CalculatorModel() {
        reset();
    }

    public void reset() {
        lastValue = 0;
        lastOperator = "=";
        startNewValue = true;
    }

    public double calculate(double value1, double value2, String operator) {
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                if (value2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return value1 / value2;
            case "=":
                return value2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    // Getters and Setters
    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }

    public String getLastOperator() {
        return lastOperator;
    }

    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    public boolean isStartNewValue() {
        return startNewValue;
    }

    public void setStartNewValue(boolean startNewValue) {
        this.startNewValue = startNewValue;
    }
}
