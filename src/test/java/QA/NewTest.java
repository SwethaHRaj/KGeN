package QA;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import testBase.BaseClass;
import utils.ElementFetch;

public class NewTest extends BaseClass{
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
	
  @Test
  public void login() {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", HomePageElements.loginButton)));
      homePage.loginButtonClick();
	  loginPage.verifyIfLoginModelIsLoaded();
	  loginPage.enterPhoneNumber();
	  loginPage.clickVerifyButton();
	  loginPage.enterOtp();
	  loginPage.clickSubmitButton();
		homePage.questsTabClick();
		homePage.verifyPageRedirection("https://kgen.io/gamer/quests", "Quests");
		homePage.homeTabClick();
		homePage.verifyPageRedirection("https://kgen.io/gamer", "Home");
		homePage.gamesTabClick();
		homePage.verifyPageRedirection("https://kgen.io/gamer/games", "Games");
  }


}