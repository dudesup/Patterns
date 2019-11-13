package de.tum.cs.i1.pse.instruments.us;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.*;

public class USFactory extends InstrumentFactory {
	
	public USFactory(){
		
	}
	
	public RotationsPerSecond createRotationsPerSecond(UserCar userCar) {
		return new USRotationsPerSecond(userCar);
	}
	
	public SpeedController createSpeedController(UserCar userCar) {
		return new USSpeedController(userCar);
	}
	
	public Speedometer createSpeedometer(UserCar userCar) {
		return new USSpeedometer(userCar);
	}
	
	public Body createBodyView(UserCar userCar) {
		return new USBody(userCar);
	}
	
	public GPS createGPS(UserCar userCar) {
		return new USGPS(userCar);
	}
}
