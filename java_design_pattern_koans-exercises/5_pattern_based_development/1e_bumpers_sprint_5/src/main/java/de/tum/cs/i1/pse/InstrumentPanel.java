package de.tum.cs.i1.pse;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.*;
import de.tum.cs.i1.pse.instruments.de.DEFactory;
import de.tum.cs.i1.pse.instruments.us.USFactory;

public class InstrumentPanel extends JToolBar {

	private static final long serialVersionUID = 1L;
	protected static final String GERMAN = "GERMAN";
	protected static final String ENGLISH = "ENGLISH";
	
	private JToolBar controlToolBar;
	
	private Body bodyView;
	private RotationsPerSecond rotationsPerSecond;
	private Speedometer speedometer;
	private SpeedController speedController;
	private GPS gps;
	
	private UserCar userCar;
	private InstrumentFactory factory = new USFactory();
	private Object language;

	private AnalogSpeedometerAdapter analogSpeedometerAdapter;
	
	public InstrumentPanel(UserCar userCar){
		super(JToolBar.VERTICAL);
		setFloatable(false);
		this.userCar = userCar;
		
		JRadioButton germanSelectButton = new JRadioButton("German");
		JRadioButton englishSelectButton = new JRadioButton("U.S.", true);
		
		ItemListener languageListener = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if(source.equals(germanSelectButton) && source.isSelected()){
					setLanguage(InstrumentPanel.GERMAN);
				}else if(source.equals(englishSelectButton) && source.isSelected()){
					setLanguage(InstrumentPanel.ENGLISH);
				}
			}};
			
		germanSelectButton.addItemListener(languageListener);
		englishSelectButton.addItemListener(languageListener);
		
		ButtonGroup group = new ButtonGroup();
		group.add(englishSelectButton);
		group.add(germanSelectButton);
		
		controlToolBar = new JToolBar();
		controlToolBar.setFloatable(false);
		
		controlToolBar.add(germanSelectButton);
		controlToolBar.add(englishSelectButton);	
				
		setInstrumentFactory(new USFactory());
		
		add(controlToolBar);
	}
	
	private void createInstruments(InstrumentFactory factory, UserCar userCar) {
		rotationsPerSecond = factory.createRotationsPerSecond(userCar);
		speedometer = factory.createSpeedometer(userCar);
		speedController = factory.createSpeedController(userCar);
		bodyView = factory.createBodyView(userCar);
		gps = factory.createGPS(userCar);
		analogSpeedometerAdapter = factory.createAnalogSpeedometerAdapter(userCar);
	}
	
	private void addInstruments() {
		add(rotationsPerSecond);
		add(speedometer);
		add(speedController);
		add(gps);
		add(bodyView);
		add(analogSpeedometerAdapter.getAnalogSpeedometer());
	}	
	
	private void subscribeInstruments(UserCar userCar) {
		userCar.subscribeInstrument(rotationsPerSecond);
		userCar.subscribeInstrument(speedometer);
		userCar.subscribeInstrument(speedController);
		userCar.subscribeInstrument(gps);
		userCar.subscribeInstrument(bodyView);
		userCar.subscribeInstrument(analogSpeedometerAdapter);
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
	
	private void removeInstruments() {
		removeAll();
	}
	
	private void setInstrumentFactory(InstrumentFactory factory){
		if(!this.factory.equals(factory)){
			this.factory = factory;
			removeInstruments();
			createInstruments(this.factory, this.userCar);
			subscribeInstruments(this.userCar);
			addInstruments();
			add(controlToolBar);
			revalidate();
			doLayout();
			repaint();
		}
	}
	
	public void setLanguage(String newLanguage){
		if(!newLanguage.equals(this.language)){
			this.language = newLanguage;
			if(this.language.equals(GERMAN)){
				setInstrumentFactory(new DEFactory());
			}else{
				setInstrumentFactory(new USFactory());
			}
		}
	}
}
