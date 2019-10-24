package com.sjh.web.board.service;

import java.util.List;
import java.util.Map;

import com.sjh.common.Pagination;
import com.sjh.web.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int getBoardListCnt() throws Exception;

}
