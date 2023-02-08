package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - service를 bean으로 생성하여 의존객체 자동주입(Autowired)
	
	//3nd - @Service로 빈을 생성하고(SocreServiceImpl) 
	//servlet-context.xml에 <context:component-scan> 사용 후
	//의존객체 자동주입
	@Autowired
	@Qualifier("이름")
	ScoreService service;
	
	
	//scoreRegist화면 출력
	@RequestMapping("/scoreRegist")
	public String registView() {
		return "service/scoreRegist";
	}
	
	//scoreRegist form요청
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(ScoreVO vo) {
		//System.out.println(vo.toString());
		service.regist(vo);
		return "service/scoreResult";
	}
	
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		//data조회
		ArrayList<ScoreVO> list = service.getList();
		model.addAttribute("list", list);
		return "service/scoreList";
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		service.delete(num);
		return "redirect:/service/scoreList";
	}

}
