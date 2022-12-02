package com.testNg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Baseclass;
import com.zoho.Zohonew.Zoho_XLSX_reader;



public class ZohotestNg extends Baseclass{
	public static WebDriver driver=null;

	@BeforeClass
	private void browserSetUp() {
		driver=browserlaunch("chrome");
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\admin\\eclipse-workspace\\Zohonew\\driver\\chromedriver1.exe");
//		 driver = new ChromeDriver();
//		driver.manage().window().maximize();

	}

	

	@BeforeClass
	private void urlLaunch() {
		launchURL("https://www.zoho.com/login.html");
		//driver.get("https://www.zoho.com/login.html");

	}

	@Test(priority = 0)
	private void userName() throws IOException, InterruptedException {
		WebElement findElement = driver.findElement(By.xpath("//a[@href='signup.html']"));
		clickOnElement(findElement);
		WebElement faceBookId= driver.findElement(By.xpath("//input[@type='email']"));
		String emailIdName = Zoho_XLSX_reader.Single_zoho("zoho",1,0);
		userInput(faceBookId, emailIdName);
		WebElement findElement3 = driver.findElement(By.xpath("//input[@type='password']"));
		String password = Zoho_XLSX_reader.Single_zoho("zoho",1,1);
		userInput(findElement3, password);
	
		WebElement findElement4 = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		clickOnElement(findElement4);
		WebElement findElement5 = driver.findElement(By.xpath("//input[@type='submit']"));
		clickOnElement(findElement5);
		capture("zoho");
		driver.navigate().back();

	}

	

	
	@AfterClass
	private void urlClose() {
		closeUrl();
		//driver.manage().deleteAllCookies();

	}
	@AfterTest
	private void browserclose() {
		close();
		//driver.close();
		


}
}
