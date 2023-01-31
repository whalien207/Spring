package ex07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex02.Chef;
import ex02.DatabaseDev;
import ex02.Hotel;
import ex02.MemberDAO;

//xml을 대신해서 설정파일로 사용할 때
@Configuration
public class JavaConfig {
	
	//application-context.xml 을 java파일로
	
	//@Bean이 붙은 메서드를 스프링 컨테이너가 호출 시킴 (빈으로 생성)
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
//	생성자를 통한 주입
	@Bean
	public Hotel hotel() {
		return new Hotel(chef());
	}
	
	@Bean
	public DatabaseDev dev() {
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("주소");
		dev.setUid("아이디");
		dev.setUpw("비밀번호");
		return dev;
	}
	
	@Bean
	public MemberDAO dao() {
		MemberDAO dao = new MemberDAO();
		dao.setDatabaseDev(dev());
		return dao;
	}
	
	
	

}
