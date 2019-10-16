package com.sjh.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sjh.web.board.model.BoardVO;
import com.sjh.web.board.service.BoardService;

@Controller
public class BoardController {
	@Inject
	private BoardService boardService;
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("getBoardList")
	public String talk(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "/board/board";
	}
	
	@RequestMapping("boardForm")
	public String boardForm() {
		return "/board/boardForm";
	}
	
	@RequestMapping("saveBoard")
	public String saveBoard(@ModelAttribute("BoardVO")BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		
		boardService.insertBoard(boardVO);
		return "redirect:/getBoardList";
	}
	
	@RequestMapping(value="getBoardContent", method=RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid")int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "/board/boardContent";
	}
}
