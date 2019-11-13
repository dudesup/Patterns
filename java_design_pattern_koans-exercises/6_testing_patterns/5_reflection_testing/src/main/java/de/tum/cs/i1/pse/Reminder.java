package de.tum.cs.i1.pse;

import java.util.Calendar;

public class Reminder implements Runnable {
	private Clock clock;
	private long reminderDate;
	private Runnable action;
	private boolean triggered;
	
	public Reminder(Calendar reminderDate, Runnable action) {
		this.reminderDate = reminderDate.getTimeInMillis();
		this.clock = new SystemClock();
		this.action = action;
	}

	@Override
	public void run() {
		
		
		while (true) {
			long currentTime = clock.now();
			if (reminderDate <= currentTime && !triggered) {
				action.run();
				triggered = true;
			}
		}
	}
	
}