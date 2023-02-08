package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;
import com.simple.command.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트 환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMybatis {
	
	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;
	
	@Autowired
	TestMapper testMapper;
	
	@Test
	public void testCode01() {
		//마이바티스 핵심 객체
		System.out.println(sqlSessionFactory);
	}

//	@Test
//	public void testCode02() {
//		String time = testMapper.getTime();
//		System.out.println(time);
//	}
	
	//select 태그의 resultType
//	@Test
//	public void testCode03() {
//		ArrayList<ScoreVO> list = testMapper.getScore();
//		System.out.println(list.toString());
//	}
	
	//매개변수 - 단일값
//	@Test
//	public void testCode04() {
//		ScoreVO vo = testMapper.getOne(12);
//		System.out.println(vo.toString());
//	}
	
	//insert - 단일값
//	@Test
//	public void testCode05() {
//		int result = testMapper.insertOne("와우와우");
//		System.out.println(result);
//	}
	
	//insert - 다중값(setter명)
//	@Test
//	public void testcode06() {
//		ScoreVO vo = new ScoreVO(0, "테스트", "50", "100");
//		int result = testMapper.insertSetter(vo);
//		System.out.println(result);
//	}
	
	//insert - 다중값(map) : key값이 parameter가 된다.
	// map타입은 부득이할때만 사용한다.		
//	@Test
//	public void testCode07() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "와와우");
//		map.put("kor", "65");
//		map.put("eng", "85");
//		
//		int result = testMapper.insertMap(map);
//		System.out.println(result);
//	}
	
	//select - map타입의 반환
//	@Test
//	public void testCode08() {
//		Map<String,Object> map = testMapper.selectMap(3);
//		System.out.println(map.toString());
//	}
	
//	맴타입을 사용하는 것은 부득이한 걍우민 시
//	@Test
//	public void testCode09() {
//		ArrayList<Map<String, Object>> list = testMapper.selectMapList();
//		System.out.println(list.toString());
//	}
	
	//update구문
//	@Test
//	public void testCode10() {
//		ScoreVO vo = new ScoreVO(3, "또또치", "100", "100");
//		boolean result = testMapper.updateOne(vo);
//		System.out.println(result);
//	}
	
	@Test
	public void testCode11() {
		testMapper.insertFour("테스트", 100);
	}
}
