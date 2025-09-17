import java.util.Scanner;

public class MyBankAccount {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int option = 0;
        BankAccount myAccount = new BankAccount(1000);
        System.out.println("Welcome to Doge Bank");
        System.out.println("Your account currently has $" + myAccount.getBalance() + "balance.");
        System.out.println("1) Deposit 2)Withdraw 3) Quit");
        System.out.println("Please enter your choice");
        option = in.nextInt();

    }
}
