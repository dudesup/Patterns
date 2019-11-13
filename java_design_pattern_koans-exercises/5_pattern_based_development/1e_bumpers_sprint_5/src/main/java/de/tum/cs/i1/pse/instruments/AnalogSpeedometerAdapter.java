package de.tum.cs.i1.pse.instruments;

import de.tum.cs.i1.pse.car.UserCar;

public class AnalogSpeedometerAdapter extends Instrument{
	
	private static final long serialVersionUID = 1L;
	private AnalogSpeedometer speedometer;
	private int speed;
	
	public AnalogSpeedometerAdapter(UserCar theCar,
									AnalogSpeedometer speedometer){
		super(theCar);
		this.speedometer = speedometer;
		updateInstrument();
	}
	
	public AnalogSpeedometer getAnalogSpeedometer() {
		return this.speedometer;
	}
	
	public void updateInstrument() {
		if(this.speed != userCar.getSpeed()){
			this.speed = userCar.getSpeed();
			
			double percent = (double)userCar.MAX_SPEED/100*this.speed;
			int angle = (int)(speedometer.getMaxAngle()*percent);
			this.speedometer.setAngle(angle);
		}
	}
	
}
