package com.panda.java.design.observer.display;

import com.panda.java.design.observer.data.WeatherData;
import com.panda.java.design.observer.inter.DisplayElement;
import com.panda.java.design.observer.inter.Observer;

public class AllConditionsDisplay  implements Observer, DisplayElement{
	private float temprature;
	private float humity;
	private float pressure;
	private WeatherData weatherData;
	
	public AllConditionsDisplay(WeatherData weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName() + "  current stations: temprature = "+temprature + " humity = "+humity + " pressure = "+ pressure);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temprature = temp;
		this.humity = humidity;
		this.pressure = pressure;
		display();
	}

}
