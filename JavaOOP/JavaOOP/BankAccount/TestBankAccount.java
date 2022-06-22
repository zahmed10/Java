// Test code adapted from instructor's GitHub course repo at https://github.com/jupiterorbita/JAVA_OCT_2021.git

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bA = new BankAccount();
		bA.depositChecking(200.45);
		double money = bA.getTotal();
		System.out.println(money);
		
		bA.depositSavings(150.45);
		bA.withdrawSavings(100.00);
		
		
		System.out.println("\n number of accoutns: " + BankAccount.getNumberOfAccounts());
	
		BankAccount x = new BankAccount();
		System.out.println("\n number of accoutns: " + BankAccount.getNumberOfAccounts());

		//Test total money in the bank
		System.out.println("Total money: " + BankAccount.getTotalMoney());
    }
}