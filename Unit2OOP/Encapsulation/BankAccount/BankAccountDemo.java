public class BankAccountDemo {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount account1 = new BankAccount(1000);
        
        // Display the initial balance
        System.out.println("Initial balance: $" + account1.getBalance());

        // Deposit $500 into the account
        account1.deposit(500);
        System.out.println("Balance after deposit of $500: $" + account1.getBalance());

        // Withdraw $200 from the account
        account1.withdraw(200);
        System.out.println("Balance after withdrawal of $200: $" + account1.getBalance());

        // Attempt to withdraw $2000, which should incur a penalty
        account1.withdraw(2000);
        System.out.println("Balance after attempting to withdraw $2000: $" + account1.getBalance());

        // Add 5% interest to the account
        account1.addInterest(5);
        System.out.println("Balance after adding 5% interest: $" + account1.getBalance());

        // Create another bank account with a zero balance
        BankAccount account2 = new BankAccount();
        
        // Display the initial balance
        System.out.println("\nInitial balance of account2: $" + account2.getBalance());

        // Deposit $1000 into the second account
        account2.deposit(1000);
        System.out.println("Balance of account2 after deposit of $1000: $" + account2.getBalance());
    }
}
