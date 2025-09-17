public class BankAccount {
    // Instance variables
    private double balance;
    private int accountNumber;
    
    // Static variable to keep track of the last assigned account number
    private static int lastAssignedNumber = 1000;
    
    // Static variable to keep track of the total number of accounts
    private static int totalAccounts = 0;

    // Constructor that initializes balance and assigns an account number
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        lastAssignedNumber++;
        this.accountNumber = lastAssignedNumber;
        totalAccounts++;
    }

    // Instance method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Instance method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Instance method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Static method to get the total number of accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Static method to reset account numbering (e.g., for testing)
    // public static void resetAccountNumbering() {
    //     lastAssignedNumber = 1000;
    // }

    // Method to get the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        System.out.println("The number of bank accounts is:" + BankAccount.getTotalAccounts());
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(1000);
        BankAccount account3 = new BankAccount(1000);
        BankAccount account4 = new BankAccount(1000);
        System.out.println("The number of bank accounts is:" + BankAccount.getTotalAccounts());
        System.out.println("The number of bank accounts is:" + account1.getAccountNumber());
        System.out.println("The number of bank accounts is:" + account2.getAccountNumber());
        System.out.println("The number of bank accounts is:" + account3.getAccountNumber());
        System.out.println("The number of bank accounts is:" + account4.getAccountNumber());
    }
}
