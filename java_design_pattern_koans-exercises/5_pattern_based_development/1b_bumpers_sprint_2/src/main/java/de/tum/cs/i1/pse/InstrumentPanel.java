package de.tum.cs.i1.pse;

import java.awt.Dimension;
import javax.swing.JToolBar;

import de.tum.cs.i1.pse.car.UserCar;

public class InstrumentPanel extends JToolBar {

	private static final long serialVersionUID = 1L;
	;
	private JToolBar controlToolBar;
	
	//TODO Add fields for all the Instruments
	 
	public InstrumentPanel(UserCar userCar){
		super(JToolBar.VERTICAL);
		setFloatable(false);

		
		createInstruments(userCar);
		subscribeInstruments(userCar);
		addInstruments();
		
		controlToolBar = new JToolBar();
		controlToolBar.setFloatable(false);
		
		add(controlToolBar);
	}
	
	private void createInstruments(UserCar userCar) {
		//TODO Create the instruments here RotationsPerSecond, Speedometer, SpeedController, Body, GPS
	}
	
	private void addInstruments() {
		//TODO Add all the Instruments to the View
	}	
	
	private void subscribeInstruments(UserCar userCar) {
		//TODO Subscribe all Instruments to the Publisher
	}
	
	public Dimension getPreferredSize(){
		Dimension d = super.getPreferredSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMinimumSize(){
		Dimension d = super.getMinimumSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMaximumSize(){
		Dimension d = super.getMaximumSize();
		return new Dimension(300, d.height);
	}
}
