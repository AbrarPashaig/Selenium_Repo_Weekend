package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepositary.LogInPage;
import objectrepositary.WelcomePage;

public class BaseClass {
	public static ExtentReports ereports;
	public static WebDriver driver;
	public static ExtentTest test;
	public JAVAUtility jutil=new JAVAUtility();
	public FileUtility futil=new FileUtility();
	public ExelUtility eutil=new ExelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports//ExtentReport_"+jutil.getSystemTime()+".html");
		ereports = new ExtentReports();
		ereports.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginlink().click();
		LogInPage ip=new LogInPage(driver);
		ip.getEmailTextField().sendKeys(futil.getDataFromProperty("email"));
		ip.getPasswordTextField().sendKeys(futil.getDataFromProperty("password"));
		ip.getLoginButton().click();
	}
	
	@AfterSuite
	public void reportBackup() {
		ereports.flush();
	}
}
