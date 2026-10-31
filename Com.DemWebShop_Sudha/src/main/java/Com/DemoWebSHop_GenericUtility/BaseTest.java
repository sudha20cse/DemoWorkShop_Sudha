package Com.DemoWebSHop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility=new FileUtility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriver_Utility webdriverUtility=new WebDriver_Utility();
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite --- DataBase Connection");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test --- Report Generation");
		spark=new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports=new ExtentReports();
		reports.attachReporter(spark);
		test=reports.createTest("DemoWebShop");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class --- Launch Browser");
		
//		String browser=fileUtility.readDataFromPropertyFile("browserName");
//		String url=fileUtility.readDataFromPropertyFile("url");
		
		String browser=System.getProperty("browserName");
		String url=System.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Chrome Launched");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Firefox Launched");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			System.out.println("Edge Launched");
			driver=new EdgeDriver();
		}
		else{
			System.out.println("Please enter valid browser name");
		}
		
		sDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method --- Login to App");
		
		welcomePage=new Welcome_Page(driver);
		welcomePage.getLoginLink().click();
		
		loginPage=new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();
		
		homePage=new Home_Page(driver);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method --- Logout of App");
		homePage.getLogoutLink().click();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class --- Close Browser");
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test --- Report End");
		reports.flush();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite --- DataBase Connection Closed");
	}

}
