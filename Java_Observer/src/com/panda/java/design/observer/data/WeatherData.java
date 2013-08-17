package com.panda.java.design.observer.data;

import java.util.ArrayList;
import com.panda.java.design.observer.inter.Observer;
import com.panda.java.design.observer.inter.Subject;

public class WeatherData implements Subject{
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData()
	{
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >=0) {
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyOberver() {
		for(int i = 0; i < observers.size(); i++){
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyOberver();
	}

	public void setMeasurements(float t,float h, float p) {
		this.temperature = t;
		this.humidity = h;
		this.pressure = p;
		measurementsChanged();
	}
	
}
