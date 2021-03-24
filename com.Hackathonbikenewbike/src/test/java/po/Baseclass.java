package po;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import util.Browserfactory;
import util.Configuredataprovider;
import util.Exceldataprovider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class Baseclass {
	public WebDriver driver=null;
	public Configuredataprovider config;
	public Exceldataprovider excel;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setupsuite() {

		config = new Configuredataprovider();
		excel = new Exceldataprovider();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/testReport/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("New Bikes Automation");
		extent.setSystemInfo("New Bikes", "Automation");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("URL", "www.zigwheels.com");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@BeforeClass
	public void setup()
	{

		driver=Browserfactory.startApplication(driver, config.getbrowser(), config.geturl());
		System.out.println("Page Title:");
		System.out.println(driver.getTitle());
	}
	
	

	@AfterClass
	public void teardown() 
	{
		extent.flush();
		Browserfactory.quitdriver(driver);
		System.out.println(" Test Completed Successfully");
	}
	

}
