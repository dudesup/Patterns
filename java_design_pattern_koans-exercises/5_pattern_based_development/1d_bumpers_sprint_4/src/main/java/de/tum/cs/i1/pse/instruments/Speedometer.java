package de.tum.cs.i1.pse.instruments;

import de.tum.cs.i1.pse.car.UserCar;

public abstract class Speedometer extends Instrument {
	
	private static final long serialVersionUID = 1L;

	public Speedometer(UserCar theCar){
		super(theCar);
	}	
}

