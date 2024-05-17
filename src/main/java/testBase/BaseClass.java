package testBase;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseClass {
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
@BeforeTest
public void beforeTest() {
	
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"KGeN.html");
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	sparkReporter.config().setTheme(Theme.DARK);
	extent.setSystemInfo("HostName", "Swethas-MacBook-Air.local");
	extent.setSystemInfo("UserName", "Swetha");
	sparkReporter.config().setDocumentTitle("KGeN Automation Report");
	sparkReporter.config().setReportName("Test Results");
}

@BeforeMethod
@Parameters("browser")
public void beforeMethod(String browser, Method testMethod) {
	logger = extent.createTest(testMethod.getName());
	setupDriver(browser);
	driver.manage().window().maximize();
	driver.get(Constants.url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
	

@AfterMethod
public void afterMethod(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Testcase Failed", ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Testcase Failed", ExtentColor.RED));
	} else if(result.getStatus()==ITestResult.SKIP) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Testcase Skipped", ExtentColor.ORANGE));
	} else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Testcase Pass", ExtentColor.GREEN));
	}
//	driver.quit();
}

@AfterTest
public void afterTest() {	
	extent.flush();
}

public void setupDriver(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disk-cache-dir=/path/to/cache");
//        options.addArguments("--incognito");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--force-effective-connection-type=3g");
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}


}
