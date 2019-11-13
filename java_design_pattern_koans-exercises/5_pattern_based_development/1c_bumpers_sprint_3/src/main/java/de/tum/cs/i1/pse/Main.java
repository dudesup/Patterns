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
			SlowCar.DEFAULT_SLOW_CAR_IMAGE = loadImage("Kaefer.gif");
			FastCar.DEFAULT_FAST_CAR_IMAGE = loadImage("SLK.gif");
			UserCar.DEFAULT_IMAGE = loadImage("A-Klasse.gif");
			//SpeedController.UP = loadImage("up.gif");
			//SpeedController.DOWN = loadImage("down.gif");
			Referee.MUSIC = Applet.newAudioClip(Main.class.getClassLoader().getResource("Music.au"));
			Referee.BANG = Applet.newAudioClip(Main.class.getClassLoader().getResource("Bang.au"));
			
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

