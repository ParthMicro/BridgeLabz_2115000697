import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public abstract double calculateInterest();

    public String getAccountDetails() {
        return "Account: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance;
    }
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; 
    }

    @Override
    public boolean applyForLoan(double amount) {
        return balance > 5000; 
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 2; 
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02; 
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAVINGS123", "Parth", 10000));
        accounts.add(new CurrentAccount("CURRENT123", "Shanya", 5000));

        for (BankAccount acc : accounts) {
            System.out.println(acc.getAccountDetails());
            System.out.println("Interest: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                Loanable loanable = (Loanable) acc;
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
            }
            System.out.println(" ");
        }
    }
}
