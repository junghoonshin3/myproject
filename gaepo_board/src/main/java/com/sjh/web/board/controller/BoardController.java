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
	public String saveBoard(@ModelAttribute("boardVO")BoardVO boardVO, @RequestParam("mode")String mode,RedirectAttributes rttr) throws Exception {
		if(mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		}else {
			boardService.insertBoard(boardVO);
		}
		
		return "redirect:/getBoardList";
	}
	
	@RequestMapping(value="getBoardContent", method=RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid")int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "/board/boardContent";
	}
	@RequestMapping(value="editForm", method=RequestMethod.GET)
	public String editForm(@RequestParam("bid")int bid, @RequestParam("mode")String mode, Model model) throws Exception {
		BoardVO boardContent=boardService.getBoardContent(bid);
		model.addAttribute("boardContent", boardContent);
		model.addAttribute("mode", mode);
		BoardVO boardVO=new BoardVO();
		boardVO.setContent(boardContent.getContent());
		model.addAttribute("boardVO", boardVO);
		return "/board/boardForm";
	}
	@RequestMapping(value="deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam("bid")int bid) throws Exception {
		boardService.deleteBoard(bid);
		return "redirect:/getBoardList";
	}
	
}
