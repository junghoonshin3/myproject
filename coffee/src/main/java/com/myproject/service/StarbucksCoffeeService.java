package com.myproject.service;

import java.util.List;

import com.myproject.dto.StarbucksCoffeeDTO;

public interface StarbucksCoffeeService {
	
	public int insertCoffee(List<StarbucksCoffeeDTO> list) throws Exception;
	public List<StarbucksCoffeeDTO> selectCoffeeAll() throws Exception;
	public List<StarbucksCoffeeDTO> selectCoffee(String category) throws Exception;
}
