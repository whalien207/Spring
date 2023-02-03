package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

/////////////1
	//quiz01화면요청
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	//생일을 받아서 quiz01_ok로 이동
	@RequestMapping(value="/sendBirth", method=RequestMethod.POST)
	public String sendBirth(@ModelAttribute("birth") Quiz01VO vo) {
		System.out.println("QUIZ01 : "+vo.getYear()+vo.getMonth()+vo.getDay());
		return "quiz/quiz01_ok";
	}
	
/////////////2
	//quiz02화면요청
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
//	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(@ModelAttribute("join") Quiz02VO vo) {
//		return "quiz/quiz02_ok";
//	}
	
	//강사님 ver
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("name") String name,
						@ModelAttribute("email") String email) {
		return "quiz/quiz02_ok";
	}
	
/////////////////3
	//quiz03화면요청
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_c,
						Model model,
						RedirectAttributes ra) 
	{
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_c)) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}else {
			model.addAttribute("id", id);
			return "quiz/quiz03_ok";
		}
	}
}
