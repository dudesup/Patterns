package de.tum.cs.i1.pse.dispatcher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.tum.cs.i1.pse.utils.DispatcherMessage;
import de.tum.cs.i1.pse.utils.EDispatcherMessageType;
import de.tum.cs.i1.pse.utils.Location;

public class DispatcherMessageHandler implements Runnable {
	private Socket clientSocket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Dispatcher disptcher;
	
	
	public DispatcherMessageHandler (Dispatcher dispatcher, Socket clientSocket){
		System.out.println("DISPATCHER_THREAD: Thread creation begun");
		this.disptcher = dispatcher;
		this.clientSocket = clientSocket;
		try {
			inputStream = new ObjectInputStream (clientSocket.getInputStream());
			outputStream = new ObjectOutputStream (clientSocket.getOutputStream());
			System.out.println("DISPATCHER_THREAD: Input and Output streams initialized");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true){
			try {
				DispatcherMessage message = (DispatcherMessage) inputStream.readObject();
				System.out.println("DISPATCHER_THREAD: Message read");
				processMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
				try{
				inputStream.close();
				outputStream.close();
				clientSocket.close();
				System.out.println("DISPATCHER_THREAD: Connection closed.");

				break;
				} catch (Exception e1){
					System.out.println("DISPATCHER_THREAD: Error closing down socket connection");
				}
			} catch (ClassNotFoundException e) {	
				e.printStackTrace();
			}
		}
		
	}

	private void processMessage(DispatcherMessage message) {
		DispatcherMessage response = null;
		switch (message.getType()){
		case REGISTER:
			Location location = new Location(message.getLocation(), message.getPortNumber());
			disptcher.registerServer(message.getHostname(), location);
			response = new DispatcherMessage("dispatcher", "OK", 0, EDispatcherMessageType.RESPONSE);
			break;
		case QUERY:
			Location result = disptcher.getServerLocation(message.getHostname());
			if(result == null){
			response = new DispatcherMessage("dispetcher", "unknown host", 0, EDispatcherMessageType.RESPONSE);
			} else {
				response = new DispatcherMessage("dispetcher", result.getIpAddress(), result.getPortNumber(), EDispatcherMessageType.RESPONSE);
			} 
			break;
		default:
			response = new DispatcherMessage("dispatcher", "Unknown request type sent", 0,  EDispatcherMessageType.RESPONSE);
			break;
		}
		try {
			outputStream.writeObject(response);
		} catch (IOException e) {
			System.out.println("DISPETCHER_THREAD: Error processing message");
			e.printStackTrace();
		}
	}
	
	
}
