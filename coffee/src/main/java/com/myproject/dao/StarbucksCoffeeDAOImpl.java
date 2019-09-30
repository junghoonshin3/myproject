package com.myproject.dao;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.myproject.dto.StarbucksCoffeeDTO;

@Repository
public class StarbucksCoffeeDAOImpl implements StarbucksCoffeeDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String NameSpace="com.myproject.mapper.CoffeeMapper";
	
	
	@Override
	public int insertCoffee(List<StarbucksCoffeeDTO> list) throws Exception {
		
		return sqlSession.insert(NameSpace+".insertCoffee", list);
	}


	@Override
	public List<StarbucksCoffeeDTO> selectCoffeeAll() throws Exception {
		return sqlSession.selectList(NameSpace+".selectCoffeeAll");
		
	}


	@Override
	public List<StarbucksCoffeeDTO> selectCoffee(String category) throws Exception {
		
		return sqlSession.selectList(NameSpace+".selectCoffee", category);
	}
	
	
}
