package de.tum.cs.i1.pse.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import de.tum.cs.i1.pse.utils.Location;

public class IMClient {
	private ClientGUI userInterface;
	private Socket clientSocket;
	private ClientMessageHandler clientMessageHandler;
	private Location serverLocation;
	private ClientDispatcherCommunicationHandler clientDispatcherCommunicationHandler;

	public IMClient() {
		clientDispatcherCommunicationHandler = new ClientDispatcherCommunicationHandler();
	}

	public void startGUI() {
		userInterface = new ClientGUI();
		userInterface.initGUI();
		userInterface.setVisible(true);
		
		userInterface.setSendButtonActionListener(new OnSend());
		userInterface.setConnectButtonActionListener(new OnLogin());
		userInterface.setDisconnectButtonActionListener(new OnDisconnect());
	}

	public void displayMessage(String message) {
		userInterface.printMessage(message);

	}

	public void setGuiFrameName(String name) {
		userInterface.setFrameTitle(name);
	}

	private class OnSend implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			clientMessageHandler.sendMessage("Client> " + userInterface.getClientMessage());
			userInterface.printMessage("Client> " + userInterface.getClientMessage());

			userInterface.blankClientMessageArea();
		}
	}

	private class OnLogin implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			connect(userInterface.getServerName());
			userInterface.setConnectButtonVisable(false);
		}
	}

	public class OnDisconnect implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			disconnect();
			userInterface.setConnectButtonVisable(true);
		}

	}

	// TODO: Before connecting to the server, a client has to 'ask' the
	// dispatcher for the ip address and the port number of the server that it
	// wants to connect to. The name of the server should be provided by the
	// user (via UI)

	public void connect(String serverName) {

		try {
			if (serverLocation != null) {
				if (!serverLocation.getIpAddress().equalsIgnoreCase("unknown host")) {
					System.out.println("CLIENT_ELEMENT: Server not found. Shutting down!");
					System.out.println("Ip address: " + serverLocation.getIpAddress() + "Port number: "
							+ serverLocation.getPortNumber());
					clientSocket = new Socket(serverLocation.getIpAddress(), serverLocation.getPortNumber());
					System.out.println("CLIENT_ELEMENT: Socket created successfuly");
					clientMessageHandler = new ClientMessageHandler(clientSocket, this);
					System.out.println("CLIENT_ELEMENT: Client thread created");
					new Thread(clientMessageHandler).start();
					System.out.println("CLIENT_ELEMENT: Client thread started");
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("CLIENT_ELEMENT: Unknown host: localhost");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("CLIENT_ELEMENT: Problem connecting to socket");
			e.printStackTrace();
		}

	}

	public void disconnect() {
		clientMessageHandler.dropConnection();
	}

}
