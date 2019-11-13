package de.tum.cs.i1.pse;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import de.tum.cs.i1.pse.model.TemperatureModel;
import de.tum.cs.i1.pse.observers.KelvinGUI;

public class FunctionalTest {

	@Test(timeout = 100)
	public void testTemperatureConversionInModel() {
		double KELVIN_CONST = 273.15;
		double expected = 0, actual = 0, RandomK, RandomF, RandomC;
		TemperatureModel temperatureModel = new TemperatureModel();

		Random random = new Random(1);
		RandomF = random.nextDouble() * 100;
		expected = ((RandomF - 32.0) * 5.0 / 9.0 + KELVIN_CONST);
		temperatureModel.setF(RandomF);
		actual = temperatureModel.getK();
		Assert.assertEquals(expected, actual, 0.0f);

		
		RandomK = random.nextDouble() * 100;
		expected = ((RandomK - KELVIN_CONST) * 9.0 / 5.0) + 32.0;
		temperatureModel.setK(RandomK);
		actual = temperatureModel.getF();
		Assert.assertEquals(expected, actual, 0.0f);

		RandomC = random.nextDouble() * 100;
		expected = RandomC + KELVIN_CONST;
		temperatureModel.setC(RandomC);
		actual = temperatureModel.getK();
		Assert.assertEquals(expected, actual, 0.0f);

		RandomK = random.nextDouble() * 100;
		expected = RandomK - KELVIN_CONST;
		temperatureModel.setK(RandomK);
		actual = temperatureModel.getC();
		Assert.assertEquals(expected, actual, 0.1f);

		// normal without showing the equation
		expected = 99.99999999999999;
		temperatureModel.setK(310.92777777777775);
		actual = temperatureModel.getF();
		Assert.assertEquals(expected, actual, 0.0f);

	}
	
	@Test(timeout = 5000) 
	public void testKelvinGUIIsObserver(){
		TemperatureModel temperatureModel = new TemperatureModel();
		@SuppressWarnings("unused")
		KelvinGUI kelvinGUI = new KelvinGUI(temperatureModel, new Point(0, 0));
		assertTrue(temperatureModel.countObservers() == 1);
	
	}
	
	
	@Test(timeout = 5000)
	public void testKelvinGUIIsNotifiedUponModelChanges(){
		TemperatureModel temperatureModel = new TemperatureModel();
		KelvinGUI kelvinGUI = new KelvinGUI(temperatureModel, new Point(0, 0));
		
		temperatureModel.setK(280);
		double expectedValue = 280;
		double actualValue = kelvinGUI.getDisplay();
		Assert.assertEquals(expectedValue, actualValue, 0.1f);
	
	}


}
