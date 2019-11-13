package edu.tum.cs.i1.pse;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FunctionalTest {
	String encryptionType;
	CryptoSystem cryptoSystemEnterprise;
	CryptoSystem cryptoSystemPersonal;
	String plainText;
	byte key;
	
	
	
	@Before
	public void setup() {
		cryptoSystemEnterprise = new CryptoSystem("Enterprise");
		cryptoSystemPersonal = new CryptoSystem("");
		plainText = "hi my name is ioannis";
		key = (byte) 10;
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test(timeout = 100)
	public void testEnterprisePlainTextToCiphertext() {
		String expectedCiphertext = " rs wi xkwo sc sykxxsc";
		String actualCiphertext = cryptoSystemEnterprise.encryptDoc(plainText, key);
			
		assertEquals(expectedCiphertext.trim(), actualCiphertext.trim());
	}
	
	@Test(timeout = 100)
	public void testEnterpriseCiphertextToPlainText() {
		String expectedPlaintext = " hi my name is ioannis";
		String actualPlainText = cryptoSystemEnterprise.decryptDoc(" rs wi xkwo sc sykxxsc", key);
		assertEquals(expectedPlaintext.trim(), actualPlainText.trim());
	}
	
	@Test(timeout = 100)
	public void testPersonalPlainTextToCiphertext() {
		String expectedCyphertext = " ih ym eman si sinnaoi";
		String actualCyphertext = cryptoSystemPersonal.encryptDoc(plainText, key);
		assertEquals(expectedCyphertext.trim(), actualCyphertext.trim());
	}
	
	@Test(timeout = 100)
	public void testPersonalCiphertextToPlainText() {
		String expectedPlaintext = " hi my name is ioannis";
		String actualPlainText = cryptoSystemPersonal.decryptDoc(" ih ym eman si sinnaoi", key);
		assertEquals(expectedPlaintext.trim(), actualPlainText.trim());
	}
	

	@Test(timeout = 100, expected = RuntimeException.class)
	public void testIfKeyIsValidEnterprise() {
		cryptoSystemEnterprise.encryptDoc("doom!", (byte)4);
	}
	
	
}
