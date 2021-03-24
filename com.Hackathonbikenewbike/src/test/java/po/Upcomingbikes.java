package po;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.CaptureScreenshot;
import util.Highlighter;
import util.WritetoExcel;
public class Upcomingbikes {

	WebDriver driver;
	public  Upcomingbikes(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void upcoming(){
		WebElement upcomingBikes=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/a"));
		Highlighter.highLightElement(driver, upcomingBikes);
		Actions action=new Actions(driver);
		action.moveToElement(upcomingBikes).build().perform();
	}
	
	
	

	public void manufacture() {
		//Adding explicit wait
		WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span"))));
		
		//To click Upcoming bikes
		WebElement upcomingBikesLink=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span"));
		Highlighter.highLightElement(driver, upcomingBikesLink);
		upcomingBikesLink.click();
	}

	public void honda() {
		Assert.assertEquals("Upcoming Bikes in India 2021/22, See Price, Launch Date, Specs @ ZigWheels", driver.getTitle());
		
		//Select the manufacturer
		WebElement manufacture=driver.findElement(By.xpath("//*[@id=\"makeId\"]"));
		Highlighter.highLightElement(driver, manufacture);
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"makeId\"]")));
		select.selectByVisibleText("Honda");
		CaptureScreenshot.ScreenShot(driver,"HondaBikes");
		
	}

	public void lakhs() throws InterruptedException, IOException {


		ArrayList<String> getHondaBikesUnder4Lacs=new ArrayList<String>();
			//Storing the information of all the Upcoming Honda Bikes
			//wait.waitImplicit(driver);
			
		
			
			WebElement element = driver.findElement(By.className("zw-cmn-loadMore"));
			Highlighter.highLightElement(driver, element);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			element.click();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0,800)");

			WebElement bikeModel=driver.findElement(By.xpath("//*[@id='carModels']/ul"));
			String bikeModels =bikeModel.getText();
			
			//Storing the info in an ArrayList
			//wait.waitImplicit(driver);
			try 
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<String> bikeModelsElements = new ArrayList<String>();
			Collections.addAll(bikeModelsElements,bikeModels.split("\n"));
			
			//Sorting the information according to names,dates and prices
			ArrayList<String> NameList = new ArrayList<String>();
			ArrayList<String> DateList = new ArrayList<String>();
			ArrayList<String> PriceList =new ArrayList<String>();
			String[] arr = null;
			for(int i = 0 ; i < bikeModelsElements.size(); i++)
			{
				String s = bikeModelsElements.get(i);
				if(s.contains("Honda"))
				{
					NameList.add(s);
				}
				if(s.contains("Rs. "))
				{
					arr = s.split(" ");
					PriceList.add(arr[1]);
				}
				if(s.contains("Exp. Launch"))
				{
					DateList.add(s);
				}
			}
			//Creating an Arraylist which will add only the upcoming bikes under 4 Lakhs
			//wait.waitImplicit(driver);
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			ArrayList<String> upcomingBikesList = new ArrayList<String>();
			for(int i=0; i<NameList.size();i++)
			{
				String temp = NameList.get(i);
				double price = Double.parseDouble(PriceList.get(i));
				String info=temp+"  "+PriceList.get(i)+" Lakh  "+DateList.get(i);
				if(info.contains(temp))
				{
					if(Double.compare(price, 4d)<0)
					{
						upcomingBikesList.add(info);
					}
				}
			}
			//String upcomingBikesManufacturer=KeywordDriven.getBikeManufacturerName();
			//Printing them
			WritetoExcel.bikesOutputoToExcel("Upcoming Honda Bikes", upcomingBikesList);
			System.out.println("PART 2:");
			System.out.println("Upcoming  Bikes Below 4 Lakhs are as follows:");
			for(int i = 0 ; i < upcomingBikesList.size(); i++)
			{
				System.out.println(upcomingBikesList.get(i));
			}
		
	}

	public void mainpage() {
		WebElement main=driver.findElement(By.xpath("/html/body/header/div/div[1]/div[1]/a/img"));
		Highlighter.highLightElement(driver, main);
		main.click();
	}

	
	
}
