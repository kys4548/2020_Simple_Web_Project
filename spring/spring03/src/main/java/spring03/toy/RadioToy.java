package spring03.toy;

import spring03.battery.Battery;

public class RadioToy {
	private Battery battery;
	
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public void printBattery() {
		System.out.println(battery.getBatteryValue());
	}
}
