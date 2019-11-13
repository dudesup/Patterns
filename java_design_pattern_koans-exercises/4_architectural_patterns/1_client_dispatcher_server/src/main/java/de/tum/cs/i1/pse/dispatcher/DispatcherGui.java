package de.tum.cs.i1.pse.dispatcher;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DispatcherGui {

		private JFrame _frame;
		private JPanel _panel;
		private JTextArea _logText;
		
		
		public DispatcherGui(){   }



		public void initGUI() {
			_frame = new JFrame();
			_panel = new JPanel();
			_panel.setPreferredSize(new Dimension(300, 300));
			_panel.setLayout(new FlowLayout());
			
			_panel.add(new JPanel());
			
			
			
			_logText = new JTextArea(13,27);
			_logText.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(_logText); 
			_panel.add(scrollPane);
			
			_panel.add(new JPanel());
			
			
			_frame.getContentPane().add(_panel);
			_frame.pack();
			_frame.setTitle("Dispatcher logger");
			
			_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		public void setVisible() {
			_frame.setVisible(true);
		}
		
		
		
		public void displayMessage(String message){
			_logText.append(message + "\n");
		}

		public static void main(String[] args){
			new DispatcherGui();
		}
	}

