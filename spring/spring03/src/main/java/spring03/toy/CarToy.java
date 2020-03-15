package spring03.toy;

import spring03.battery.Battery;

public class CarToy {
	
	private Battery battery;
	
	CarToy(Battery battery) {
		this.battery = battery;
	}
	
	public void printBattery() {
		System.out.println(battery.getBatteryValue());
	}
}
