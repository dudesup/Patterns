package de.tum.cs.i1.pse.instruments;

import de.tum.cs.i1.pse.car.UserCar;

public abstract class InstrumentFactory {
	public abstract Speedometer createSpeedometer(UserCar userCar);
	public abstract RotationsPerSecond createRotationsPerSecond(UserCar userCar);
	public abstract SpeedController createSpeedController(UserCar userCar);
	public abstract GPS createGPS(UserCar userCar);
	public abstract Body createBodyView(UserCar userCar);
	//TODO Add Method for creatin AnalogSpeedometerAdapter
}