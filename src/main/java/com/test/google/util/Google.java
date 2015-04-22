package com.test.google.util;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public final class Google{

	private static WebDriver driver;
	
	private static final String URL = "https://www.google.com";
	private static final String SEARCH_TEXT = "12345";
	
	public static void launchBroswer(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static void getURL(){
		driver.get(URL);
	}
	
	public static void searchText(){
		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.sendKeys(SEARCH_TEXT);
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).submit();
	}
	 public static boolean getResultPage(){
		 WebElement resultId = driver.findElement(By.id("resultStats"));
		 return resultId.isDisplayed();
	 }
	 
	 public static boolean getCurrentURL() {
		return driver.getCurrentUrl().contains("12345");
	 }
	public static boolean getImagePresence(){
		WebElement image = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("lu_map")));
		return image.isDisplayed();
	}
	public static String getURLString(){
		WebElement imgurl = driver.findElement(By.xpath("//div[@id='rhs_block']/ol/div/div[4]/a"));
		String source = imgurl.getAttribute("href");
		return  source ;
	}
	
	public static boolean getSearchBoxText(){
		String text = driver.findElement(By.id("lst-ib")).getAttribute("value");
		return text.contains("12345");
	}
	public static void closeBrowser(){
		driver.quit();
	}
		
}
