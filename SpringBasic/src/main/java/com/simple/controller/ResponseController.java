package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	//1.화면
	@RequestMapping("/ex01") //입력경로
	public String ex01() {
		return "response/ex01"; //출력경로
	}
	
	//result01요청 - model객체
	@RequestMapping("/result01")
	public String result01(Model model) {
		
		model.addAttribute("data", "홍길동"); //키, 값
		model.addAttribute("serverTime", new Date() );
		
		return "response/result01";
	}
	
	
	//result02요청 - ModelAndView객체
	@RequestMapping("/result02")
	public ModelAndView result02() {
		
		//뷰의 정보, data정보를 함께 저장할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "홍길동");
		mv.addObject("name", "이순신");
		mv.setViewName("response/result02");
		
		return mv;
	}
	
	//@ModelAttribute
	//단일값 받기
	@RequestMapping("/result03")
	public String result03(@ModelAttribute("num") String aaa) {
		System.out.println("화면데이터 : "+aaa);
		return "response/result03";
	}
	
	//객체 값 받기
	@RequestMapping("/result04")
	public String result04(@ModelAttribute("article") ReqVO vo) {
		System.out.println("화면데이터 : "+ vo.toString());
		return "response/result04";
	}
	
	/*
	 * redirect이동과 redirectAttribute
	 * 스프링에서 redirect는 다시 컨트롤러를 태우는 요청이다.
	 * redirectAttribute는 redirect시에 1회성 데이터를 저장할 수 있다.
	 */
	
	//화면요청
	@RequestMapping("/redirect_login")
	public String loginView() {
		return "response/redirect_login";
	}
	
	//로그인요청
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes ra ) 
	{
		
		if(id.equals(pw)) {
			//로그인 성공 가정 --> home화면으로 이동

			//1회성 데이터
			ra.addFlashAttribute("msg", "어서와");

			//다시 home 컨트롤러를 태워서 / 경로로 보내준다.
			//redirect의 특징 : model을 사용할 수는 없다. 데이터를 다 버리고 이동
			return "redirect:/";
		} else { 
			//실패 케이스로 가정 --> 다시 로그인 화면으로 이동
			//redirect:/절대경로 사용
			ra.addFlashAttribute("msg", "로그인실패");
			return "redirect:/response/redirect_login";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
