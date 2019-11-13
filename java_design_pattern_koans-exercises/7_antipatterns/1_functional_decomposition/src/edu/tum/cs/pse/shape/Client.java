package edu.tum.cs.pse.shape;

import edu.tum.cs.pse.shape.change.ShapeChanger;
import edu.tum.cs.pse.shape.draw.Oval;
import edu.tum.cs.pse.shape.draw.Rectangle;

public class Client {

	//TODO 01: Introduce an abstract Shape class
	//TODO 02: Make Oval and Rectangle implement the new Shape Class
	//TODO 03: Introduce a method chageFrom(Shape) that transforms one shape into another
	//TODO 04: Deprecate ShapeChanger
	//TODO 05: Add a new shape Circle and implement the changeForm method for Circle.
	
	
	
	public static void main(String[] args) throws Exception {
		// change oval to rectangle
		Oval o = new Oval(10,20,30,40);
		System.out.println("Changing oval to rectangle");
		System.out.println("Before change: " + o);
		Rectangle resultingRectangle = ShapeChanger.changeOvalToRectangle(o);
		resultingRectangle.draw();
		
		System.out.println();
				
		// change rectangle to Circle
		Rectangle r = new Rectangle(1,2,3,4);
		System.out.println("Changing rectangle to oval");
		System.out.println("Before change: " + r);
		Oval resultingOval = ShapeChanger.changeRectangleToOval(r);
		resultingOval.draw();
	}

}
