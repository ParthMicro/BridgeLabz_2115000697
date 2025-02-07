class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
    public void displayInterestRate() {
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
    public void displayWithdrawalLimit() {
        System.out.println("Withdrawal Limit: " + withdrawalLimit + " per day");
    }
}
class FixedDepositAccount extends BankAccount {
    private int tenure;
    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
    public void displayTenure() {
        System.out.println("Tenure: " + tenure + " years");
    }
}
public class BankAccountMain {
    public static void main(String[] args) {
        SavingsAccount savingsAcc = new SavingsAccount("101", 5000, 3.5);
        CheckingAccount checkingAcc = new CheckingAccount("102", 3000, 1000);
        FixedDepositAccount fdAcc = new FixedDepositAccount("103", 10000, 5);
        System.out.println("Savings Account:");
        savingsAcc.displayAccountInfo();
        savingsAcc.displayAccountType();
        savingsAcc.displayInterestRate();
        System.out.println("Checking Account:");
        checkingAcc.displayAccountInfo();
        checkingAcc.displayAccountType();
        checkingAcc.displayWithdrawalLimit();
        System.out.println("Fixed Deposit Account:");
        fdAcc.displayAccountInfo();
        fdAcc.displayAccountType();
        fdAcc.displayTenure();
    }
}
