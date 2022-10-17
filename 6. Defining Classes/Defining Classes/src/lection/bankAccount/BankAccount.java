package lection.bankAccount;

public class BankAccount {
    private final int id;
    private double balance;

    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
