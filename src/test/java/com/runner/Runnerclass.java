package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.Baseclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(features = "C:\\Users\\admin\\eclipse-workspace\\Zohonew\\src\\test\\java\\com\\feature\\Zoho.feature",
	glue="com.stepdefinition",
	monochrome = true
	
	,dryRun =false)

	public class Runnerclass {
		
		public static WebDriver driver =null;
		@BeforeClass
		public static void setup() {
			driver=Baseclass.browserlaunch("chrome");
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\admin\\eclipse-workspace\\newfacebook\\driver\\chromedriver1.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			//driver.get("https://www.flipkart.com/");
		}
		@AfterClass
		public static void teardown() {
			Baseclass.close();
			//driver.close();

		}
	}

