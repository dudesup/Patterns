package de.tum.cs.i1.pse;

//TODO: Paused State must conform to the State interface
public class Paused {

	protected int computeVampirePower() {
		return 42;
	}

	private void pauseMusic() {
		System.out.println("Pause Music");
	}

	private void checkTimeout() {
		System.out.println("Check Timeout");
	}

}
