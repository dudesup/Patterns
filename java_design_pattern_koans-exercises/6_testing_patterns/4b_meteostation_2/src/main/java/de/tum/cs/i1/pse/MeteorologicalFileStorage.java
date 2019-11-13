package de.tum.cs.i1.pse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MeteorologicalFileStorage can save the meteorological data to a text file
 */
public class MeteorologicalFileStorage {
	private int temperature;
	private int windspeed;
	private int humidity;

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setWindspeed(int windspeed) {
		this.windspeed = windspeed;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void save() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String datestring = formatter.format(new Date());
		BufferedWriter out = new BufferedWriter(new FileWriter(datestring + ".txt"));
		out.write(temperature + "\n");
		out.write(windspeed + "\n");
		out.write(humidity + "\n");
		out.close();
	}
}
