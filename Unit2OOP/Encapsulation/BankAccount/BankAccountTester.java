/**
   This program tests the BankAccount class.
*/
public class BankAccountTester
{
   /**
      Tests the methods of the BankAccount class.
      @param args not used
   */
   public static void main(String[] args)
   {
      BankAccount harrysAccount = new BankAccount(1000);
      harrysAccount.deposit(500); // Balance is now $1500
      harrysAccount.withdraw(2000); // Balance is now $1490
      harrysAccount.addInterest(1); // Balance is now $1490 + 14.90
      System.out.printf("%.2f%n", harrysAccount.getBalance());
      System.out.println("Expected: 1504.90");

      
   }
}
