package de.tum.cs.i1.pse.factory.toppingfactory;

import de.tum.cs.i1.pse.factory.topings.pepperoni.Pepperoni;
import de.tum.cs.i1.pse.factory.topings.sauce.Sauce;
import de.tum.cs.i1.pse.factory.topings.veggies.Veggies;
import de.tum.cs.i1.pse.factory.toppings.cheese.Cheese;
import de.tum.cs.i1.pse.factory.toppings.clams.Clams;
import de.tum.cs.i1.pse.factory.toppings.dough.Dough;

public interface PizzaToppingFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
	//TODO: Extend the PizzaToppingFactory with a method to create a meat topping
}
