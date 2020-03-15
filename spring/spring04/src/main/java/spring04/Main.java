package spring04;

import org.springframework.context.support.GenericXmlApplicationContext;
public class Main {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Toy toy = ctx.getBean("toy",Toy.class);
		toy.battery.print();
	}

}
