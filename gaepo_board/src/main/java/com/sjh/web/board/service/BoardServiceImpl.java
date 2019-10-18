package com.sjh.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.board.dao.BoardDAO;
import com.sjh.web.board.model.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		
		return boardDAO.getBoardList();
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.insertBoard(boardVO);
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		boardDAO.updateViewCnt(bid);
		return boardDAO.getBoardContent(bid);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		
		return boardDAO.deleteBoard(bid);
	}
	
}
