package de.tum.cs.i1.pse.factory.pizza;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.tum.cs.i1.pse.factory.pizzastore.ChicagoPizzaStore;
import de.tum.cs.i1.pse.factory.pizzastore.NYPizzaStore;
import de.tum.cs.i1.pse.factory.pizzastore.PizzaStore;
import de.tum.cs.i1.pse.factory.toppings.cheese.MozzarellaCheese;
import de.tum.cs.i1.pse.factory.toppings.cheese.ReggianoCheese;
import de.tum.cs.i1.pse.factory.toppings.meat.Chicken;
import de.tum.cs.i1.pse.factory.toppings.meat.Ham;

public class FunctionalTest {
	
	PizzaStore nyPizzaStore;
	PizzaStore chicagoPizzaStore;
	
	@Before
	public void setUp() {
		this.nyPizzaStore = new NYPizzaStore();
		this.chicagoPizzaStore = new ChicagoPizzaStore();
	}
	
	
	@Test(timeout = 100) 
	public void testMeatForMeatPizzaInNY() {
		assertTrue("People from New York expect their Pizza with Ham - That is not the case here.", nyPizzaStore.orderPizza("meat").meat instanceof Ham);
	}
	
	@Test(timeout = 100) 
	public void testMeatForMeatPizzaInChicago() {
		assertTrue("People from Chicago expect their Pizza with Chicken - That is not the case here.", chicagoPizzaStore.orderPizza("meat").meat instanceof Chicken); 
	}
	
	@Test(timeout = 100) 
	public void testCheeseForCheesePizzaINY() {
		assertTrue("People from New York expect their Pizza with ReggianoCheese - That is not the case here.", nyPizzaStore.orderPizza("cheese").cheese instanceof ReggianoCheese);
	}
	
	@Test(timeout = 100) 
	public void testCheeseForCheesePizzaInChicago() {
		assertTrue("People from Chicago expect their Pizza with MozzarellaCheese - That is not the case here.", chicagoPizzaStore.orderPizza("cheese").cheese instanceof MozzarellaCheese); 
	}
}
