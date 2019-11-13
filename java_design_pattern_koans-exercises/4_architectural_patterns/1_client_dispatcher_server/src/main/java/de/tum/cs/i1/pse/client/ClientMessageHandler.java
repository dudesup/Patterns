package de.tum.cs.i1.pse.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.tum.cs.i1.pse.utils.ChatMessage;

public class ClientMessageHandler implements Runnable{
	private Socket clientSocket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private IMClient ircClient;
	private ChatMessage message;
	private boolean connected = false;
	
	public ClientMessageHandler(Socket clientSocket, IMClient ircClient){
		System.out.println("CLIENT_THREAD: Created");
		this.clientSocket = clientSocket;
		this.ircClient = ircClient;
		System.out.println("CLIENT_THREAD: Initialized");
		try {
			System.out.println("CLIENT_THREAD: TRY block");
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			System.out.println("CLIENT_THREAD: Input Output streams created");
			inputStream = new ObjectInputStream(clientSocket.getInputStream());
			System.out.println("CLIENT_THREAD: INPUT created");
			connected = true;
		} catch (Exception e) {
			System.out.println("CLIENT_THREAD: Unknown output stream");
		}
		
	}

	public void run() {
		System.out.println("CLIENT_THREAD: Started");
		while(connected){
			try {
				message = (ChatMessage) inputStream.readObject();
				ircClient.displayMessage(message.getMessage());
			} catch (IOException e) {
				System.out.println("CLIENT_THREAD: Error reading object from input stream");
				dropConnection();
				connected = false;
			} catch (ClassNotFoundException e) {
				System.out.println("CLIENT_THREAD: Casting class not found");
			}
		}
		
	}
	public void sendMessage(String message) {
		try {
			outputStream.writeObject(new ChatMessage(message));
		} catch (IOException e) {
			System.out.println("CLIENT_THREAD: Error sending message");
		}
		
	}
	
	public void dropConnection(){
		try {
			outputStream.close();
			inputStream.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("CLIENT_THREAD: Unable to drop connection");
		}
		
	}

}
