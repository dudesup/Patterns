package de.tum.cs.i1.pse;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
// TODO: Create interfaces for MeteorologicalFileStorage and
// MeteorologicalSensorArray classes
public class MeteorologicalStation {
	public static void main(String[] args) {
		// Create the injector.
		Injector injector = Guice.createInjector(new ProductionModule());
		// Use the injector to get a new instance of the
		// IMeteorologicalStationGUI class.
		IMeteorologicalStationGUI msgui = injector.getInstance(IMeteorologicalStationGUI.class);
		msgui.show();
	}
}
