/**
   This program demonstrates the measurable BankAccount and Country classes.
*/
public class MeasurableDemo
{
   public static void main(String[] args)
   {
      Measurable[] accounts = new Measurable[3];
      accounts[0] = new BankAccount(0);
      accounts[1] = new BankAccount(10000);
      accounts[2] = new BankAccount(2000);

      // double value = accounts[0].getMeasure();
      // accounts[0].withdraw(2000);

      // BankAccount account = (BankAccount) accounts[0];
      // account.deposit(500);

      System.out.println("Average balance: " 
         + average(accounts));

      Measurable[] countries = new Measurable[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 514000);
      countries[2] = new Country("Belgium", 30510);

      System.out.println("Average area: " 
         + average(countries));

      
      Measurable[] array = new Measurable[3];
      array[0] = new BankAccount(18.5);
      array[1] = new Student(20.5);
      array[2] = new Country("Belgium", 30510);

      System.out.println("Average age: " 
         + average(array));
   }

   /**
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the average of the measures
   */
   public static double average(Measurable[] objects)
   {
      if (objects.length == 0) { return 0; }
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      return sum / objects.length;
   }
}