package de.tum.cs.i1.pse;
//TODO: On State must conform to the State interface
public class Inactive {
	
	protected int computeVampirePower() {
		return 42;
	}
	
	private void LEDOff() {
		System.out.println("LED turned Off.");
	}
}
