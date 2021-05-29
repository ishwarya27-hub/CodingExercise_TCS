package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchTestcase {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\stikkava\\Documents\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String baseURL = "http://www.amazon.com";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		System.out.println(driver.getTitle());
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("qa testing for beginners");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		String bookPrice = driver.findElement(By.xpath("((//span[@class='a-price'  or @data-a-size='1'])[1])")).getText();
		driver.findElement(By.xpath("//img[@class='s-image'  or @data-image-index='1']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		String bookprice1 = driver.findElement(By.xpath("(//span[@id='newBuyBoxPrice'])")).getText();
		Assert.assertEquals(bookPrice, bookprice1);
		

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
		
		/*
		 * String bookprice2 = driver.findElement(By.xpath(
		 * "(//div[@class='sc-list-item-content']//span[@class,'price')]")).getText();
		 * Assert.assertEquals(bookPrice, bookprice2);
		 * driver.findElement(By.xpath("(//input[@name='proceedToRetailCheckout']")).
		 * click();
		 */
 
		System.out.println("Order Placed");
		
		driver.close();
		driver.quit();
		
	}

}
