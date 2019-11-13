package de.tum.cs.i1.pse;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class ReminderTest {
	
	static class ReminderAction implements Runnable {
		private boolean triggered;
		
		public void run() {
			triggered = true;
		}
		
		public boolean hasTriggered() {
			return triggered;
		}
	}
    
	@Test
	public void testReminder() throws Exception {
		ReminderManager reminderManager = new ReminderManager();
		ReminderAction action = new ReminderAction();
		Reminder reminder = reminderManager.addReminder(2016, Calendar.JANUARY, 13, 13, 0, 0, action);
		setClock(reminder, 2016, Calendar.JANUARY, 13, 13, 10 , 0);
		Thread.sleep(2000);
		Assert.assertEquals(true, action.hasTriggered());
	}
    
	private void setClock(Reminder reminder, int year, int month, int day, int hour, int minute, int second) throws Exception {
		//TODO: Use reflection to set a MockClock for the Reminder
	}
    
}
