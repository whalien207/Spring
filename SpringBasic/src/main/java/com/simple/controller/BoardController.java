package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	BoardService service;
	
	@RequestMapping("/boardRegister")
	public String registView() {
		return "service/boardRegister";
	}
	
	@RequestMapping(value="/boardRegist", method=RequestMethod.POST)
	public String regist(BoardVO vo) {
//		System.out.println(vo.toString());
		service.boardRegist(vo);
		return "service/boardResult";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		return "service/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		service.boardDelete(num);
		return "redirect:/service/boardList";
	}
}
