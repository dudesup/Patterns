package edu.tum.cs.pse.lightswitch;

public class FlipDownCommand extends LightSwitchCommand {

	//We used log4j. But we are not using it anymore.
	//Nevertheless I keep this class. I only rename it. "Maybe" we use it later!
	//I haven't taken patterns lecture, and I don't know about Lava Flow antipattern.
	// final static Logger logger = Logger.getLogger(FlipDownCommand.class);


	private int switchOnCount = 0;


	public FlipDownCommand(Light light) {
		this.theLight = light;
	}


	/*public FlipDownCommand_old(Light light) {
		// this.theLight = light;
	}*/


	public void execute() {
		theLight.turnOff();
	}


	public void execute_old() {
		// switchOnCount++;
		// Logger.info("SwitchOn command executed. Count: " + switchOnCount)
		// theLight.turnOff();
	}


}
