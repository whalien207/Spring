package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

public interface TestMapper {
	
	public String getTime(); //1
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public int insertOne(String name); //단일값
	public int insertSetter(ScoreVO vo); //다중값
	public int insertMap(Map<String, String> map); // 다중값
	
	public Map<String, Object> selectMap(int num);
	//맵을 통한 다중행 조회
	public ArrayList<Map<String, Object>> selectMapList();
	
	public boolean updateOne(ScoreVO vo); //update
	
//	public void insertFour(String name, int kor); 이렇게 사용하면 에러가 난다.
	public void insertFour(@Param("a") String name, @Param("b") int kor);

}
