interface BankAccountInterface {
    // Define a method for depositing money into the account
    void deposit(double amount);

    // Define an overloaded deposit method to accept multiple amounts
    void deposit(double[] amounts);

    // Define a method for withdrawing money from the account
    void withdraw(double amount);

    // Define a method to check the current balance
    double checkBalance();

    // Define a method to get the account holder name
    String getAccountHolder();

    // Define a method to set the account holder name with validation
    void setAccountHolder(String accountHolder);
}

public class Main {
    public static void main(String[] args) {
        // Step 1: Create instances of different account types
        BankAccount savings = new SavingsAccount("Alice", 1000);
        BankAccount checking = new CheckingAccount("Bob", 500);
        BankAccount business = new BusinessAccount("Charlie", 10000);

        // Step 2: Test deposit and withdraw methods
        savings.deposit(500);
        savings.withdraw(300);
        System.out.println("Savings Account Balance: " + savings.checkBalance());

        // Step 3: Test method overloading with multiple deposits
        double[] deposits = {100, 200, 150};
        savings.deposit(deposits);
        System.out.println("Savings Account Balance after multiple deposits: " + savings.checkBalance());

        // Step 4: Test withdrawal exception handling (uncomment to see exception thrown)
        savings.withdraw(5000);  // Should throw an exception due to insufficient funds

        // Step 5: Test polymorphism by calling calculateInterest on different accounts
        System.out.println("Savings Account Interest: " + savings.calculateInterest());
        System.out.println("Checking Account Interest: " + checking.calculateInterest());
        System.out.println("Business Account Interest: " + business.calculateInterest());
    }
}

