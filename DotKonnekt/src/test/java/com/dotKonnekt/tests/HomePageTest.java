package com.dotKonnekt.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.pages.HomePage;
import com.dotKonnekt.utility.Log;

public class HomePageTest extends BaseClass{

	
	HomePage homepage;
	
	@FindBy(xpath = "//div[@class = 'dot-members']/h6" )
	WebElement scrollElement;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();
	}
	
	
	  @AfterMethod 
	  public void tearDown() { getDriver().quit(); }
	 
	
	@Test
	public void verifyPageHeading() {
		Log.startTestCase("verifyPageHeading");
		homepage = new HomePage();
		Log.info("Verifying the pageHeading");
		boolean  result = homepage.validatePageHeading();
		Log.info("Checking the True status");
		Assert.assertTrue(result);
		Log.endTestCase("verifyPageHeading");
	}
	
	@Test
	public void printTeamName() throws InterruptedException {
		homepage = new HomePage();
		Log.startTestCase("printTeamName");
		Log.info("Validating that the teams name are present or not");
		boolean result =homepage.validateTeamsPeople();
		Thread.sleep(5000);
		//Action.explicitWait(getDriver(), scrollElement, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,4100)","");
		Thread.sleep(5000);
		//Action.explicitWait(getDriver(), scrollElement, Duration.ofSeconds(10));
		List<WebElement> name = getDriver().findElements(By.xpath("//div[@class = 'dot-members']/h6"));
		System.out.println(name.size());
		
		  for(WebElement e : name) {
			  String names = e.getText();
			  System.out.println(names);
		}
		Log.endTestCase("printTeamName");
	}
	
	@Test
	public void verifyTitle() throws InterruptedException {
		Log.startTestCase("verifyTitle");
		String actual_title = homepage.gettitile();
		System.out.println("Title is"+ actual_title);
		/*
		 * getDriver().manage().deleteAllCookies(); //delete all cookies
		 * Thread.sleep(7000);
		 */
		
		if(actual_title.equals("DotKonnekt - Experiential Commerce Platform1")) {
			Assert.assertTrue(true);
		}
		else {
			Action.screenShot(getDriver(), actual_title);
			Thread.sleep(5000);
			Assert.assertTrue(false);
		}
		
		Log.endTestCase("verifyTitle");
	}
}   
