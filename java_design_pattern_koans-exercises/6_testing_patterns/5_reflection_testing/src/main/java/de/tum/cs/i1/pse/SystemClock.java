package de.tum.cs.i1.pse;

public class SystemClock implements Clock {
	@Override
	public long now() {
		return System.currentTimeMillis();
	}
	
}