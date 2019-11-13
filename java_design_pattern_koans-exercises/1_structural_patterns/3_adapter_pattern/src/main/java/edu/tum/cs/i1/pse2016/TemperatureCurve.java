package edu.tum.cs.i1.pse2016;

import java.text.DecimalFormat;

import edu.tum.cs.i1.thermometers.CelsiusThermo;

public class TemperatureCurve {

	public static void main(String[] args) {

		
		ThermoInterface thermo = new CelsiusThermo();
		//TODO: Replace the implementation of CelsiusThermo() with ThermoAdapter. 
		
		
		
		DecimalFormat df = new DecimalFormat("#.#");

		for (int i = 0; i < 5; i++) {
			System.out.println(df.format(thermo.getTempC()));
		}

	}

}
