package de.tum.cs.i1.pse.steering;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import de.tum.cs.i1.pse.GameBoard;
import de.tum.cs.i1.pse.car.UserCar;

public class MouseSteering extends MouseAdapter {
	
	private UserCar userCar;
	private GameBoard theField;
	
    public MouseSteering(GameBoard playingField, UserCar userCar) {
		this.userCar = userCar;
		this.theField = playingField;
		this.theField.addMouseListener(this);
    }
	
    public void mousePressed(MouseEvent e) {
		Point carPosition = userCar.getPosition();
		Point clickPosition = theField.convertPosition(new Point(e.getX(), e.getY()));
		int delta_x = clickPosition.x - carPosition.x;
		delta_x = Math.abs(delta_x);
		int delta_y = clickPosition.y - carPosition.y;
		double diff = ((double)delta_y)/((double)delta_x);
		double theta = Math.atan(diff);
		int degree = (int)Math.toDegrees(theta);
		
		if(clickPosition.x>carPosition.x){
			degree = 90-degree;
		}else{
			degree = 270+degree;
		}
		userCar.setDirection(degree);
    }
}

