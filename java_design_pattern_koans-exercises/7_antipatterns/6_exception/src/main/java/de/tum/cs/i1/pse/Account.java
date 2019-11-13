package de.tum.cs.i1.pse;

class Account {
	
	private int balance;

	public Account(int amount) {
		balance = amount;
	}
	
	public Account() {
		balance = 0;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	public boolean canWithdraw(int amount) {
		return balance >= amount;
	}
	
	public int withdraw(int amount) {
		if (amount > balance)
			return -1;
		else {
			balance -= amount;
			return 0;
		}
	}
	
}


