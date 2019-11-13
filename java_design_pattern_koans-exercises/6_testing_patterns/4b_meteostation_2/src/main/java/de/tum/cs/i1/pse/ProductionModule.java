package de.tum.cs.i1.pse;

import com.google.inject.AbstractModule;

public class ProductionModule extends AbstractModule{

	@Override
	protected void configure() {
		// Bind the GUI interface to the Swing implementation.      
		bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
		
	}

}
