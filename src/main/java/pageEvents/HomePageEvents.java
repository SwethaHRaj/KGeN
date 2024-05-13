package pageEvents;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import testBase.BaseClass;
import utils.ElementFetch;

public class HomePageEvents extends BaseClass{
	
	ElementFetch ele =  new ElementFetch();
	
	

	public void loginButtonClick() {
		ele.getWebElement("CSS", HomePageElements.loginButton).click();
	}
	
	public void homeTabClick() {
		ele.getWebElement("XPATH", HomePageElements.homeTab).click();
	}
	
	public void gamesTabClick() {
		ele.getWebElement("XPATH", HomePageElements.gamesTab).click();
	}
	
	public void questsTabClick() {
		ele.getWebElement("XPATH", HomePageElements.questsTab).click();
	}
	
    public void verifyPageRedirection(String url, String pageName) {
        String currentUrl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
        String newUrl = driver.getCurrentUrl();
        assertEquals(newUrl, url, "Redirection to "+pageName+" quest page failed");
    }


}