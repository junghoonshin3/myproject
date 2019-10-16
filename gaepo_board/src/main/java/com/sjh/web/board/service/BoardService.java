package com.sjh.web.board.service;

import java.util.List;
import java.util.Map;

import com.sjh.web.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
}
