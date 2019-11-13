package de.tum.cs.i1.pse.instruments.de;

import de.tum.cs.i1.pse.instruments.InstrumentFactory;
import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.*;

public class DEFactory extends InstrumentFactory {
	
	public DEFactory(){
		
	}
	
	public RotationsPerSecond createRotationsPerSecond(UserCar theCar) {
		return new DERotationsPerSecond(theCar);
	}
	
	public SpeedController createSpeedController(UserCar theCar) {
		return new DESpeedController(theCar);
	}
	
	public Speedometer createSpeedometer(UserCar theCar) {
		return new DESpeedometer(theCar);
	}
	
	public Body createBodyView(UserCar theCar) {
		return new DEBody(theCar);
	}
	
	public GPS createGPS(UserCar theCar) {
		return new DEGPS(theCar);
	}
}