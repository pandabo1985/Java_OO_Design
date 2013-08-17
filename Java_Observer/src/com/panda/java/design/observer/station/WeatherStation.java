package com.panda.java.design.observer.station;

import com.panda.java.design.observer.data.WeatherData;
import com.panda.java.design.observer.display.AllConditionsDisplay;
import com.panda.java.design.observer.display.CurrentConditionsDisplay;

public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(1.1f, 2.2f, 3.3f);
		
		AllConditionsDisplay allConditionsDisplay = new AllConditionsDisplay(weatherData);
		weatherData.setMeasurements(2.2f, 2.2f, 2.2f);
		
		
	}

}
