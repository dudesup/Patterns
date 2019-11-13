package de.tum.cs.i1.pse;

import static org.junit.Assert.*;

import org.junit.Test;

import de.tum.cs.i1.pse.dispatcher.Dispatcher;
import de.tum.cs.i1.pse.server.IMServer;
import de.tum.cs.i1.pse.server.ServerConnectionHandler;
import de.tum.cs.i1.pse.utils.Location;

public class FunctionalTest {
	
	@Test
	public void testServerRegistration() throws InterruptedException {
		final Dispatcher dispatcher = new Dispatcher();
		new Thread(new Runnable() {
			@Override
			public void run() {
				dispatcher.startListening();
			}
		}).start();

		ServerConnectionHandler serverConnectionHandler = new ServerConnectionHandler(new IMServer(), 1337);
		String serverName = "dummy_server";
		String ipAddress = "1.1.1.1";
		serverConnectionHandler.registerToDispatcher(serverName, ipAddress, 1337);
		Thread.sleep(2000);
		Location serverLocation = dispatcher.getServerLocation(serverName);
		assertTrue("Registring server to dispatcher failed.", serverLocation.getIpAddress().equals(ipAddress));
	}

}
