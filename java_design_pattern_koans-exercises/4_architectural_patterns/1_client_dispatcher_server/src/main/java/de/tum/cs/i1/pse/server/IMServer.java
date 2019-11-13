package de.tum.cs.i1.pse.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMServer {
	private ServerConnectionHandler _serverElement;
	private ServerGUI _userInterface;
	
	
	public IMServer(){	}

	public void startGUI() {
		_userInterface = new ServerGUI();
		_userInterface.initGUI();
		_userInterface.setVisible(true);
		_userInterface.setRegisterButtonActionListener(new ServerOnRegister(this));
	}
	
	
	public void showMessage(String message){
		_userInterface.displayMessage(message);
	}
	
	public void setGuiFrameName(String name){
		_userInterface.setFrameTitle(name);
	}
	
	
	private class ServerOnRegister implements ActionListener{
		private IMServer _controller;
		
		public ServerOnRegister(IMServer controller){
			_controller = controller;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(_userInterface.getServerName() + " " + _userInterface.getIpAddress() + " " +  _userInterface.getPortNumber());
			_serverElement = new ServerConnectionHandler(_controller, Integer.parseInt(_userInterface.getPortNumber()));
			Thread t = new Thread(_serverElement);
			t.start();
			_userInterface.setRegisterButtonVisability(false);
			_serverElement.registerToDispatcher(_userInterface.getServerName(), _userInterface.getIpAddress(), Integer.parseInt(_userInterface.getPortNumber()));
		}
		
	}
}
