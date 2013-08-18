package com.panda.java.design.observer.station;

import com.panda.java.design.observer.data.WeatherData;
import com.panda.java.design.observer.data.WeatherData_Java;
import com.panda.java.design.observer.display.AllConditionsDisplay;
import com.panda.java.design.observer.display.AllConditionsDisplay_Java;
import com.panda.java.design.observer.display.CurrentConditionsDisplay;

public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//custom java observer
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(1.1f, 2.2f, 3.3f);
		
		AllConditionsDisplay allConditionsDisplay = new AllConditionsDisplay(weatherData);
		weatherData.setMeasurements(2.2f, 2.2f, 2.2f);
		
		//observer in java sdk
		WeatherData_Java weatherData_Java = new WeatherData_Java();
		AllConditionsDisplay_Java allConditionsDisplay_Java = new AllConditionsDisplay_Java(weatherData_Java);
		weatherData_Java.setMeasurements(3.3f, 3.3f, 44.0f);
		
	}

}
