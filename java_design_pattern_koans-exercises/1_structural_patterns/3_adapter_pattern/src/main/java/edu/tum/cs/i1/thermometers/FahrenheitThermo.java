package edu.tum.cs.i1.thermometers;

import java.util.Random;

public class FahrenheitThermo {
	

	public double getFarenheitTemperature(){
		Random random = new Random(1);
		double currentTempInFahrenheit = random.nextDouble() * 100;
		return currentTempInFahrenheit;
	}


}
