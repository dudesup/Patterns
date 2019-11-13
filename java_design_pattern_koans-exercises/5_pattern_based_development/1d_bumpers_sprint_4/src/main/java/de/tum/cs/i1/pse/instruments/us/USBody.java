package de.tum.cs.i1.pse.instruments.us;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.tum.cs.i1.pse.car.UserCar;
import de.tum.cs.i1.pse.instruments.Body;

public class USBody extends Body{
	
	private static final long serialVersionUID = 1L;
	private Image drivenCarImage;
	private JPanel theIcon;
	private JLabel theText = new JLabel("Your car");;
	
	public USBody(UserCar userCar){
		super(userCar);
		this.drivenCarImage = userCar.getBody();
		setLayout(new BorderLayout());
		
		theIcon = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g){
				super.paint(g);
				int yPosition = USBody.this.getSize().height/2;
				yPosition = yPosition-USBody.this.userCar.getSize().height/2;
				g.drawImage(drivenCarImage,
							0,
							yPosition,
							USBody.this.userCar.getSize().width,
							USBody.this.userCar.getSize().height,
							null);
			}
		};
		add(theIcon, BorderLayout.CENTER);
		add(theText, BorderLayout.EAST);
	}
	
	
	public void updateInstrument() {
		if(!userCar.getBody().equals(this.drivenCarImage)){
			this.drivenCarImage = userCar.getBody();
			theIcon.repaint();
		}
	}
}