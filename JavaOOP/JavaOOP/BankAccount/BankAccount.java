public class BankAccount {
    
    private double checkingBalance;
    private double savingsBalance;

    private static int numberAccounts = 0;
    // this.numberAccounts = 0;
    private static double totalMoney = 0;
    // totalMoney = 0;

    public BankAccount() {
        numberAccounts++;

    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void setCheckingBalance(double value) {
        checkingBalance = value;
    }
    
    public void setSavingsBalance(double value) {
        savingsBalance = value;
    }

    

    public void depositChecking(double value) {
        this.setCheckingBalance(this.getCheckingBalance() + value);
        totalMoney += value;
    }

    public void depositSavings(double value) {
        this.setSavingsBalance(this.getSavingsBalance() + value);
        totalMoney += value;
    }

    public double withdrawChecking(double value) {
        if (this.getCheckingBalance() > value) {
            this.setCheckingBalance(this.getCheckingBalance() - value);
            totalMoney -= value;
            return this.getCheckingBalance();
        }
        else {
            System.out.println("Insufficient funds");
            return this.getCheckingBalance();
        }
    }

    public double withdrawSavings(double value) {
        if (this.getSavingsBalance() > value) {
            this.setSavingsBalance(this.getSavingsBalance() - value);
            totalMoney -= value;
            return this.getSavingsBalance();
        }
        else {
            System.out.println("Insufficient funds");
            return this.getSavingsBalance();
        }
    }

    public double getTotal() {
        return this.getCheckingBalance() + this.getSavingsBalance();
    }

    public static int getNumberOfAccounts() {
        return numberAccounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }
}