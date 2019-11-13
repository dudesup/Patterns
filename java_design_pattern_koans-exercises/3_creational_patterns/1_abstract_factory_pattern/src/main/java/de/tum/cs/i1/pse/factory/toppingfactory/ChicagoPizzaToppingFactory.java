package de.tum.cs.i1.pse.factory.toppingfactory;

import de.tum.cs.i1.pse.factory.topings.pepperoni.Pepperoni;
import de.tum.cs.i1.pse.factory.topings.pepperoni.SlicedPepperoni;
import de.tum.cs.i1.pse.factory.topings.sauce.PlumTomatoSauce;
import de.tum.cs.i1.pse.factory.topings.sauce.Sauce;
import de.tum.cs.i1.pse.factory.topings.veggies.BlackOlives;
import de.tum.cs.i1.pse.factory.topings.veggies.Eggplant;
import de.tum.cs.i1.pse.factory.topings.veggies.Spinach;
import de.tum.cs.i1.pse.factory.topings.veggies.Veggies;
import de.tum.cs.i1.pse.factory.toppings.cheese.Cheese;
import de.tum.cs.i1.pse.factory.toppings.cheese.MozzarellaCheese;
import de.tum.cs.i1.pse.factory.toppings.clams.Clams;
import de.tum.cs.i1.pse.factory.toppings.clams.FrozenClams;
import de.tum.cs.i1.pse.factory.toppings.dough.Dough;
import de.tum.cs.i1.pse.factory.toppings.dough.ThickCrustDough;

public class ChicagoPizzaToppingFactory 
implements PizzaToppingFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), new Spinach(), new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}

}
