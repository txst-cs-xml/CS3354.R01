/** 
   There are two files that you can try:

   test1.txt
   ---------
   17
   29
   zero
   42

   test2.txt
   ---------
   17
   29
   0
   42
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class CatchingExceptions
{
   public static void main(String[] args)
   {
      try
      {
         String filename = "test1.txt";
         Scanner in = new Scanner(new File(filename));
         int sum = 0;
         while (in.hasNext())
         {
            String input = in.next();
            int value = Integer.parseInt(input);
            sum = sum + value;
         }
         System.out.println("Sum: " + sum);
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
         // exception.getMessage();

      }
      catch (NumberFormatException exception)
      {
         System.out.println("NumberFormatException: " + exception.getMessage());
      }
   }
}