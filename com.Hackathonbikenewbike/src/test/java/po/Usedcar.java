package po;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.CaptureScreenshot;
import util.Highlighter;
import util.WritetoExcel;
public class Usedcar {
	public WebDriver driver;
	public Usedcar(WebDriver ldriver)
	{
		this.driver=ldriver;
	}


	public void usedcars() throws InterruptedException {
		WebElement menu=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[5]/a"));
		Highlighter.highLightElement(driver, menu);
		menu.click();
		Thread.sleep(2000);
	}


	public void city() {
		WebElement city=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[5]/ul/li/div[1]/ul/li[1]/span"));
		Highlighter.highLightElement(driver, city);

	}


	public void chennai() throws InterruptedException {
		WebElement chennai= driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/div[1]/div/div[3]/ul/li[8]/a"));
		Highlighter.highLightElement(driver, chennai);
		chennai.click();
		Thread.sleep(3000);
		
	}


	public void recent() {
		WebElement recent= driver.findElement(By.xpath("/html/body/div[11]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/span/select"));
		Highlighter.highLightElement(driver, recent);
		recent.click();
	}


	public void list() throws InterruptedException {
		WebElement list=driver.findElement(By.xpath("/html/body/div[11]/div/div[1]/div[2]/div[1]/div/div[1]/div[4]/div[2]/div/span[2]"));
		Highlighter.highLightElement(driver, list);
		list.click();
		CaptureScreenshot.ScreenShot(driver,"Chennaiusedcar");
		

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
	}


	public void data() throws EncryptedDocumentException, IOException {
		ArrayList<String> printModels=new ArrayList<String>(); 
		
		//Reading the input from Excel file
		//String locationPopularUsedCars=KeywordDriven.getLocationName();

		//wait.waitImplicit(driver);
		String models_list=driver.findElement(By.xpath("/html/body/div[11]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]")).getText();
		
		ArrayList<String> models=new ArrayList<String>();
		Collections.addAll(models, models_list.split("\n"));
		
		//Printing the Popular used Cars in Chennai
		//WritetoExcel.usedCarsOutputToExcel("Chennai", "Used Cars", models_list);
		WritetoExcel.usedCarsOutputToExcel( "Used cars in Chennai", models);
		//System.out.println("PART 3:");
		System.out.println("Popular Models of Used Cars in Chennai are:-");
		for(int i =0; i< models.size(); i++){
			System.out.println((i+1)+" "+models.get(i));
	}
		
	}


	public void mainpage() throws InterruptedException {
		WebElement main=driver.findElement(By.xpath("/html/body/header/div/div[1]/div[1]/a/img"));
		Highlighter.highLightElement(driver, main);
		main.click();
		Thread.sleep(1000);
	}
	
	
	
}
