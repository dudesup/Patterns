package edu.tum.cs.i1.pse;

public class CryptoSystem {

	// TODO: Introduce a new class Encryption that allows you to add encryption
	// algorithms independently of the application domain
	// TODO: Create subclasses of Encryption for personal and enterprise
	// encryption
	// TODO: Replace the implementation of the Cipher algorithm with the new
	// Encryption class
	private Cipher impl;

	public CryptoSystem(String encryptionType) {

		if (encryptionType.equalsIgnoreCase("Enterprise"))
			impl = new Caesar();
		else
			impl = new Transpose();
	}

	public String encryptDoc(String plain, byte key) {
		return impl.encryptWord(plain, key);
	}

	public String decryptDoc(String secret, byte key) {
		return impl.decryptWord(secret, key);
	}

}
