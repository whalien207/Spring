package ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

import ex05.Printer;

public class MainClass {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				 new GenericXmlApplicationContext("autowired-context.xml");
		 
		Controller c = ctx.getBean(Controller.class);
		c.hello();
		
	}

}
