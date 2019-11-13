package de.tum.cs.i1.pse.instruments.de;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.Speedometer;

public class DESpeedometer extends Speedometer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel theLabel = new JLabel("", JLabel.LEFT);
	
	public DESpeedometer(UserCar userCar){
		super(userCar);
		setLayout(new BorderLayout());
		add(theLabel, BorderLayout.CENTER);
		theLabel.setText(getSpeedText(userCar.getSpeed()));
	}
	
	public void updateInstrument() {
		String newText = getSpeedText(userCar.getSpeed());
		if(!newText.equals(theLabel.getText())){
			theLabel.setText(newText);
		}
	}
	
	protected String getSpeedText(float rotationsPerSecond){
		return "Geschwindigkeit: "+rotationsPerSecond*10*8/5+" km/h";
	}
}
