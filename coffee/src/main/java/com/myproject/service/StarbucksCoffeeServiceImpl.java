package com.myproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myproject.dao.StarbucksCoffeeDAOImpl;
import com.myproject.dto.StarbucksCoffeeDTO;
@Service
public class StarbucksCoffeeServiceImpl implements StarbucksCoffeeService{
	
	@Inject
	private StarbucksCoffeeDAOImpl dao;
	
	
	@Override
	public int insertCoffee(List<StarbucksCoffeeDTO> list) throws Exception {
		
		return dao.insertCoffee(list);
	}


	@Override
	public List<StarbucksCoffeeDTO> selectCoffeeAll() throws Exception {
		
		return dao.selectCoffeeAll();
	}

	@Override
	public List<StarbucksCoffeeDTO> selectCoffee(String category) throws Exception {
		
		return dao.selectCoffee(category);
	}

}
