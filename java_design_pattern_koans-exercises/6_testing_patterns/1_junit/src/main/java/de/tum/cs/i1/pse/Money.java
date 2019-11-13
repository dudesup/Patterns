package de.tum.cs.i1.pse;

public class Money {
	private int amount;
	private String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int amount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Money add(Money m) {
		//TODO: what if the currency attribute of the input parameter is different? 
		return new Money(amount() + m.amount(), getCurrency());
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney = (Money) anObject;
			return aMoney.getCurrency().equals(currency) && aMoney.amount() == amount;
		}
		return false;
	}
}