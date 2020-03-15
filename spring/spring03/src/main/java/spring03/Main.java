package spring03;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring03.toy.CarToy;
import spring03.toy.RadioToy;

public class Main {
	
	public static void main(String args[]) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		CarToy carToy = ctx.getBean("carToy", CarToy.class); 
		RadioToy radioToy = ctx.getBean("radioToy",RadioToy.class); 
		carToy.printBattery();
		radioToy.printBattery();
		
	}
}
