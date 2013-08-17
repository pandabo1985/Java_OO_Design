package com.panda.java.design.observer.inter;

public interface Subject {
	public  void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyOberver();
	
}
