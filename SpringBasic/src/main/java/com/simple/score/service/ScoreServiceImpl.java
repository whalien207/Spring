package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.mapper.ScoreMapper;

//4개가 같은 의미로 아무거나 사용해도 좋다.
//@Component//@Repository//@Service//@Controller
@Service("이름") //빈의 이름명시
public class ScoreServiceImpl implements ScoreService{

	//	DAO를 mybatis로 바꾸어 사용할 수 있다. (mybatis는 dao대체)
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public void regist(ScoreVO vo) {
		scoreMapper.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}

	//	@Autowired
	//	@Qualifier("scoreDAO")
	//	private ScoreDAO scoreDAO;

	//	
	//	public void regist(ScoreVO vo) {
	//		scoreDAO.regist(vo);
	//		System.out.println(vo.toString()); 
	//	}
	//	
	//	@Override
	//	public ArrayList<ScoreVO> getList() {
	//		ArrayList<ScoreVO> list = scoreDAO.getList();
	//		return list;
	//	}
	//	
	//	@Override
	//	public void delete(int num) {
	//		scoreDAO.delete(num);
	//	}

}
