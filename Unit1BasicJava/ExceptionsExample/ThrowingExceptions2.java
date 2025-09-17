import java.util.Scanner;

/**
   A program to demonstrate throwing an exception.
*/
public class ThrowingExceptions2
{
   public static void main(String[] args)
   {
      final double INITIAL_BALANCE = 1000;
      simulateBankAccount(INITIAL_BALANCE);
   }

   public static void simulateBankAccount(double initialBalance)
   {
      double balance = initialBalance;
      boolean done = false;
      Scanner in = new Scanner(System.in);
      while (!done)
      {
         System.out.println("Balance: " + balance);
         System.out.println("D)eposit amount W)ithdraw amount Q)uit");
         String command = in.next().substring(0, 1).toUpperCase();
         if (command.equals("D"))
         {
            double amount = in.nextDouble();
            balance = balance + amount;
         }
         else if (command.equals("W"))
         {
            double amount = 0;
            boolean validInput = false;
            while (!validInput) {
               try {
                  System.out.print("Enter amount to withdraw: ");
                  amount = in.nextDouble();
                  if (amount > balance) {
                     throw new IllegalArgumentException("Amount exceeds balance");   // unchecked exception
                  }
                  validInput = true;
               } catch (IllegalArgumentException e) {
                  System.out.println("Error: " + e.getMessage());
               } catch (Exception e) {
                  System.out.println("Invalid input. Please enter a valid amount.");
                  in.next(); // clear the invalid input
               }
            }
            balance = balance - amount;
         }
         else if (command.equals("Q"))
         {
            done = true;
         }
      }
   }
}
