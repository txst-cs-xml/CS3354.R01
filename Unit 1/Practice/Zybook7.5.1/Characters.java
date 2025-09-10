import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Characters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Input file: ");
      String inputFileName = console.next();
      File inputFile = new File(inputFileName);
      Scanner in = new Scanner(inputFile);
      in.useDelimiter("");
      int uppercase = 0;
      int lowercase = 0;
      int digits = 0;
      int whitespace = 0;
      int other = 0;

      while (/* Your code goes here */)
      {
         /* Your code goes here */
         if (/* Your code goes here */) { uppercase++; }
         else if (/* Your code goes here */) { lowercase++; }
         else if (/* Your code goes here */) { digits++; }
         else if (/* Your code goes here */) { whitespace++; }
         else other++;
      }

      /* Your code goes here */

      // while (in.hasNext())
      // {
      //    char ch = in.next().charAt(0);
      //    if (Character.isUpperCase(ch)) { uppercase++; }
      //    else if (Character.isLowerCase(ch)) { lowercase++; }
      //    else if (Character.isDigit(ch)) { digits++; }
      //    else if (Character.isWhitespace(ch)) { whitespace++; }
      //    else { other++; }
      // }
      
      // in.close();
      
      System.out.println("Uppercase: " + uppercase);
      System.out.println("Lowercase: " + lowercase);
      System.out.println("Digits: " + digits);
      System.out.println("Whitespace: " + whitespace);
      System.out.println("Other: " + other);
   }
}