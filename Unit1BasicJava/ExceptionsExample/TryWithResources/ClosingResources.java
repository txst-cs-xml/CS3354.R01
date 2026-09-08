import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClosingResources
{
   public static void main(String[] args) throws FileNotFoundException
   {
      // Use sample input so the example does not need an existing input file.
      // "zero" deliberately causes NumberFormatException in process().
      Scanner in = new Scanner("17\n29\nzero\n42\n");
      File outFile = new File("output.txt");
      PrintWriter out = new PrintWriter(outFile);

      // Java 9+: existing effectively final variables can be resources.
      try (in; out)
      {
         while (in.hasNextLine())
         {
            String result = process(in.nextLine());
            out.println(result);
         }
      } // Java closes out first, then in, even when process() throws.
      catch (NumberFormatException exception)
      {
         // Both resources have already been closed before this catch runs.
         System.out.println("Caught NumberFormatException: " + exception.getMessage());
      }

      // Verify that the Scanner is closed by attempting to read again.
      try
      {
         in.hasNextLine();
      }
      catch (IllegalStateException exception)
      {
         System.out.println("Scanner is closed: " + exception.getMessage());
      }

      // PrintWriter records write errors instead of throwing IOException.
      // Writing after close sets its error flag and adds nothing to the file.
      out.println("This line will not be written.");
      System.out.println("Write to closed PrintWriter failed: " + out.checkError());
      System.out.println("output.txt contains only 18 and 30; 42 was never processed.");
   }

   public static String process(String line)
   {
      int value = Integer.parseInt(line);
      value++;
      return "" + value;
   }
}
