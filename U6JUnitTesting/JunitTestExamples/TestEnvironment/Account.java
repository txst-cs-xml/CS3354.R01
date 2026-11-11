public class Account {
    private int balanceAmount; // Encapsulate the balance field

    public Account() {
        balanceAmount = 0;
    }

    public Account transact(int amount) {
        if (amount > 0) { // Simple check to allow only positive transactions
            this.balanceAmount += amount;
        }
        return this;
    }

    public int getBalanceAmount() {
        return balanceAmount; // Provide a getter for the balance
    }
}
