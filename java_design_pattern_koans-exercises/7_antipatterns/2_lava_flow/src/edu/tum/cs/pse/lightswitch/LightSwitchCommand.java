package edu.tum.cs.pse.lightswitch;

public abstract class LightSwitchCommand {
	protected Light theLight;

    private  static final String DEBUG_MSG = "[LightSwitchCommand] Debugging the bad style, using this message";

	public abstract void execute();
}
