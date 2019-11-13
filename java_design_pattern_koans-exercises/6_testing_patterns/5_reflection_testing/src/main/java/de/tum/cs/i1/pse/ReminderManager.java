package de.tum.cs.i1.pse;

import java.util.Calendar;

public class ReminderManager {

	public Reminder addReminder(int year, int month, int day, int hourOfDay, int minute, int second, Runnable action) {
		Calendar date = Calendar.getInstance();
		date.set(year, month, day, hourOfDay, minute, second);
		date.set(Calendar.MILLISECOND, 0);
		Reminder reminder = new Reminder(date, action);
		Thread reminderThread = new Thread(reminder);
		reminderThread.start();
		return reminder;
	}

}
