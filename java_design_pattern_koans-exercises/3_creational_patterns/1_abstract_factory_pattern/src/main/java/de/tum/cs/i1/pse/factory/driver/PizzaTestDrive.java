package de.tum.cs.i1.pse.factory.driver;

import de.tum.cs.i1.pse.factory.pizza.Pizza;
import de.tum.cs.i1.pse.factory.pizzastore.ChicagoPizzaStore;
import de.tum.cs.i1.pse.factory.pizzastore.NYPizzaStore;
import de.tum.cs.i1.pse.factory.pizzastore.PizzaStore;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
 
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza + "\n");
		
		pizza = nyStore.orderPizza("meat");
		System.out.println("Ethan ordered a " + pizza + "\n");
		
		pizza = chicagoStore.orderPizza("meat");
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
