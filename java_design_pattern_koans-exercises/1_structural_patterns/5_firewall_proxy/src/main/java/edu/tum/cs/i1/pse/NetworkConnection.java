package edu.tum.cs.i1.pse;

public class NetworkConnection implements ConnectionInterface {
	private String address;
	private int port;
	private boolean connected;
	

	@Override
	public void open(String address, int port) {
		if(!this.isConnected()){
				openConnection();
				this.address = address;
				this.port = port;
			}else{
				System.out.println("Already connected!");
			}
	}
	
	@Override
	public void close() {
		if(!isConnected()){
			System.out.println("You are not connected yet!");
		}else{
			closeConnection();
		}
	}
	
	
	private void openConnection(){
		this.connected = true;
		System.out.println("Connected to: " + address + " on port: " + port + ".");
	}
	
	private void closeConnection(){
		this.connected = false;
		this.address = "";
		this.port = -1;
		System.out.println("Disconnecting from: " + address + " on port: " + port + ".");
	}


	public String getAddress() {
		return address;
	}


	public int getPort() {
		return port;
	}
	
	public boolean isConnected(){
		return this.connected;
	}
	
}
