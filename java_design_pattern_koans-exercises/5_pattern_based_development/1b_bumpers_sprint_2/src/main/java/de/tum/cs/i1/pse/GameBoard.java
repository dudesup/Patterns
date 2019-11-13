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

    public static int NUMBER_OF_FAST_CARS = 1;
    public static int NUMBER_OF_SLOW_CARS = 2;;

    private static Dimension DEFAULT_SIZE = new Dimension(500, 300);
    private static Color backgroundColor = Color.WHITE;

    private ArrayList<Car> cars = new ArrayList<Car>();

    private Image backgroundImage;
    private Graphics backgroundGraphics;
    private Dimension size;
    
    private UserCar userCar;
    public Referee referee;

    public GameBoard() {
        setSize(getPreferredSize());
        userCar = new UserCar(250, 30);
        //TODO Instantiate the MouseSteering for this gameboard and the userCar
        referee =  new Referee(this);
    }

	public Dimension getPreferredSize() {
        return DEFAULT_SIZE;
    }

    public Car[] getCars() {
        return (Car[]) cars.toArray(new Car[cars.size()]);
    }
    
    public UserCar getUserCar() {
        return this.userCar;
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
        paintCar(userCar, g);
    }

    private void paintCar(Car car, Graphics g) {
        Point carPosition = car.getPosition();
        Point canvasPosition = convertPosition(carPosition);
        g.drawImage(car.getBody(), canvasPosition.x, canvasPosition.y, car.getSize().width, car.getSize().height, null);
    }

    public void setup() {
    	this.userCar.reset(getSize().width, getSize().height);
    	this.cars.clear();
    	for (int i = 0; i < NUMBER_OF_SLOW_CARS; i++) {
            cars.add(new SlowCar(getSize().width, getSize().height));
        }
    	for (int i = 0; i < NUMBER_OF_FAST_CARS; i++) {
            cars.add(new FastCar(getSize().width, getSize().height));
        }
        repaint();
    }

    public Point convertPosition(Point toConvert) {
        return new Point(toConvert.x, getSize().height - toConvert.y);
    }
}
