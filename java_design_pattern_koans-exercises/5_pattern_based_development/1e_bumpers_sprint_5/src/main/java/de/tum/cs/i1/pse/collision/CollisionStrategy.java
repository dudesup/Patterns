package de.tum.cs.i1.pse.collision;

import java.util.ArrayList;

import de.tum.cs.i1.pse.car.Car;

public abstract class CollisionStrategy {

    private static ArrayList<Object> STRATEGIES = null;

    public abstract Car detectCollision(Car userCar, Car roboCar);

    public abstract String getName();

    public String toString() {
        return getName();
    }

    public static ArrayList<Object> getSTRATEGIES() {
        if (STRATEGIES == null) {
        	STRATEGIES = new ArrayList<Object>();
        	STRATEGIES.add(new DefaultCollision());
        }
        return STRATEGIES;
    }
}