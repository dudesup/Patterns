package de.tum.cs.i1.pse;

import java.util.Calendar;

public class MockClock implements Clock {
	private long time;
	
	public MockClock(int year, int month, int day, int hour, int minute, int second) {
		Calendar time = Calendar.getInstance();
		time.set(year, month, day, hour, minute, second);
		time.set(Calendar.MILLISECOND, 0);
		this.time = time.getTimeInMillis();
	}
	@Override
	public long now() {
		return time;
	}
	
}
