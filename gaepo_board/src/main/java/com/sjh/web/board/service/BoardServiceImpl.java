package com.sjh.web.board.service;

import java.util.List;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.common.Pagination;
import com.sjh.web.board.dao.BoardDAO;
import com.sjh.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO boardDAO;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		
		return boardDAO.getBoardList(pagination);
	}
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.insertBoard(boardVO);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BoardVO getBoardContent(int bid) throws Exception{
		boardDAO.updateViewCnt(bid);
		return boardDAO.getBoardContent(bid);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.updateBoard(boardVO);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override	
	public int deleteBoard(int bid) throws Exception {
		
		return boardDAO.deleteBoard(bid);
	}
	//총 게시글 수
	@Override
	public int getBoardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getBoardListCnt();
	}
	
}
