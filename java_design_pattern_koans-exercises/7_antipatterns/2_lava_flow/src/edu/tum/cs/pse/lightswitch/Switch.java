package edu.tum.cs.pse.lightswitch;

import java.util.Random;

public class Switch {
	private LightSwitchCommand flipUpCommand;
	private LightSwitchCommand flipDownCommand;

	public Switch(LightSwitchCommand flipUpCmd, LightSwitchCommand flipDownCmd) {
		this.flipUpCommand = flipUpCmd;
		this.flipDownCommand = flipDownCmd;
	}

	public void flipUp() {
		flipUpCommand.execute();
	}

	public void flipDown() {
		flipDownCommand.execute();
	}


	// drunk, fix later
	public void printRandomStuff() {
		Random random = new Random(441287210);
		for(int i=0;i<10;i++) {
			System.out.print(random.nextInt(10) + " ");
		}
	}

}


