package de.tum.cs.i1.pse;

import java.io.IOException;

/**
 * MeteorologicalStationController contains the application logic and mediates
 * between the model and the view
 */
public class MeteorologicalStationController {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	//TODO: Tell Guice to inject this attribute
	private MeteorologicalFileStorage storage;
	//TODO: Tell Guice to inject this attribute 
	private MeteorologicalSensorArray sensorArray;

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
