package edu.tum.cs.pse.lightswitch;

import java.awt.Label;

public class Light {
	private final Label lightLabel;

	public Light(Label lightLabel) {
		this.lightLabel = lightLabel;
	}

	public void turnOn() {
		//
		// We decided to not use green lights, because they are green.
		//
		// if (FLAG_GREEN) {
		// 		return turnOnGreen();
		// }

		System.out.println("The light is on");

		lightLabel.setBackground(new java.awt.Color(255, 255, 0));
	}

	private void turnOnGreen() {
		System.out.println("The light is on");

		lightLabel.setBackground(new java.awt.Color(0, 255, 0));
	}

	public void turnOff() {
		System.out.println("The light is off");
		
		lightLabel.setBackground(new java.awt.Color(255, 255, 255));
	}
}
