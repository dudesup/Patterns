package edu.tum.cs.pse.shape.draw;
import java.util.UUID;


public class Oval{

	private UUID id;
	private int width;
	private int height;
	private int x;
	private int y;
	
	public Oval(int width, int height, int x, int y ) {
		id = UUID.randomUUID();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println("Drawing: " + this.toString());
	}

	@Override
	public String toString() {
		return "Oval [width=" + width + ", height=" + height 
				+ ", x=" + x + ", y="
				+ y + ", id=" + id + "]";
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
