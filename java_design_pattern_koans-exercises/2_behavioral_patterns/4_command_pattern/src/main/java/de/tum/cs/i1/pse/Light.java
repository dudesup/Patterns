package de.tum.cs.i1.pse;

import java.awt.Color;

import javax.swing.*;

public class Light{
	
	private final JPanel lightPanel;

	public Light(JPanel lightPanel) {
		this.lightPanel = lightPanel;
	}

	public void turnOn() {
		System.out.println("The light is on");
		this.lightPanel.setBackground(Color.yellow);
	}

	public void turnOff() {
		System.out.println("The light is off");
		this.lightPanel.setBackground(Color.black);
	}
}
