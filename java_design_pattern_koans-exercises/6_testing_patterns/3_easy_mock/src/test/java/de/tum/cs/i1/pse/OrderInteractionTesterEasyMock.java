package de.tum.cs.i1.pse;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Test;

import de.tum.cs.i1.pse.Order;
import de.tum.cs.i1.pse.OrderImpl;
import de.tum.cs.i1.pse.Warehouse;

public class OrderInteractionTesterEasyMock {
	private static String TALISKER = "Talisker";
	private Warehouse warehouseMock;
	
	@Test
	public void fillingRemovesInventoryIfInStock() {
		//SUT
		Order order = new OrderImpl(TALISKER, 50);
		
		//Create a mock object for the collaborator
		warehouseMock = createMock(Warehouse.class);
		
		//Specify behavior of the collaborator
		expect(warehouseMock.hasInventory(TALISKER, 50)).andReturn(true);
		warehouseMock.remove(TALISKER, 50);
		
		//Get ready for Replay
		replay(warehouseMock);
		
		//Execute SUT
		order.fillOut(warehouseMock);
		assertTrue(order.isFilled());
		
		//Verify that the observed behavior is equal to the specified behavior
		verify(warehouseMock);
	}
	
	// TODO: Add a fillingDoesNotRemoveIfNotEnoughInStock() test method testing the interaction of Order with its collaborator Warehouse.
	// Create a Mock Object for the warehouse. In case the warehouse does not have enough items in 
	// stock, fillOut(Warehouse) should return false.

}
