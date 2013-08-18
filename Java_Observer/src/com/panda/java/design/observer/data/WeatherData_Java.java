package com.panda.java.design.observer.data;

import java.util.Observable;


public class WeatherData_Java extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData_Java(){
		
	}
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float t,float h, float p) {
		this.temperature = t;
		this.humidity = h;
		this.pressure = p;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
	
	
}
