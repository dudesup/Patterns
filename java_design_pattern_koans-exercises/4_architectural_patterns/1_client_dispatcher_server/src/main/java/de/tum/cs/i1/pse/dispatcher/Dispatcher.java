package de.tum.cs.i1.pse.dispatcher;

import java.io.IOException;
import java.net.ServerSocket;

import de.tum.cs.i1.pse.utils.Location;

public class Dispatcher {

	private ServerSocket dispetcherSocket;
	private DispatcherGui logScreen;

	public Dispatcher() {    }

	public void startListening() {
		try {
			dispetcherSocket = new ServerSocket(50001);
			while (true) {
				DispatcherMessageHandler thread = new DispatcherMessageHandler(this, dispetcherSocket.accept());
				System.out.println("DISPATCHER: Connection accepted");
				new Thread(thread).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startGUI() {
		logScreen = new DispatcherGui();
		logScreen.initGUI();
		logScreen.setVisible();
		logScreen.displayMessage("Starting...ready!");
	}

	// TODO: Implement a mechanism that enables registration of servers based on
	// their name and their location (ip address and port number)
	public void registerServer(String name, Location location) {

	}

	// TODO: Implement a mechanism that enables fetching information about the
	// location of a registered server based on server name
	public Location getServerLocation(String name) {

		return null;
	}
	
	


	private void logRegisterServer(String name, Location location) {
		if(logScreen != null) {
			logScreen.displayMessage("Server '" + name + "' registered.");
			logScreen.displayMessage("IP address: " + location.getIpAddress());
			logScreen.displayMessage("Port number: " + location.getPortNumber());	
		}
	}
	

	private void logGetServerLocation(String name, Location location) {
		if(logScreen != null) {
			logScreen.displayMessage("Querying for: " + name);
			if(location == null) 
				logScreen.displayMessage("Server not found.");
			else 
				logScreen.displayMessage("Query successful.");
		}
	}

}
