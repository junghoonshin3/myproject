package com.myproject.scrap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.dto.StarbucksCoffeeDTO;
@Component
public class ScrapStarbucks {
	private WebDriver driver;
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	public void close() {
		driver.close();
		driver.quit();
	}
	public List<StarbucksCoffeeDTO> coldbrew_menu() {
			List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			try{
				driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
				List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[1]/ul/li/dl/dt/a"));
				System.out.println("-----------------------coldbrew-------------------");
				for(int i=0; i<list.size(); i++) {
					StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
					info.setCategory("coldbrew");
					info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[1]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
					list.get(i).click();
					info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
					info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
					info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
					info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
					info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
					info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
					info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
					info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
					
					info.allShow();
					
					result_list.add(info);
					driver.navigate().back();
					list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[1]/ul/li/dl/dt/a"));
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				driver.close();
			}
			return result_list;
	}
	public List<StarbucksCoffeeDTO> brood_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[2]/ul/li/dl/dt/a"));
			System.out.println("-----------------------brood-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("brood");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[2]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[2]/ul/li/dl/dt/a"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	
	public List<StarbucksCoffeeDTO> espresso_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[3]/ul/li/dl/dt/a"));
			System.out.println("-----------------------espresso-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("esspresso");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[3]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[3]/ul/li/dl/dt/a"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	public List<StarbucksCoffeeDTO> frappuccino_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[4]/ul/li/dl/dt/a"));
			System.out.println("-----------------------frappucino-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("frappucino");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[4]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[4]/ul/li/dl/dt/a"));
				
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	public List<StarbucksCoffeeDTO> blended_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[5]/ul/li/dl/dt/a"));
			System.out.println("-----------------------blended-------------------");
			for(int i=0; i<list.size(); i++) {
				//디카페인 아포가토 블렌디드 - 조회불가능한상품 처리 에러발생..
				if(i==1) {
					continue;
				}
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("blendid");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[5]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[5]/ul/li/dl/dt/a"));
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	public List<StarbucksCoffeeDTO> fizzo_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[6]/ul/li/dl/dt/a"));
			System.out.println("-----------------------fizzo-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("fizzo");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[6]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[6]/ul/li/dl/dt/a"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	public List<StarbucksCoffeeDTO> tea_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[7]/ul/li/dl/dt/a"));
			System.out.println("-----------------------tea-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("tea");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[7]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[7]/ul/li/dl/dt/a"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}	
	public List<StarbucksCoffeeDTO> etc_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[8]/ul/li/dl/dt/a"));
			System.out.println("-----------------------etc-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("etc");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[8]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[8]/ul/li/dl/dt/a"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
	public List<StarbucksCoffeeDTO> juice_menu() {
		List<StarbucksCoffeeDTO> result_list=new ArrayList<StarbucksCoffeeDTO>();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.get("https://www.istarbucks.co.kr/menu/drink_list.do");
			List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[9]/ul/li/dl/dt/a"));
			System.out.println("-----------------------juice-------------------");
			for(int i=0; i<list.size(); i++) {
				StarbucksCoffeeDTO info=new StarbucksCoffeeDTO();
				info.setCategory("juice");
				info.setImg_address(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[9]/ul/li["+(i+1)+"]/dl/dt/a/img"))).getAttribute("src").trim());
				list.get(i).click();
				info.setCoffee_name(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/div[1]/h4"))).getText().trim());
				info.setCoffee_size(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_info01\"]"))).getText().trim());
				info.setKcal(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[1]/dl/dd"))).getText().trim());
				info.setSat_fat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[2]/dl/dd"))).getText().trim());
				info.setProtein(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[1]/li[3]/dl/dd"))).getText().trim());
				info.setSodium(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[1]/dl/dd"))).getText().trim());
				info.setSugars(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[2]/dl/dd"))).getText().trim());
				info.setCaffeine(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[2]/form/fieldset/div/div[2]/ul[2]/li[3]/dl/dd"))).getText().trim());
				
				info.allShow();
				result_list.add(info);
				driver.navigate().back();
				list=driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/dl/dd[1]/div[1]/dl/dd[9]/ul/li/dl/dt/a"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
		}
		return result_list;
}
}

