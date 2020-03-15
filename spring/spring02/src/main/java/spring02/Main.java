package spring02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String args[]) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Work work = ctx.getBean("work", Work.class);
		work.work();
	}
}
