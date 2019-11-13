package de.tum.cs.i1.pse;

public class Client {

	public static void main(String[] args) {
		String TALISKER = "Talisker";
		
		InventorySystem inventorySystem = new InventorySystem();
		
		inventorySystem.addToWarehouse(TALISKER, 50);
		
		boolean order1success = inventorySystem.processOrder(new OrderImpl(TALISKER, 50));
		boolean order2success = inventorySystem.processOrder(new OrderImpl(TALISKER, 51));
		
		System.out.println("Order1 succeeded? " + order1success + " - Order2 succeeded? " + order2success);
	}
	
}
