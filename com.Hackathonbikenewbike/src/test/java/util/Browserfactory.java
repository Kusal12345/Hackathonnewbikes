package util;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public class Browserfactory {

	
	public static WebDriver startApplication(WebDriver driver,String browsername, String url)
	{
		if(browsername.equals("Chrome"))
		{
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
			driver=new ChromeDriver(ops);
			
		}
		else if(browsername.equals("Firefox"))
		{
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "./Webdriver/geckodriver.exe");
			driver=new FirefoxDriver(ops);
		}
		else
		{
			System.out.println("We dont support this driver");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
			
	}
	public static void quitdriver(WebDriver driver)
	{
		driver.quit();
	}
	
}
