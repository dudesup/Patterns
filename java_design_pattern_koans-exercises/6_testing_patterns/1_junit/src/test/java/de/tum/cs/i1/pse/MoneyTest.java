package de.tum.cs.i1.pse;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {
	@Test
	public void simpleAdd() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money observed = m12CHF.add(m14CHF);
		assertTrue(expected.equals(observed));
	}
	
	
	@Test
	public void testAddWithDifferentCurrencies(){
		//TODO: Write a test that adds different currencies.
	}
	
}
