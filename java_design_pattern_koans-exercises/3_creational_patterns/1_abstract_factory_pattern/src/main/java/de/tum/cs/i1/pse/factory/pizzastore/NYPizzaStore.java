package de.tum.cs.i1.pse.factory.pizzastore;

import de.tum.cs.i1.pse.factory.pizza.CheesePizza;
import de.tum.cs.i1.pse.factory.pizza.ClamPizza;
import de.tum.cs.i1.pse.factory.pizza.PepperoniPizza;
import de.tum.cs.i1.pse.factory.pizza.Pizza;
import de.tum.cs.i1.pse.factory.pizza.VeggiePizza;
import de.tum.cs.i1.pse.factory.toppingfactory.NYPizzaToppingFactory;
import de.tum.cs.i1.pse.factory.toppingfactory.PizzaToppingFactory;

public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaToppingFactory ingredientFactory = 
			new NYPizzaToppingFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		//TODO: Create pizzas of type meat here and give them an appropriate name
		return pizza;
	}
}
