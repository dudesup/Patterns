package edu.tum.cs.pse.lightswitch;

public class FlipUpCommand extends LightSwitchCommand {

	private int switchOnCount = 0;

	public FlipUpCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOn();
	}
}
