package pageEvents;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.LoginPageElements;
import testBase.BaseClass;
import utils.ElementFetch;

public class LoginPageEvents extends BaseClass {
	
	ElementFetch ele = new ElementFetch();
	
	public void verifyIfLoginModelIsLoaded() {
//		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//	        wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", LoginPageElements.LoginHeaderText)));
		 Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.LoginHeaderText).size()>0,"Element not found");
	}
	
	public void enterPhoneNumber() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.e(ele.getWebElement("XPATH", LoginPageElements.enterPhoneTextField)));
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		ele.getWebElement("XPATH", LoginPageElements.enterPhoneTextField).click();
		ele.getWebElement("XPATH", LoginPageElements.enterPhoneTextField).sendKeys("9876543210");
	}
	
	public void clickVerifyButton() {
		ele.getWebElement("XPATH", LoginPageElements.verifyButton).click();
	}

}
