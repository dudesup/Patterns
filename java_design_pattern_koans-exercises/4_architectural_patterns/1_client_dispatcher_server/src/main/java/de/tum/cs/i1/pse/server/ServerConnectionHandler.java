package de.tum.cs.i1.pse.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.HashMap;

public class ServerConnectionHandler implements Runnable{

	
	
	private ServerSocket serverSocket;
	private IMServer ircServer;
	private HashMap<String, ServerMessageHandler> serverMessageHandlers;

	
	public ServerConnectionHandler(IMServer ircServer, int portNumber){
			serverMessageHandlers = new HashMap<String, ServerMessageHandler>();
			this.ircServer = ircServer;
			try {
				serverSocket = new ServerSocket(portNumber);
				System.out.println("SERVER_ELEMENT: Socket created");
			
			} catch (IOException e) {
				System.out.println("SERVER_ELEMENT: Could not create socket on port 50000");
			}
	}
	

	public void printMessage(String message) {
		ircServer.showMessage(message);		
	}
	
	
	public void registerToDispatcher(String hostname, String ipAddress, int portNumber){
		ServerDispatcherCommunicationHandler dispetcherClient = new ServerDispatcherCommunicationHandler();
		dispetcherClient.register(hostname, ipAddress, portNumber);
	}

	
	public void messageResponse (String threadId, String message){
		printMessage("Thread " + threadId + ": " + message);
		Collection<String> threads = serverMessageHandlers.keySet();
		for(String thread : threads){
			if(thread.compareTo(threadId)!=0){
				serverMessageHandlers.get(thread).sendMessage(message);
			}
		}
	}
	
		
	public void run() {
		while(true){
			ServerMessageHandler serverThread;
			try {
				String threadId = String.valueOf((int) (Math.random()*100));
				while(serverMessageHandlers.containsKey(threadId)){
					threadId = String.valueOf((int) (Math.random()*100));
				}
				serverThread = new ServerMessageHandler(serverSocket.accept(), this, threadId);
				serverMessageHandlers.put(threadId, serverThread);
				System.out.println("SERVER_ELEMENT: Connection accepted");
				new Thread(serverThread).start();
				System.out.println("SERVER_ELEMENT: New thread started");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
	}
}
