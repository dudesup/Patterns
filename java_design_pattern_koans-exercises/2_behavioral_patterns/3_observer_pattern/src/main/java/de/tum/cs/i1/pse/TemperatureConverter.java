package de.tum.cs.i1.pse;

import java.awt.Point;

import de.tum.cs.i1.pse.model.TemperatureModel;
import de.tum.cs.i1.pse.observers.CelsiusGUI;
import de.tum.cs.i1.pse.observers.FahrenheitGUI;
import de.tum.cs.i1.pse.observers.GaugeGUI;
import de.tum.cs.i1.pse.observers.SliderGUI;


//TODO create KelvinGUI class
//TODO Add methods in TemperatureModel class

public class TemperatureConverter {

	public static void main(String args[]) {
		TemperatureModel temperature = new TemperatureModel();
		
		FahrenheitGUI fahrenheitGUI = new FahrenheitGUI(temperature, new Point(100, 100));
		fahrenheitGUI.show();
		
		CelsiusGUI celsiusGUI = new CelsiusGUI(temperature, new Point(100, 250));
		celsiusGUI.show();
		
		SliderGUI sliderGUI = new SliderGUI(temperature, new Point(20, 100));
		sliderGUI.show();
		
		GaugeGUI gaugeGUI = new GaugeGUI(temperature, new Point(200, 200));
		gaugeGUI.setVisible(true);
		
		//TODO: instantiate the Kelvin view
	}
}
