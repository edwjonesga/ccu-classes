public class BankAccount implements BankAccountInterface {
    // Step 1: Declare private instance variables
    private String accountHolder;
    private double balance;

    // Step 2: Create a constructor to initialize accountHolder and balance
    public BankAccount(String accountHolder, double initialBalance) {
        // Initialize instance variables here
        // Make sure to set accountHolder and balance to initial values
    }

    // Step 3: Implement the deposit method
    // Students should:
    // - Add the given amount to the balance
    // - Ensure non-negative amounts are accepted
    // public void deposit(double amount) {}

    // Step 4: Overload the deposit method to take an array of amounts
    // Students should:
    // - Iterate over the array and add each amount to the balance
    // - Validate that each amount is non-negative
    // public void deposit(double[] amounts) {}

    // Step 5: Implement the withdraw method
    // Students should:
    // - Subtract the amount from the balance if sufficient funds are available
    // - Throw an IllegalArgumentException if the balance is insufficient
    // public void withdraw(double amount) {}

    // Helper method for students to use when handling exceptions
    private void validateSufficientFunds(double amount) {
        // Throw an exception if there are insufficient funds
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
    }

    // Step 6: Implement the checkBalance method
    // Students should:
    // - Return the current balance of the account
    // public double checkBalance() {}

    // Step 7: Implement the getAccountHolder method
    // Students should:
    // - Return the current account holder's name
    // public String getAccountHolder() {}

    // Step 8: Implement the setAccountHolder method with validation
    // Students should:
    // - Validate that the name is not null or empty
    // - Set the accountHolder field
    // public void setAccountHolder(String accountHolder) {}
}
