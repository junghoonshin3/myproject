package com.myproject.dto;


public class StarbucksCoffeeDTO {
	private String id;
	private String category;
	private String coffee_name;
	private String coffee_size;
	private String kcal;
	private String sat_fat;
	private String protein;
	private String sodium;
	private String sugars;
	private String caffeine;
	private String img_address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImg_address() {
		return img_address;
	}
	public void setImg_address(String img_address) {
		this.img_address = img_address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCoffee_name() {
		return coffee_name;
	}
	public void setCoffee_name(String coffe_name) {
		this.coffee_name = coffe_name;
	}
	public String getCoffee_size() {
		return coffee_size;
	}
	public void setCoffee_size(String coffee_size) {
		this.coffee_size = coffee_size;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getSat_fat() {
		return sat_fat;
	}
	public void setSat_fat(String sat_fat) {
		this.sat_fat = sat_fat;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getSodium() {
		return sodium;
	}
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}
	public String getSugars() {
		return sugars;
	}
	public void setSugars(String sugars) {
		this.sugars = sugars;
	}
	public String getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(String caffeine) {
		this.caffeine = caffeine;
	}
	
	
	
	public void allShow() {
		System.out.println("---------------------------");
		System.out.println("category : "+category);
		System.out.println("img_address : "+ img_address);
		System.out.println("coffe_name :"+coffee_name);
		System.out.println("coffee_size :"+coffee_size);
		System.out.println("kcal :"+kcal);
		System.out.println("sat_fat :"+sat_fat);
		System.out.println("protein :"+protein);
		System.out.println("sodium :"+sodium);
		System.out.println("sugars :"+sugars);
		System.out.println("caffeine :"+caffeine);
		System.out.println("---------------------------");
	}
	
}
