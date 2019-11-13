package de.tum.cs.i1.pse.factory.toppingfactory;

import de.tum.cs.i1.pse.factory.topings.pepperoni.Pepperoni;
import de.tum.cs.i1.pse.factory.topings.pepperoni.SlicedPepperoni;
import de.tum.cs.i1.pse.factory.topings.sauce.MarinaraSauce;
import de.tum.cs.i1.pse.factory.topings.sauce.Sauce;
import de.tum.cs.i1.pse.factory.topings.veggies.Garlic;
import de.tum.cs.i1.pse.factory.topings.veggies.Mushroom;
import de.tum.cs.i1.pse.factory.topings.veggies.Onion;
import de.tum.cs.i1.pse.factory.topings.veggies.RedPepper;
import de.tum.cs.i1.pse.factory.topings.veggies.Veggies;
import de.tum.cs.i1.pse.factory.toppings.cheese.Cheese;
import de.tum.cs.i1.pse.factory.toppings.cheese.ReggianoCheese;
import de.tum.cs.i1.pse.factory.toppings.clams.Clams;
import de.tum.cs.i1.pse.factory.toppings.clams.FreshClams;
import de.tum.cs.i1.pse.factory.toppings.dough.Dough;
import de.tum.cs.i1.pse.factory.toppings.dough.ThinCrustDough;

public class NYPizzaToppingFactory implements PizzaToppingFactory {

	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}

}
