package com.zoho.Zohonew;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Zoho {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Zohonew\\driver\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zoho.com/login.html");
		WebElement findElement = driver.findElement(By.xpath("//a[@href='signup.html']"));
		findElement.click();
		WebElement faceBookId= driver.findElement(By.xpath("//input[@type='email']"));
		String emailIdName = Zoho_XLSX_reader.Single_zoho("zoho",1,0);
		faceBookId.sendKeys(emailIdName);
		WebElement findElement3 = driver.findElement(By.xpath("//input[@type='password']"));
		String password = Zoho_XLSX_reader.Single_zoho("zoho",1,1);
		
		findElement3.sendKeys(password);
	
		WebElement findElement4 = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		findElement4.click();
		WebElement findElement5 = driver.findElement(By.xpath("//input[@type='submit']"));
		findElement5.click();
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
		File to=new File("C:\\Users\\admin\\eclipse-workspace\\Miniproject\\screenshot\\img.png");
		FileHandler.copy(from, to);
		driver.navigate().back();



		

		

		
		
		
		
		
		
		
	}

}
