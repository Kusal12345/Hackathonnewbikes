package util;
import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
public class Configuredataprovider {
	Properties pro;
	public Configuredataprovider()
	{
	
	File src=new File("./config/Config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}  catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("not able to loadf"+e.getMessage());
		}
	}
	
	public String geturl() 
	{
		return pro.getProperty("url");
	}
	public String getbrowser() 
	{
		return pro.getProperty("browser");
	}

}
