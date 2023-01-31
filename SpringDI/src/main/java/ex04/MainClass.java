package ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

import ex02.DatabaseDev;
import ex02.MemberDAO;

public class MainClass {

	public static void main(String[] args) {
		
		//Car, Airplane 빈을 생성하고, 의존성 주입
		//각 객체 안에 있는 배터리를 자바클래스에서 출력.
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("q-context.xml");
		
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		
		Airplane air = ctx.getBean("airplane", Airplane.class);
		air.getBattery().energy();

		
		
	}
}
