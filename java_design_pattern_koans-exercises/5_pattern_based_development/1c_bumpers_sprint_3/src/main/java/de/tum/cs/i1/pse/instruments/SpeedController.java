package de.tum.cs.i1.pse.instruments;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import de.tum.cs.i1.pse.car.UserCar;

public class SpeedController extends Instrument implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JButton up;
	private JButton down;
	
	public static Image UP;
	public static Image DOWN;
	
	private JLabel label = new JLabel("Geschw. Kontrolle", JLabel.LEFT);
	
	public SpeedController(UserCar userCar){
		super(userCar);
		
		setLayout(new BorderLayout());
		if(UP != null && DOWN != null){
			up = new JButton(new ImageIcon(UP));
			down = new JButton(new ImageIcon(DOWN));
		}else{
			up = new JButton("up");
			down = new JButton("down");
		}
		
		up.addActionListener(this);
		down.addActionListener(this);
		
		add(label, BorderLayout.WEST);
		JToolBar buttonBar = new JToolBar();
		buttonBar.setFloatable(false);
		buttonBar.add(up);
		buttonBar.add(down);
		add(buttonBar, BorderLayout.CENTER);
		enableButtons();
	}
	
	private void enableButtons() {
		if(this.userCar.getSpeed() < userCar.MAX_SPEED){
			up.setEnabled(true);
		}else{
			up.setEnabled(false);
		}
		
		if(this.userCar.getSpeed() > userCar.MIN_SPEED){
			down.setEnabled(true);
		}else{
			down.setEnabled(false);
		}
	}
	
	public void updateInstrument() {
		enableButtons();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(up)){
			userCar.incrementSpeed();
			userCar.notifyInstruments();
			
		}else{
			userCar.decrementSpeed();
			userCar.notifyInstruments();
		}
	}
}

