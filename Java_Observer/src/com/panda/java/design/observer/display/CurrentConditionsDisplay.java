package com.panda.java.design.observer.display;

import com.panda.java.design.observer.data.WeatherData;
import com.panda.java.design.observer.inter.DisplayElement;
import com.panda.java.design.observer.inter.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{

	private float temperature;
	private float humidity;
	private WeatherData weatherData;
	
	public CurrentConditionsDisplay(WeatherData weatherData){
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	
	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName() + "  current conditions: temperature = "+temperature +" humidity = "+humidity);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

}
