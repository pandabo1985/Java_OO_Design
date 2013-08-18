package com.panda.java.design.observer.display;


import java.util.Observable;
import java.util.Observer;

import com.panda.java.design.observer.data.WeatherData_Java;
import com.panda.java.design.observer.inter.DisplayElement;


public class AllConditionsDisplay_Java  implements Observer, DisplayElement{
	private float temprature;
	private float humity;
	private float pressure;
	private Observable weatherData;
	
	public AllConditionsDisplay_Java(Observable weatherData){
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName() + "  current stations: temprature = "+temprature + " humity = "+humity + " pressure = "+ pressure);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData_Java) {
			WeatherData_Java weatherData_Java = (WeatherData_Java) o;
			this.humity = weatherData_Java.getHumidity();
			this.pressure = weatherData_Java.getPressure();
			this.temprature = weatherData_Java.getTemperature();
			display();
		}
		
	}



}
