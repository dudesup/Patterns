package de.tum.cs.i1.pse;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class Main {
	
	static class ReminderAction implements Runnable {
		@Override
		public void run() {
			JOptionPane.showMessageDialog(null, "You wanted to do something");	
		}
		
	}

	public static void main(String[] args) {
		ReminderManager reminderManager = new ReminderManager();
		Runnable action = new ReminderAction();
		reminderManager.addReminder(2014, Calendar.DECEMBER, 8, 22, 25, 0, action);
	}
	
}
