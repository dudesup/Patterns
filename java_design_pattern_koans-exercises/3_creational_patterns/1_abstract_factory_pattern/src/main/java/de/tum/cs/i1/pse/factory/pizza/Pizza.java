package de.tum.cs.i1.pse.factory.pizza;

import de.tum.cs.i1.pse.factory.topings.pepperoni.Pepperoni;
import de.tum.cs.i1.pse.factory.topings.sauce.Sauce;
import de.tum.cs.i1.pse.factory.topings.veggies.Veggies;
import de.tum.cs.i1.pse.factory.toppings.cheese.Cheese;
import de.tum.cs.i1.pse.factory.toppings.clams.Clams;
import de.tum.cs.i1.pse.factory.toppings.dough.Dough;

public abstract class Pizza {
	String name;

	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	//TODO: Extend the Pizza class for the meat topping

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clam != null) {
			result.append(clam);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		//TODO: Extend the toString() method to deal with meat toppings
		return result.toString();
	}
}
