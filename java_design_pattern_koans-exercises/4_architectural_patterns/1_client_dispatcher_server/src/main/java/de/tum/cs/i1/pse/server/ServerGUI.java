package de.tum.cs.i1.pse.server;

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

public class ServerGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7212370052668488739L;
	private JLabel serverNameLabel;
	private JLabel dispatcherIpAddressLabel;
	private JLabel portNumberLabel;
	private JLabel dispatcherPortNumberLabel;
	
	private JTextField serverNameText;
	private JTextField dispatcherIpAddressText;
	private JTextField portNumberText;
	private JTextField dispatcherPortNumberText;
	
	private JButton	registerButton;
	
	private JTextArea textArea;
	private JScrollPane scroll;
	
	private CellConstraints c;
	
	
	private JPanel createServerPanel(){
		JPanel serverPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("10px, 180px, 150px", "5px, 20px, 5px, 20px, 5px, 20px, 5px, 20px");
		serverPanel.setLayout(formLayout);
		
		serverPanel.add(serverNameLabel, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.CENTER));
		serverPanel.add(serverNameText, c.xy(3,2, CellConstraints.FILL, CellConstraints.CENTER));
		
		
		serverPanel.add(portNumberLabel, c.xy(2, 4, CellConstraints.LEFT, CellConstraints.CENTER));
		serverPanel.add(portNumberText, c.xy(3, 4, CellConstraints.FILL, CellConstraints.CENTER));
				
		serverPanel.add(dispatcherIpAddressLabel, c.xy(2, 6, CellConstraints.LEFT, CellConstraints.CENTER));
		serverPanel.add(dispatcherIpAddressText, c.xy(3, 6, CellConstraints.FILL, CellConstraints.CENTER));
		
		serverPanel.add(dispatcherPortNumberLabel, c.xy(2, 8, CellConstraints.LEFT, CellConstraints.CENTER));
		serverPanel.add(dispatcherPortNumberText, c.xy(3, 8, CellConstraints.FILL, CellConstraints.CENTER));
		
		return serverPanel;
	}
	
	private JPanel createButtonPanel(){
		JPanel buttonPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("190px, 150px", "10px, 20px");
		buttonPanel.setLayout(formLayout);
		buttonPanel.add(registerButton, c.xy(2,2, CellConstraints.FILL, CellConstraints.CENTER));
		
		
		return buttonPanel;
	}
	
	private JPanel createTextAreaPanel(){
		JPanel textAreaPanel = new JPanel();
		FormLayout formLayout =
                new FormLayout("10px, 330px", "20px, 380px");
		textAreaPanel.setLayout(formLayout);
		textAreaPanel.add(scroll, c.xy(2, 2, CellConstraints.FILL, CellConstraints.CENTER));
		
		return textAreaPanel;
	}
	
	public ServerGUI(){
		super();
	}

	public void initGUI() {
		serverNameLabel = new JLabel("Server Name: ");
		serverNameText = new JTextField();
		
		portNumberLabel = new JLabel("Server port number: ");
		portNumberText = new JTextField();
		
		dispatcherIpAddressLabel = new JLabel("Dispatcher IP address: ");
		dispatcherIpAddressText = new JTextField("127.0.0.1");
		dispatcherIpAddressText.setEditable(false);
		
		dispatcherPortNumberLabel = new JLabel("Dispatcher port number: ");
		dispatcherPortNumberText = new JTextField("50001");
		dispatcherPortNumberText.setEditable(false);

		textArea = new JTextArea(40, 40);	
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		registerButton = new JButton("Register");

		setSize(350, 570);
		setLayout(new FormLayout("500px", "100px, 30px, 400px"));
		c = new CellConstraints();
		add(createServerPanel(), c.xy(1, 1, CellConstraints.LEFT, CellConstraints.TOP));
		add(createButtonPanel(), c.xy(1,2, CellConstraints.LEFT, CellConstraints.TOP));
		add(createTextAreaPanel(),  c.xy(1,3, CellConstraints.LEFT, CellConstraints.TOP));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setFrameTitle(String title){
		setTitle(title);
	}
	
	public void setRegisterButtonActionListener(ActionListener listener){
		registerButton.addActionListener(listener);
	}
	
	public String getServerName(){
		return serverNameText.getText();
	}
	
	public String getIpAddress(){
		return dispatcherIpAddressText.getText();
	}
	
	public String getPortNumber(){
		return portNumberText.getText();
	}
	
	public void displayMessage(String string){
		textArea.append(string + "\n");
	}
	
	public void setRegisterButtonVisability(boolean value){
		registerButton.setEnabled(value);
	}
	
	public static void main(String[] args) {
		new ServerGUI();
	}
}
