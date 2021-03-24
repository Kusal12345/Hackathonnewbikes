package Tc;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import po.LoginPageLocator;
import po.Upcomingbikes;
import po.Usedcar;
import util.Browserfactory;
import util.Configuredataprovider;
//import product.po.UsedCars;
import po.Baseclass;
public class Loginpagewheels extends Baseclass {
	@Test
	public void browser(){
		Configuredataprovider lo = PageFactory.initElements(driver, Configuredataprovider.class);
		lo.getbrowser();
		ExtentTest test = extent.createTest("Check Browser");											
		test.log(Status.INFO, "Get Browser");															
		test.log(Status.PASS, "Browser Verification Successful");	
	}
	
	@Test
	public void url(){
		Configuredataprovider lo = PageFactory.initElements(driver, Configuredataprovider.class);
		lo.geturl();
		ExtentTest test = extent.createTest("Check URL");											
		test.log(Status.INFO, "Open URL");															
		test.log(Status.PASS, "URL Verification Successful");
	}
	@Test(priority=1)
	public void loginsearch() {
		LoginPageLocator lo = PageFactory.initElements(driver, LoginPageLocator.class);
		lo.login();
		ExtentTest test = extent.createTest("Title Verification of WebPage");											
		test.log(Status.INFO, "Get Page Title");															
		test.log(Status.PASS, "Title Verification Successful");
	}
	@Test(priority=2)
	public void googlebutton(){
		LoginPageLocator lobj= PageFactory.initElements(driver,LoginPageLocator.class);
		lobj.google();
		ExtentTest test = extent.createTest("Locate Sign In button");											
		test.log(Status.INFO, "Locate the Sign In button and click it");															
		test.log(Status.PASS, "Sign In button Verification Successful");
	}
	
	@Test(priority=3)
	public void emaildata(){
		LoginPageLocator lobj= PageFactory.initElements(driver,LoginPageLocator.class);
		lobj.emailid(excel.getStringdata(0, 3, 0));
		ExtentTest test = extent.createTest("Verify Email id");											
		test.log(Status.INFO, " Enter Email Id from excel sheet");													
		test.log(Status.PASS, "Email Id data entry Verification Successful");
	}
	
	@Test(priority=3)
	public void verify() throws IOException{
		LoginPageLocator lobj= PageFactory.initElements(driver,LoginPageLocator.class);
		lobj.next();
		ExtentTest test = extent.createTest("Error Message");										
		test.log(Status.INFO, "Capture Error message");															
		test.log(Status.PASS, "Error message extraction Verification Successful");
		test.addScreenCaptureFromPath("Error_Message.jpeg");
	}
	
	@Test(priority=4)
	public void navigateback(){
		LoginPageLocator lobj= PageFactory.initElements(driver,LoginPageLocator.class);
		lobj.back();
		ExtentTest test = extent.createTest("Navigate back");											
		test.log(Status.INFO, "Navigate back to main page");															
		test.log(Status.PASS, "Navigation Back Verification Successful");
	}
	
	@Test(priority=5)
	public void bike(){
		Upcomingbikes bike=PageFactory.initElements(driver,Upcomingbikes.class);
		bike.upcoming();
		ExtentTest test = extent.createTest("New Bikes");										
		test.log(Status.INFO, "Click on New Bikes tab");															
		test.log(Status.PASS, "New Bikes Verification Successful");
	}
	
	@Test(priority=6)
	public void manufacture(){
		Upcomingbikes bike=PageFactory.initElements(driver,Upcomingbikes.class);
		bike.manufacture();
		ExtentTest test = extent.createTest("Upcomming Bikes");											
		test.log(Status.INFO, "Search for upcomming bikes");															
		test.log(Status.PASS, "Upcoming bikes search Verification Successful");
	}
	
	@Test(priority=7)
	public void honda(){
		Upcomingbikes bike=PageFactory.initElements(driver,Upcomingbikes.class);
		bike.honda();
		ExtentTest test = extent.createTest("Honda Bikes");										
		test.log(Status.INFO, "Set search filter as Honda Bikes");															
		test.log(Status.PASS, "Honda Bikes Verification Successful");
	}
	
	@Test(priority=8)
	public void bikes4lakhs() throws InterruptedException, IOException{
		Upcomingbikes bike=PageFactory.initElements(driver,Upcomingbikes.class);
		bike.lakhs();
		ExtentTest test = extent.createTest("Search 4 Lakhs Bikes");											
		test.log(Status.INFO, "Search for 4 Lakhs Bikes and store it");															
		test.log(Status.PASS, "Internal search for 4 Lakhs Bike Verification Successful");
		test.log(Status.PASS, "Data stored in excel format as UpcomingBikes.xlsx file ");
		test.log(Status.PASS, "Data printed in console under Part 2");
	}

	@Test(priority=9)
	public void mainpage(){
		Upcomingbikes bike=PageFactory.initElements(driver,Upcomingbikes.class);
		bike.mainpage();
		ExtentTest test = extent.createTest("Return to main page");										
		test.log(Status.INFO, "Return to main page");															
		test.log(Status.PASS, "Main page Verification Successful");
	}
	
	@Test(priority=10)
	public void usedcars() throws InterruptedException{
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.usedcars();
		ExtentTest test = extent.createTest("Used Cars");										
		test.log(Status.INFO, "Click on Used Cars button");															
		test.log(Status.PASS, "Used Cars button Verification Successful");
	}
	
	@Test(priority=11)
	public void city(){
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.city();
		ExtentTest test = extent.createTest("Select City");											
		test.log(Status.INFO, "Select city button");															
		test.log(Status.PASS, "City selection button Verification Successful");
	}
	
	@Test(priority=12)
	public void chennai() throws InterruptedException{
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.chennai();
		ExtentTest test = extent.createTest("Select Chennai");											
		test.log(Status.INFO, "Set city as Chennai");															
		test.log(Status.PASS, "City selection Verification Successful");
	}
	
	@Test(priority=13)
	public void recent(){
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.recent();
		ExtentTest test = extent.createTest("Search recent used cars");											
		test.log(Status.INFO, "Set search filter as Recent Used Cars");															
		test.log(Status.PASS, "Set Recent used cars as filter Successful");
	}
	
	@Test(priority=14)
	public void list() throws InterruptedException{
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.list();
		ExtentTest test = extent.createTest("Show in List Format");											
		test.log(Status.INFO, "View used cars in list format");															
		test.log(Status.PASS, "List format Verification Successful");
	}
	
	@Test(priority=15)
	public void data() throws EncryptedDocumentException, IOException{
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.data();
		ExtentTest test = extent.createTest("Store Used Cars data");											
		test.log(Status.INFO, "Store recent used cars data in Excel ");															
		test.log(Status.PASS, "Storeing of data Successful");
		test.log(Status.PASS, "Data saved in UsedCarsInChennai.xlsx file");
		test.log(Status.PASS, "Data printed in Console under Part 3:");
	}
	
	@Test(priority=16)
	public void mainpage1() throws InterruptedException{
		Usedcar search=PageFactory.initElements(driver, Usedcar.class);
		search.mainpage();
		ExtentTest test = extent.createTest("Return to main page");											
		test.log(Status.INFO, "Navigation back to main page");														
		test.log(Status.PASS, "Navigation of main page Verification Successful");
	}
	
	@Test(priority=17)
	public void moveFocusToMainWindow() throws InterruptedException {
		Browserfactory.quitdriver(driver);														
		ExtentTest test = extent.createTest("Close Website Window");												
		test.log(Status.INFO, "Close Website Window");													
		test.log(Status.PASS, "Website Window closed successfully");								
		Thread.sleep(1000);																					
	}
	

}
