package de.tum.cs.i1.pse.dispatcher;

public class Driver {
	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.startGUI();
		dispatcher.startListening();
	}
}
