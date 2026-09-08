/**
   Demonstrates try-catch-finally with successful division and division by zero.
*/
public class TryCatchFinally
{
   public static void main(String[] args)
   {
      divide(10, 2);
      System.out.println();
      divide(10, 0);
   }

   public static void divide(int numerator, int denominator)
   {
      try
      {
         // Put code that might throw an exception in the try block.
         System.out.println("Trying to divide " + numerator + " by " + denominator);
         int result = numerator / denominator;
         System.out.println("Result: " + result);
      }
      catch (ArithmeticException exception)
      {
         // Runs only if the try block throws an ArithmeticException.
         System.out.println("Caught ArithmeticException: Cannot divide by zero.");
      }
      finally
      {
         // Runs in both examples, whether division succeeds or an exception occurs.
         // A finally block is often used to clean up resources.
         System.out.println("Finally: Division attempt finished.");
      }

      // Execution continues here after the exception has been handled.
      System.out.println("Program continues after try-catch-finally.");
   }
}
