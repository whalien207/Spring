package ex05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		 GenericXmlApplicationContext ctx = 
				 new GenericXmlApplicationContext("autowired-context.xml");
		 
		 Printer p = ctx.getBean(Printer.class);
		 System.out.println(p.getDoc().data);
	}

}
