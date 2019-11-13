package edu.tum.cs.i1.pse;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionTest {

	private int[] allowedPorts = new int[] { 80, 8080 };

	@Test(timeout = 100)
	public void testConnectingToAnAllowedPort() {
		Firewall firewall = new Firewall(allowedPorts);
		firewall.open("google.com", 80);
		assertTrue(firewall.isConnected());
	}

	@Test(timeout = 100, expected = RuntimeException.class)
	public void testConnectingToAnUnallowedPort() {
		Firewall firewall = new Firewall(allowedPorts);
		firewall.open("google.com", 21);
	}

}