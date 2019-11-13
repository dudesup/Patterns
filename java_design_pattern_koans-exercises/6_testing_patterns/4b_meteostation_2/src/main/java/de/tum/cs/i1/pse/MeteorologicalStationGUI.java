package de.tum.cs.i1.pse;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.inject.Inject;

/**
 * MeteorologicalStationGUI is a Java Swing implementation of the application's
 * GUI
 */
public class MeteorologicalStationGUI implements IMeteorologicalStationGUI {
	private static final String DEGREE_CELCIUS = " \u2103";
	private JFrame frame;
	private JLabel temperatureLabel;
	private JTextField temperatureTextField;
	private JLabel windspeedLabel;
	private JTextField windspeedTextField;
	private JLabel humidityLabel;
	private JTextField humidityTextField;
	private JButton measureData;
	private JButton saveData;
	private JPanel panel;
	private GridLayout layout;

	// The controller is injected.
	@Inject
	private MeteorologicalStationController controller;

	public MeteorologicalStationGUI() {
		// Do not instantiate the controller.
		// controller = new MeteorologicalStationController(this);
		frame = new JFrame("MeteoStation");
		temperatureLabel = new JLabel("Temperature:");
		temperatureTextField = new JTextField();
		temperatureTextField.setEditable(false);
		windspeedLabel = new JLabel("Windspeed:");
		windspeedTextField = new JTextField();
		windspeedTextField.setEditable(false);
		humidityLabel = new JLabel("Humidity");
		humidityTextField = new JTextField();
		humidityTextField.setEditable(false);
		measureData = new JButton("Measure");
		measureData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.measure();
			}
		});
		saveData = new JButton("Save");
		saveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.save();
				} catch (IOException exception) {
					JOptionPane.showMessageDialog(frame, "Could not save to file", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		layout = new GridLayout(4, 2);
		panel = new JPanel(layout);
		panel.add(temperatureLabel);
		panel.add(temperatureTextField);
		panel.add(windspeedLabel);
		panel.add(windspeedTextField);
		panel.add(humidityLabel);
		panel.add(humidityTextField);
		panel.add(measureData);
		panel.add(saveData);
		frame.add(panel);
		frame.pack();
		frame.setLocation(100, 100);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void displayHumidity(int humidity) {
		humidityTextField.setText(humidity + " %");
	}

	public void displayTemperature(int temperature) {
		temperatureTextField.setText(temperature + DEGREE_CELCIUS);
	}

	public void displayWindspeed(int windspeed) {
		windspeedTextField.setText(windspeed + " kn");
	}

}
