package com.myproject.dao;

import java.util.List;

import com.myproject.dto.StarbucksCoffeeDTO;

public interface StarbucksCoffeeDAO {
	
	
	public int insertCoffee(List<StarbucksCoffeeDTO> list) throws Exception;
	public List<StarbucksCoffeeDTO> selectCoffeeAll() throws Exception;
	public List<StarbucksCoffeeDTO> selectCoffee(String category) throws Exception;
	
}
