package de.tum.cs.i1.pse.client;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class ClientGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3737780863497510519L;

	private JLabel serverNameLabel;
	private JTextField serverNameText;
	
	
	private JLabel dispatcherIpAddressLabel;
	private JTextField dispatcherIpAddressText;
	
	private JLabel dispatcherPortNumberLabel;
	private JTextField dispatcherPortNumberText;

	
	
	private JButton connectButton;
	private JButton disconnectButton;
	private JButton sendButton;
	
	private JTextArea incomingMessagesTextArea;
	private JScrollPane incomingMessageScroll;
	
	private JTextArea clientMessageTextArea;
	private JScrollPane clientMessageScroll;

	
	private CellConstraints c;
	
	
	private JPanel createServerNamePanel(){
		
			JPanel serverNamePanel = new JPanel();
			FormLayout formLayout =
	                new FormLayout("10px, 180px, 150px", "5px, 20px, 5px, 20px, 5px, 20px");
			serverNamePanel.setLayout(formLayout);
			
			serverNamePanel.add(serverNameLabel, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.CENTER));
			serverNamePanel.add(serverNameText, c.xy(3,2, CellConstraints.FILL, CellConstraints.CENTER));
			
			serverNamePanel.add(dispatcherIpAddressLabel, c.xy(2, 4, CellConstraints.LEFT, CellConstraints.CENTER));
			serverNamePanel.add(dispatcherIpAddressText, c.xy(3,4, CellConstraints.FILL, CellConstraints.CENTER));
			
			serverNamePanel.add(dispatcherPortNumberLabel, c.xy(2, 6, CellConstraints.LEFT, CellConstraints.CENTER));
			serverNamePanel.add(dispatcherPortNumberText, c.xy(3,6, CellConstraints.FILL, CellConstraints.CENTER));
			
			return serverNamePanel;
	}
	
	private JPanel createConnectButtonPanel(){
		JPanel buttonPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("25px, 145px, 10px, 145px", "20px");
		buttonPanel.setLayout(formLayout);
		
		buttonPanel.add(connectButton, c.xy(2, 1,  CellConstraints.FILL, CellConstraints.CENTER));
		buttonPanel.add(disconnectButton, c.xy(4, 1, CellConstraints.FILL, CellConstraints.CENTER));

		
		
		return buttonPanel;
	}
	
	private JPanel createScrollableTextAreaPanel(){
		JPanel textAreaPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("10px, 330px, ", "20px, 200px, 10px, 70px");
		textAreaPanel.setLayout(formLayout);
		
		textAreaPanel.add(incomingMessageScroll, c.xy(2, 2, CellConstraints.FILL, CellConstraints.CENTER));
		textAreaPanel.add(clientMessageScroll, c.xy(2,4, CellConstraints.FILL, CellConstraints.CENTER));
				
		
		return textAreaPanel;
	}
	
	private JPanel createSendButtonPanel(){
		JPanel sendButtonPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("10px, 330px, ", "30px");
		sendButtonPanel.setLayout(formLayout);
		
		sendButtonPanel.add(sendButton, c.xy(2, 1, CellConstraints.FILL, CellConstraints.CENTER));
		
		return sendButtonPanel;
	}
	
	
	public ClientGUI() {
		super();
	}

	public void initGUI() {
		serverNameLabel = new JLabel("Server Name: ");
		serverNameText = new JTextField();
		
		dispatcherIpAddressLabel = new JLabel("Dispatcher IP address: ");
		dispatcherIpAddressText = new JTextField("127.0.0.1");
		dispatcherIpAddressText.setEditable(false);
		
		
		dispatcherPortNumberLabel = new JLabel("Dispetcher port number: ");
		dispatcherPortNumberText = new JTextField("50001");
		dispatcherPortNumberText.setEditable(false);
		
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		sendButton = new JButton("Send");
		
		incomingMessagesTextArea = new JTextArea(20, 20);
		incomingMessagesTextArea.setEditable(false);
		incomingMessageScroll = new JScrollPane(incomingMessagesTextArea);
		incomingMessageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		clientMessageTextArea = new JTextArea(4, 20);
		clientMessageScroll = new JScrollPane(clientMessageTextArea);
		clientMessageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		setSize(350, 480);
		setLayout(new FormLayout("500px", "80px, 20px, 320px, 30px"));
		c = new CellConstraints();
		add(createServerNamePanel(), c.xy(1, 1, CellConstraints.LEFT, CellConstraints.TOP));
		add(createConnectButtonPanel(), c.xy(1, 2, CellConstraints.LEFT, CellConstraints.TOP));
		add(createScrollableTextAreaPanel(), c.xy(1, 3, CellConstraints.LEFT, CellConstraints.TOP));
		add(createSendButtonPanel(), c.xy(1, 4, CellConstraints.LEFT, CellConstraints.TOP));
		
		setResizable(false);
		setName("Client GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setSendButtonActionListener(ActionListener listener){
		sendButton.addActionListener(listener);
	}
	
	
	public void setConnectButtonActionListener(ActionListener listener){
		connectButton.addActionListener(listener);
	}
	
	public void setDisconnectButtonActionListener(ActionListener listener){
		disconnectButton.addActionListener(listener);
	}
	
	public String getServerName(){
		return serverNameText.getText();
	}
	
	public String getClientMessage(){
		return clientMessageTextArea.getText();
	}
	
	public void printMessage(String message){
		incomingMessagesTextArea.append(message + "\n");
	}
	
	public void blankClientMessageArea(){
		clientMessageTextArea.setText("");
	}
	
	public void setFrameTitle(String name){
		setTitle(name);
	}
	
	public void setConnectButtonVisable(boolean value){
		connectButton.setEnabled(value);
		disconnectButton.setEnabled(!value);
	}
	
}
