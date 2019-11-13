package de.tum.cs.i1.pse;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import de.tum.cs.i1.pse.car.*;

public class GameBoard extends Canvas {

    private static final long serialVersionUID = 1L;

    private static int NUMBER_OF_CARS = 2;
    //TODO Change Number of Cars, there should be 2 Fast Cars and 2 Slow Cars
    
    private static Dimension DEFAULT_SIZE = new Dimension(500, 300);
    private static Color backgroundColor = Color.WHITE;

    private ArrayList<Car> cars = new ArrayList<Car>();

    private Image backgroundImage;
    private Graphics backgroundGraphics;
    private Dimension size;
    
    public Referee referee;

    public GameBoard() {
        setSize(getPreferredSize());
        referee =  new Referee(this);
    }

	public Dimension getPreferredSize() {
        return DEFAULT_SIZE;
    }

    public Car[] getCars() {
        return (Car[]) cars.toArray(new Car[cars.size()]);
    }

    public void update(Graphics g) {
        if (size == null || size.width != getSize().width || size.height != getSize().height) {
            size = getSize();
            backgroundImage = createImage(size.width, size.height);
            backgroundGraphics = backgroundImage.getGraphics();
        }
        paint(backgroundGraphics);
        g.drawImage(backgroundImage, 0, 0, null);
    }

    public void paint(Graphics g) {

        g.setColor(backgroundColor);
        g.fillRect(0, 0, getSize().width, getSize().height);

        Car[] carArray = getCars();
        int num = carArray.length;
        for (int i = 0; i < num; i++) {
            paintCar(carArray[i], g);
        }
    }

    private void paintCar(Car car, Graphics g) {
        Point carPosition = car.getPosition();
        Point canvasPosition = convertPosition(carPosition);
        g.drawImage(car.getBody(), canvasPosition.x, canvasPosition.y, car
                .getSize().width, car.getSize().height, null);
    }

    public void setup() {
    	this.cars.clear();
    	//TODO Setup the different cars here
    	for (int i = 0; i < NUMBER_OF_CARS; i++) {
            cars.add(new Car(getSize().width, getSize().height));
        }
        repaint();
    }

    private Point convertPosition(Point toConvert) {
        return new Point(toConvert.x, getSize().height - toConvert.y);
    }
}
