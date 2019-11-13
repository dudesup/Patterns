package de.tum.cs.i1.pse;

import static org.junit.Assert.*;

import org.junit.Test;

import de.tum.cs.i1.pse.Client;

import org.junit.After;
import org.junit.Before;

import java.awt.Color;

public class FunctionalTest {
	Client client; 
	
	@Before
	public void setup() {
		client = new Client();
		client.init();
	}
	
	@After
	public void tearDown() {
		
	}
		
	@Test(timeout = 100)
	public void testLightOn() {
		client.btnUp.doClick();
		Color expectedValue = Color.yellow; 
		Color currentValue = client.lightPanel.getBackground();
		assertEquals("Expected light color: " + expectedValue + ", your light color: " + currentValue, expectedValue, currentValue);
	}
	
	@Test(timeout = 100)
	public void testLightOff() {
		client.btnDown.doClick();
		Color expectedValue = Color.black; 
		Color currentValue = client.lightPanel.getBackground();
		assertEquals("Expected light color: " + expectedValue + ", your light color: " + currentValue, expectedValue, currentValue);
	}
	
	@Test(timeout = 100)
	public void testSwitchFlipDown() {
		client.lightSwitch.flipDown();
		Color expectedValue = Color.black; 
		Color currentValue = client.lightPanel.getBackground();
		assertEquals("Expected light color: " + expectedValue + ", your light color: " + currentValue, expectedValue, currentValue);
	}
	
	@Test(timeout = 100)
	public void testSwitchFlipUp() {
		client.lightSwitch.flipUp();
		Color expectedValue = Color.yellow; 
		Color currentValue = client.lightPanel.getBackground();
		assertEquals("Expected light color: " + expectedValue + ", your light color: " + currentValue, expectedValue, currentValue);
	}
	
		
}
