import java.util.Scanner;

public class ShoppingCartManager {
   public static void printMenu() {
      System.out.println("MENU");
      System.out.println("a - Add item to cart");
      System.out.println("d - Remove item from cart");
      System.out.println("c - Change item quantity");
      System.out.println("i - Output items' descriptions");
      System.out.println("o - Output shopping cart");
      System.out.println( "q - Quit");
      System.out.println("");
   }

   public static void executeMenu(char option, ShoppingCart theCart, Scanner scnr) {
      String productName;
      String productDescription;
      int productPrice = 0;
      int productQuantity = 0;
      
      switch (option) {
         case 'a':
            scnr.nextLine();
            System.out.println("ADD ITEM TO CART");
            System.out.println("Enter the item name:");
            productName = scnr.nextLine();

            System.out.println("Enter the item description:");
            productDescription = scnr.nextLine();

            System.out.println("Enter the item price:");
            productPrice= scnr.nextInt();

            System.out.println("Enter the item quantity:");
            productQuantity = scnr.nextInt();

            ItemToPurchase newItem = new ItemToPurchase(productName, productDescription, productPrice, productQuantity);
            theCart.addItem(newItem);

            System.out.println("");
            break;

         case 'd':
            scnr.nextLine();

            System.out.println("REMOVE ITEM FROM CART");
            System.out.println("Enter name of item to remove:");
            productName = scnr.nextLine();

            theCart.removeItem(productName);
            System.out.println("");
            break;

         case 'c':
            scnr.nextLine();

            System.out.println("CHANGE ITEM QUANTITY");
            System.out.println("Enter the item name:");
            productName = scnr.nextLine();

            System.out.println("Enter the new quantity:");
            productQuantity = scnr.nextInt();

            ItemToPurchase modItem = new ItemToPurchase();
            modItem.setName(productName);
            modItem.setQuantity(productQuantity);

            theCart.modifyItem(modItem);      
            System.out.println("");
            break;

         case 'i':
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            theCart.printDescriptions();
            System.out.println("");
            break;

         case 'o':
            System.out.println("OUTPUT SHOPPING CART");
            theCart.printTotal();
            System.out.println("");
            break;
      }
      
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String customerName;
      String todaysDate;
      char menuChoice = ' ';

      System.out.println("Enter customer's name:");
      customerName = scnr.nextLine();

      System.out.println("Enter today's date:");
      todaysDate = scnr.nextLine();

      System.out.println("\nCustomer name: " + customerName);
      System.out.println("Today's date: " + todaysDate);
      System.out.println("");

      ShoppingCart myCart = new ShoppingCart(customerName, todaysDate);

      printMenu();

      while(menuChoice != 'q') {
         System.out.println("Choose an option:");
         menuChoice = scnr.next().charAt(0);
         if (menuChoice == 'a' || menuChoice == 'd' || menuChoice == 'c' ||
                menuChoice == 'i' || menuChoice == 'o') {
            executeMenu(menuChoice, myCart, scnr);
            printMenu();
         }
      }
   }
}