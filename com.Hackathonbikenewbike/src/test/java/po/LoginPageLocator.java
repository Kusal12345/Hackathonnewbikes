package po;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.CaptureScreenshot;
import util.Exceldataprovider;
import util.Highlighter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.CaptureScreenshot;
import util.Exceldataprovider;
public class LoginPageLocator {

	 WebDriver driver;
	Exceldataprovider excel;
	
	public LoginPageLocator(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	public void login() {
		
		CaptureScreenshot.ScreenShot(driver,"Mainpage");
		WebElement login=driver.findElement(By.id("forum_login_title_lg"));
		Highlighter.highLightElement(driver, login);
		login.click();
	}

	public void google(){
		WebElement google=driver.findElement(By.className("pr-30"));
		Highlighter.highLightElement(driver, google);
		google.click();
	}
	
	public void emailid(String stringdata){
		driver.navigate().to("https://accounts.google.com/o/oauth2/auth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fwww.zigwheels.com%3Fid%3Dauth222393&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&client_id=591154493254.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fwww.zigwheels.com&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow");
		WebElement searchbox=driver.findElement(By.className("whsOnd"));
		Highlighter.highLightElement(driver, searchbox);
		searchbox.sendKeys(stringdata);
	}
	
	
	public void next() {
		// TODO Auto-generated method stub
		WebElement next=driver.findElement(By.className("VfPpkd-RLmnJb"));
		Highlighter.highLightElement(driver, next);
		next.click();
		//screenshot and capture warning message
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actual_msg=driver.findElement(By.className("o6cuMc")).getText();
		System.out.println("Part 1:");
		CaptureScreenshot.ScreenShot(driver,"invalidlogin");
		System.out.println("Invalid value is given in signin.Hence it shows error as: "+actual_msg);

	}
	
	public void back(){
		//driver comes back to "www.zigwheels.com"
		driver.navigate().back();
	}
	

}
