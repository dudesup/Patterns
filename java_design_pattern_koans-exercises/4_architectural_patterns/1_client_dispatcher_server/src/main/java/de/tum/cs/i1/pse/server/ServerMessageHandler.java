package de.tum.cs.i1.pse.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.tum.cs.i1.pse.utils.ChatMessage;

public class ServerMessageHandler implements Runnable{
	
	private String threadId;
	private Socket clientSocket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ChatMessage chatMessage;
	private ServerConnectionHandler serverConnectionHandler;
	private boolean connected = false;
	
	
	
	
	public ServerMessageHandler(Socket clientSocket, ServerConnectionHandler serverConnectionHandler, String threadId){
		this.threadId = threadId;
		if(clientSocket != null){
		this.clientSocket = clientSocket;
		this.serverConnectionHandler = serverConnectionHandler;
		try {
			inputStream = new ObjectInputStream(clientSocket.getInputStream());
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			connected = true;
			System.out.println("SERVER_THREAD: Input Output stream created");
		} catch (IOException e) {
			System.out.println("SERVER_THREAD: Unable to get input stream");
			e.printStackTrace();
		}
		}
	}

	public void run() {
		/**
		 * Handles incoming messages
		 **/
		while (connected) {
			try {
				chatMessage = (ChatMessage) inputStream.readObject();
				serverConnectionHandler.messageResponse(threadId, chatMessage.getMessage());

			} catch (IOException e) {
				System.out
						.println("SERVER_THREAD: Unable to read input stream");
				connected = false;
				try {
					clientSocket.close();
					break;
				} catch (IOException e1) {
					System.out.println("SERVER_THREAD: Input socket problem!");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("SERVER_THREAD: Class Message not foud!");
			}
		}
	}

	public void sendMessage(String message) {
		try {
			outputStream.writeObject(new ChatMessage(message));
		} catch (IOException e) {
			System.out.println("SERVER_THREAD: Unable to send object");
		}
	}
}
	
