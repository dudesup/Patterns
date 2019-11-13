package de.tum.cs.i1.pse;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.*;

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
	
	//TODO Add field for Factory
	
	private UserCar userCar;
	private Object language;
	
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
		
		//TODO set Instrument Factory for US
		
		add(controlToolBar);
	}
	
	private void addInstruments() {
		add(rotationsPerSecond);
		add(speedometer);
		add(speedController);
		add(gps);
		add(bodyView);
	}	
	
	private void subscribeInstruments(UserCar userCar) {
		userCar.subscribeInstrument(rotationsPerSecond);
		userCar.subscribeInstrument(speedometer);
		userCar.subscribeInstrument(speedController);
		userCar.subscribeInstrument(gps);
		userCar.subscribeInstrument(bodyView);
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
	
	//TODO Add Method createInstruments with parameter factory and userCar
	
	//TODO Add parameter for factory
	private void setInstrumentFactory(){
		//TODO Set factory parameter to factory field
		removeInstruments();
		//TODO Invoke createInstruments method
		subscribeInstruments(this.userCar);
		addInstruments();
		add(controlToolBar);
		revalidate();
		doLayout();
		repaint();
	}
	
	public void setLanguage(String newLanguage){
		if(!newLanguage.equals(this.language)){
			this.language = newLanguage;
			if(this.language.equals(GERMAN)){
				//TODO Set German Factory
			}else{
				//TODO Set US Factory
			}
		}
	}
}
