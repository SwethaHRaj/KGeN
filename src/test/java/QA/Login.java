package QA;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import testBase.BaseClass;
import utils.ElementFetch;

public class Login extends BaseClass{

	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
	@Test
	public void login() {
		homePage.loginButtonClick();
		loginPage.verifyIfLoginModelIsLoaded();
		loginPage.enterPhoneNumber();
		loginPage.clickVerifyButton();
	}
	
	
}
