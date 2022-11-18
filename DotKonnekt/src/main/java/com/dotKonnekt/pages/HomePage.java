package com.dotKonnekt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//h1[normalize-space()='Grow your D2C channel']")
	WebElement pageHeading;
	
	@FindBy(xpath = "//div[@class = 'dot-members']/h6")
	WebElement personName;
	
	
	public HomePage() {
		PageFactory.initElements( getDriver(), this);
	}
	
	public boolean validatePageHeading() {
		Action.isDisplayed(getDriver(), pageHeading);
		return true;
	}
	
	public boolean validateTeamsPeople() {
		Action.scrollByVisibilityOfElement(getDriver(), personName);
		
		Action.isDisplayed(getDriver(), personName);
		return true;
	}
	
	public String gettitile() {
		String title = getDriver().getTitle();
		return title;
	}
	
}
