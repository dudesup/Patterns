package edu.tum.cs.pse.lightswitch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("serial")
public class Driver extends java.applet.Applet {

	Light lamp;
	LightSwitchCommand switchUp;
	LightSwitchCommand switchDown;
	Switch lightSwitch;
	Button btnUp;
	Button btnDown;
	Label lightLabel;

	public void init() {
		lightLabel = new Label();
		lamp = new Light(lightLabel);
		switchUp = new FlipUpCommand(lamp);
		switchDown = new FlipDownCommand(lamp);
		lightSwitch = new Switch(switchUp, switchDown);

		// setBackground(Color.yellow);
		// setLayout(new FlowLayout());
		// Button pushButton = new Button("press me");
		// add(pushButton);

		setLayout(new GridLayout(3, 2)); // Use Grid Layout

		btnUp = new Button();
		btnDown = new Button();

		btnUp.setLabel("switch up");
		btnDown.setLabel("switch down");

		add(btnUp);
		add(btnDown);

		add(lightLabel);

		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipUp();
			}
		});
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipDown();
			}
		});



		//
		// Dear maintainer:
		//
		// Once you are done trying to 'optimize' this routine,
		// and have realized what a terrible mistake that was,
		// please increment the following counter as a warning
		// to the next guy:
		//
		// total_hours_wasted_here = 42
		//

		//		// Get the internet address of the specified host
		//        InetAddress address = InetAddress.getByName(args[0]);
		//        // Convert the message to an array of bytes
		//        int msglen = args[1].length();
		//        byte[] message = new byte[msglen];
		//        args[1].getBytes(0, msglen, message, 0);
		//        // Initilize the packet with data and address
		//        DatagramPacket packet = new DatagramPacket(message, msglen,
		//                               address, port);
		//        // Create a socket, and send the packet through it.
		//        DatagramSocket socket = new DatagramSocket();
		//        socket.send(packet);
	}

	private String fetch(String address) throws MalformedURLException,
			IOException {
		URL url = new URL(address);
		return (String) url.getContent();
	}

	private Image fetchimage(String address, Component c)
			throws MalformedURLException, IOException {
		URL url = new URL(address);
		return c.createImage((java.awt.image.ImageProducer) url.getContent());
	}

	public void paint() {
	}

	public void start() {
	}

	public void stop() {
	}

	public void destroy() {
		lamp = null;
		switchUp = null;
		switchDown = null;
		lightSwitch = null;
		btnUp = null;
		btnDown = null;
		lightLabel = null;
	}
	
    private String function_key_name(int key) {
        switch(key) {
            case Event.HOME: return "Home";
            case Event.END: return "End";
            case Event.PGUP: return "Page Up";
            case Event.PGDN: return "Page Down";
            case Event.UP: return "Up Arrow";
            case Event.DOWN: return "Down Arrow";
            case Event.LEFT: return "Left Arrow";
            case Event.RIGHT: return "Right Arrow";
            case Event.F1: return "F1";    case Event.F2: return "F2";
            case Event.F3: return "F3";    case Event.F4: return "F4";
            case Event.F5: return "F5";    case Event.F6: return "F6";
            case Event.F7: return "F7";    case Event.F8: return "F8";
            case Event.F9: return "F9";    case Event.F10: return "F10";
            case Event.F11: return "F11";    case Event.F12: return "F12";
        }
        return "Unknown Function Key";
    }
	
    private static void printThreadInfo(PrintStream out, Thread t, 
                          String indent) {
        if (t == null) return;
        out.println(indent + "Thread: " + t.getName() +
                "  Priority: " + t.getPriority() +
                (t.isDaemon()?" Daemon":"") +
                (t.isAlive()?"":" Not Alive"));
    }

}
