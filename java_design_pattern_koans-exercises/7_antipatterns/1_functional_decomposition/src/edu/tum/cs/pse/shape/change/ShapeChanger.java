package edu.tum.cs.pse.shape.change;

import edu.tum.cs.pse.shape.draw.Oval;
import edu.tum.cs.pse.shape.draw.Rectangle;
import edu.tum.cs.pse.shape.exception.DeprecatedException;

/**
 * Class holds helper method for changing shapes
 */
public class ShapeChanger {

	public static Oval changeRectangleToOval(Rectangle r) throws Exception {
		Oval result = new Oval(r.getWidth(), r.getHeight(), r.getX(), r.getY());
		return result;
	}
	
	public static Rectangle changeOvalToRectangle(Oval o) throws Exception {
		Rectangle result = new Rectangle(o.getWidth(), o.getHeight(), o.getX(), o.getY());
		return result;
	}
}
