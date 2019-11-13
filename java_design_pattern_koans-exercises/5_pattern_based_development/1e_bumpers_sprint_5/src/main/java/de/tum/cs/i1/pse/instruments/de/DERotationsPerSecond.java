package de.tum.cs.i1.pse.instruments.de;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.RotationsPerSecond;

public class DERotationsPerSecond extends RotationsPerSecond {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel theLabel = new JLabel("", JLabel.LEFT);
	
	public DERotationsPerSecond(UserCar theCar){
		super(theCar);
		setLayout(new BorderLayout());
		add(theLabel, BorderLayout.CENTER);
		theLabel.setText(getSpeedText(theCar.getSpeed()));
	}
	
	public void updateInstrument() {
		String newText = getSpeedText(userCar.getSpeed());
		if(!newText.equals(theLabel.getText())){
			theLabel.setText(newText);
		}
	}
	
	protected String getSpeedText(float rotationsPerSecond){
		return "Umdrehungen pro Sekunde: "+rotationsPerSecond*1000;
	}
}