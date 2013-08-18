package com.panda.java.design.observer.station;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	private void go() {
		frame = new JFrame();
		JButton button = new JButton("Should I do it ?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
	}

	class AngelListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Don't do it, you might regret it!");
			
		}};
	
	class DevilListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Come on, do it!");
		}}
	
}
