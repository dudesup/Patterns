package edu.tum.cs.i1.pse;

public interface ConnectionInterface {
	
	public void open(String address, int port);
	
	public void close();
	

}
