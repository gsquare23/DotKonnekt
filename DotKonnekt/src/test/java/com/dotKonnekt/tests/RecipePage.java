package com.dotKonnekt.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecipePage {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriver driver =  new EdgeDriver();
		driver.get("https://develop.d1fzm6olmw007.amplifyapp.com/recipe/sugarcane-juice-black-wheat-muffins-cake");
		driver.manage().window().maximize();
		
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		Assert.assertEquals(Actualtitle, "RecipePage");
		
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		
		driver.quit();
	}

}
