package com.sjh.web.board.dao;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.common.Pagination;
import com.sjh.web.board.model.BoardVO;
@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return sqlSession.selectList("com.sjh.web.board.boardMapper.getBoardList", pagination);
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		
		return sqlSession.selectOne("com.sjh.web.board.boardMapper.getBoardContent", bid);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert("com.sjh.web.board.boardMapper.insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.sjh.web.board.boardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.sjh.web.board.boardMapper.deleteBoard", bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.sjh.web.board.boardMapper.updateViewCnt", bid);
	}

	@Override
	public int getBoardListCnt() throws Exception {
			return sqlSession.selectOne("com.sjh.web.board.boardMapper.getBoardListCnt");
	}
	
	
}
