package de.tum.cs.i1.pse;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Client {

	JFrame frame;
	JButton btnUp;
	JButton btnDown;
	JPanel lightPanel;
	JPanel contentPane;

	Light lamp;
	Switch lightSwitch;

	public void init() {
		lightPanel = new JPanel();
		lightPanel.setOpaque(true);
		lamp = new Light(lightPanel);

		lightSwitch = new Switch(new FlipUpCommand(lamp), new FlipDownCommand(lamp));

		this.frame = new JFrame("");

		this.contentPane = new JPanel();
		GridLayout layout = new GridLayout(3, 1);
		contentPane.setLayout(layout);
		btnUp = new JButton("Up");
		contentPane.add(btnUp);
		btnDown = new JButton("Down");
		contentPane.add(btnDown);
		contentPane.add(lightPanel);

		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipUp();
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipDown();
			}
		});

		this.frame.add(contentPane);

		this.frame.setVisible(true);
		this.frame.setSize(300, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		Client test = new Client();
		test.init();
	}

}
