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

   There is no file fred.txt.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ThrowsExceptions
{  
   public static void main(String[] args)
   {
      try
      {
         int result = readData("frad.txt");
         System.out.println("result: " + result);
      }
      catch (IOException exception) 
      {
         exception.printStackTrace();
         System.out.println(exception.getMessage());
      }
   }

   public static int readData(String filename) throws FileNotFoundException
   {
      File inFile = new File(filename);
      Scanner in = new Scanner(inFile);
      int sum = 0;
      while (in.hasNextInt())
      {
         sum = sum + in.nextInt();
      }
      return sum;
   }
}