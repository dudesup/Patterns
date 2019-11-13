package de.tum.cs.i1.pse.instruments;

import javax.swing.JPanel;

import de.tum.cs.i1.pse.car.UserCar;

public abstract class Instrument extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected UserCar userCar;
	
	public Instrument(UserCar userCar) {
		this.userCar = userCar;
	}
	
	public abstract void updateInstrument();
}
