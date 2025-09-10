import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        final double INITIAL_BALANCE = 1000;
        simulateBankAccount(INITIAL_BALANCE);
    }

    public static void simulateBankAccount(double initialBalance) {
        double balance = initialBalance;
        boolean done = false;
        Scanner in = new Scanner(System.in);

        while (!done) {
            System.out.println("Balance: " + balance);
            System.out.println("D)eposit amount W)ithdraw amount Q)uit");
            String command = in.next().substring(0, 1).toUpperCase();

            try {
                if (command.equals("D")) {
                    System.out.print("Enter deposit amount: ");
                    double amount = in.nextDouble();
                    balance += amount;
                } else if (command.equals("W")) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = in.nextDouble();
                    if (amount > balance) {
                        throw new IllegalArgumentException("Amount exceeds balance");
                    }
                    balance -= amount;
                } else if (command.equals("Q")) {
                    done = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                // Optionally, prompt for a new action here
            }
        }

        in.close();
    }
}
