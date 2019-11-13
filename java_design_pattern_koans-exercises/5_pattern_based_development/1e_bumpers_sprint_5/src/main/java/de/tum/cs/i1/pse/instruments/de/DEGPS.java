package de.tum.cs.i1.pse.instruments.de;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JLabel;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.GPS;

public class DEGPS extends GPS{

	private static final long serialVersionUID = 1L;
	private JLabel positionLabel = new JLabel();
	
	public DEGPS(UserCar theCar){
		super(theCar);
		setLayout(new BorderLayout());
		add(positionLabel, BorderLayout.CENTER);
		positionLabel.setText(getPositionText(theCar.getPosition()));
	}
	
	public void updateInstrument() {
		String newText = getPositionText(userCar.getPosition());
		if(!newText.equals(positionLabel.getText())){
			positionLabel.setText(newText);
		}
	}
	
	private String getPositionText(Point position){
		String x,y;
		if(position.x < 10){
			x = "000"+position.x;
		}else if(position.x < 100){
			x = "00"+position.x;
		}else if(position.x < 1000){
			x = "0"+position.x;
		}else{
			x = ""+position.x;
		}
		
		if(position.y < 10){
			y = "000"+position.y;
		}else if(position.y < 100){
			y = "00"+position.y;
		}else if(position.y < 1000){
			y = "0"+position.y;
		}else{
			y = ""+position.y;
		}
		
		return "GPS Koordinaten: "+x+" | "+y;
	}
}
