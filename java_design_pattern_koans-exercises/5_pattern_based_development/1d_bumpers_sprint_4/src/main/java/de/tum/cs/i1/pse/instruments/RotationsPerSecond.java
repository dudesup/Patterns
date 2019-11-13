package de.tum.cs.i1.pse.instruments;

import de.tum.cs.i1.pse.car.UserCar;

public abstract class RotationsPerSecond extends Instrument {

	private static final long serialVersionUID = 1L;

	public RotationsPerSecond(UserCar theCar){
		super(theCar);
	}
	
}
