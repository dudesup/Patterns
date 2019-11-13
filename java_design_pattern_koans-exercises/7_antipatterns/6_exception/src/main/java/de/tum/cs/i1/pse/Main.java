package de.tum.cs.i1.pse;


public class Main {

	public static void handleOverdrawn() {
		System.out.println("overdraw!");
	}
	
	public static void doTheUsualThing() {
		System.out.println("usual thing!");
	}
	
	// main
	public static void main(String[] args) {

		// caller
		Account account = new Account(100);
		int amount = 120;
		
		if (account.withdraw(amount) == -1)
			handleOverdrawn();
		else
			doTheUsualThing();
	}	

}
