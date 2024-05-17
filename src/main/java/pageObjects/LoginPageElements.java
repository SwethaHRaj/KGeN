package pageObjects;

public interface LoginPageElements {

	String LoginHeaderText = "//p[@class='MuiTypography-root MuiTypography-body1 css-xhjyaz']";
	String enterPhoneTextField = ":r1:";
	String verifyButton = "//button[normalize-space()='Verify']";
	String enterOtpDigitField = "//input[@id='otp-input-0']";
	String submitButton = "//button[normalize-space()='Submit']";
}
