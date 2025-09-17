import java.util.ArrayList;
import java.util.Scanner;

/**
   A menu that is displayed on a console.
*/
public class Menu
{
   private ArrayList<String> options;
   private Scanner in;

   /**
      Constructs a menu with no options.
   */
   public Menu()
   {
      options = new ArrayList<String>();
      in = new Scanner(System.in);
   }

   /**
      Adds an option to the end of this menu.
      @param option the option to add
   */
   public void addOption(String option)
   {
      options.add(option);
   }
   
   /**
      Displays the menu, with options numbered starting with 1,
      and prompts the user for input. Repeats until a valid input 
      is supplied.
      @return the number that the user supplied
   */
   public int getInput()
   {
      int input;
      do
      {
         for (int i = 0; i < options.size(); i++)
         {
            int choice = i + 1;
            System.out.println(choice + ") " + options.get(i)); 
         }
         input = in.nextInt();
      }
      while (input < 1 || input > options.size());
      return input;
   }
}


