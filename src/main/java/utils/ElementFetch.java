package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifiervalue) {
		switch(identifierType) {
		
		case "XPATH":
			return BaseClass.driver.findElement(By.xpath(identifiervalue));
		
		case "CSS":
			return BaseClass.driver.findElement(By.cssSelector(identifiervalue));
		
		case "ID":
			return BaseClass.driver.findElement(By.id(identifiervalue));
		
		case "NAME":
			return BaseClass.driver.findElement(By.name(identifiervalue));
			
		case "TAGNAME":
			return BaseClass.driver.findElement(By.tagName(identifiervalue));
		
		default:
			return null;
		
		}
	}
	
	public List<WebElement> getWebElements(String identifierType, String identifierValue) {
		switch(identifierType) {
		
		case "XPATH":
			return BaseClass.driver.findElements(By.xpath(identifierValue));
		
		case "CSS":
			return BaseClass.driver.findElements(By.cssSelector(identifierValue));
		
		case "ID":
			return BaseClass.driver.findElements(By.id(identifierValue));
		
		case "NAME":
			return BaseClass.driver.findElements(By.name(identifierValue));
			
		case "TAGNAME":
			return BaseClass.driver.findElements(By.tagName(identifierValue));
		
		default:
			return null;
		
		}
	}
	
}

