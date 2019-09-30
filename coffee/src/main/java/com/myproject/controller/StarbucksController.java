package com.myproject.controller;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.dto.StarbucksCoffeeDTO;
import com.myproject.scrap.ScrapStarbucks;
import com.myproject.service.StarbucksCoffeeServiceImpl;

@Controller
public class StarbucksController {
	@Autowired
	ScrapStarbucks scrapstarbucks;
	
	@Autowired
	StarbucksCoffeeServiceImpl coffeeService;
	
	@RequestMapping("menu_scrap")
	public void menu() {
		scrapstarbucks.setup();
		try {
			
			List<StarbucksCoffeeDTO> result_list=scrapstarbucks.coldbrew_menu();
			if(result_list!=null) {
			coffeeService.insertCoffee(result_list);
			}else {
				System.out.println("null");
			}
			result_list=scrapstarbucks.brood_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.espresso_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.frappuccino_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.blended_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.fizzo_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.tea_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.etc_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			result_list=scrapstarbucks.juice_menu();
			if(result_list!=null) {
				coffeeService.insertCoffee(result_list);
				}else {
					System.out.println("null");
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrapstarbucks.close();

	}
	
	@RequestMapping("home")
	public String home(Model model) {
		
		try {
			List<StarbucksCoffeeDTO> allList=coffeeService.selectCoffeeAll();
			model.addAttribute("coffelistAll", allList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "home";
	}
	
	@RequestMapping("selectedCoffee")
	@ResponseBody
	public List<StarbucksCoffeeDTO> selectedCoffee(@RequestParam(value="param") String param) {
		List<StarbucksCoffeeDTO> coldbrew_list=null;
		System.out.println("param"+ param);
		try {
			
			coldbrew_list=coffeeService.selectCoffee(param);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coldbrew_list;
	}
}
