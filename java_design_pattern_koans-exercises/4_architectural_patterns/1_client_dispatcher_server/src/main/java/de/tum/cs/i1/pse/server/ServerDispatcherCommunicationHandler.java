package de.tum.cs.i1.pse.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import de.tum.cs.i1.pse.utils.DispatcherMessage;
import de.tum.cs.i1.pse.utils.EDispatcherMessageType;

public class ServerDispatcherCommunicationHandler {
	private Socket dispatcherSocket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	
	public ServerDispatcherCommunicationHandler(){
		try {
			dispatcherSocket = new Socket("localhost", 50001);
			System.out.println("DISPATCHER_CLIENT: Socket created");
			outputStream = new ObjectOutputStream(dispatcherSocket.getOutputStream());
			System.out.println("DISPATCHER_CLIENT: Output stream created");
			inputStream = new ObjectInputStream(dispatcherSocket.getInputStream());
			System.out.println("DISPATCHER_CLIENT: Input stream created");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void register(String hostname, String location, int port){
		System.out.println("DISPATCHER_CLIENT: Registering...");
		DispatcherMessage message = new DispatcherMessage(hostname, location, port, EDispatcherMessageType.REGISTER);
		try {
			outputStream.writeObject(message);
			message =  (DispatcherMessage) inputStream.readObject();
			System.out.println(message.getLocation());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
