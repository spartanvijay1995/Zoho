package com.stepdefinition;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.base.Baseclass;
import com.runner.Runnerclass;
import com.zoho.Zohonew.Zoho_XLSX_reader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends Baseclass{
	public static WebDriver driver = Runnerclass.driver;

	@Given("^user Launch The Url$")
	public static void user_Launch_The_Url() throws Throwable {
		launchURL("https://www.zoho.com/login.html");
		//driver.get("https://www.zoho.com/login.html");
	}

	@When("^user Click The SignUp Button$")
	public  static void user_Click_The_SignUp_Button() throws Throwable {
		WebElement findElement = driver.findElement(By.xpath("//a[@href='signup.html']"));
		clickOnElement(findElement);
		//findElement.click();
	}

	@When("^user Enter The EmailId and Password and Login Into The Zoho Acccount$")
	public  static void user_Enter_The_EmailId_and_Password_and_Login_Into_The_Zoho_Acccount() throws Throwable {
		WebElement faceBookId= driver.findElement(By.xpath("//input[@type='email']"));
		String emailIdName = Zoho_XLSX_reader.Single_zoho("zoho",1,0);
		userInput(faceBookId, emailIdName);
		//faceBookId.sendKeys(emailIdName);
		WebElement findElement3 = driver.findElement(By.xpath("//input[@type='password']"));
		String password = Zoho_XLSX_reader.Single_zoho("zoho",1,1);
		userInput(findElement3, password);
		//findElement3.sendKeys(password);
	}

	@When("^user Find EmailId and Password Is Not Valid$")
	public  static void user_Find_EmailId_and_Password_Is_Not_Valid() throws Throwable {
		WebElement findElement4 = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		clickOnElement(findElement4);
		//findElement4.click();
		WebElement findElement5 = driver.findElement(By.xpath("//input[@type='submit']"));
		clickOnElement(findElement5);
		//findElement5.click();
		Thread.sleep(3000);
	}

	@Then("^user TakeScreenshot and Saved In The Driver$")
	public  static void user_TakeScreenshot_and_Saved_In_The_Driver() throws Throwable {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
		File to=new File("C:\\Users\\admin\\eclipse-workspace\\Miniproject\\screenshot\\img.png");
		FileHandler.copy(from, to);
		driver.navigate().back();
	}
}
