package de.tum.cs.i1.pse;

import java.io.IOException;

import com.google.inject.Inject;

/**
 * MeteorologicalStationController contains the application logic and mediates
 * between the model and the view
 */

public class MeteorologicalStationController {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;

	// TODO: Use the interfaces for variable types.
	// TODO: tell Guice to inject the variables
	@Inject
	private MeteorologicalFileStorage storage;
	@Inject
	private MeteorologicalSensorArray sensorArray;

	// This constructor is injected.
	@Inject
	public MeteorologicalStationController(IMeteorologicalStationGUI gui) {
		this.gui = gui;
		this.storage = new MeteorologicalFileStorage();
		this.sensorArray = new MeteorologicalSensorArray();
	}

	public void measure() {
		currentTemperature = sensorArray.getTemperatureData();
		currentWindspeed = sensorArray.getWindspeedData();
		currentHumidity = sensorArray.getHumidityData();
		gui.displayTemperature(currentTemperature);
		gui.displayWindspeed(currentWindspeed);
		gui.displayHumidity(currentHumidity);
	}

	public void save() throws IOException {
		storage.setTemperature(currentTemperature);
		storage.setWindspeed(currentWindspeed);
		storage.setHumidity(currentHumidity);
		storage.save();
	}
}
