package de.tum.cs.i1.pse;

import java.applet.Applet;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

import de.tum.cs.i1.pse.car.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			Car.DEFAULT_IMAGE = loadImage("SlowCar.gif");
			//TODO Set Images for Fast and Slow Cars
			Referee.MUSIC = Applet.newAudioClip(Main.class.getClassLoader().getResource("Music.au"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		Game bumperWindow = new Game();
		bumperWindow.pack();
		bumperWindow.setVisible(true);
	}
	
	private static Image loadImage(String name) throws Exception {
		URL url = Main.class.getClassLoader().getResource(name);
		MediaTracker m = new MediaTracker(new JPanel());
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		m.addImage(img, 0);
		m.waitForAll();
		return img;
	}
	
}

