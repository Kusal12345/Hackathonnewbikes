package util;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class CaptureScreenshot {
	public static void ScreenShot(WebDriver driver,String ScreenShotname)
	{
		try 
		{
			//taking the screenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("./Screenshot/"+ScreenShotname+".png"));//saving the destination folder and giving screenshot name
			System.out.println("Screen shot taken");
		} catch (Exception  e) 
		{
			//printing any exception
			System.out.println("Exception is" +e.getMessage());
		}
	}


}
