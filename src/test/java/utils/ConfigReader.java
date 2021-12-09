package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigReader 
{  
	FileInputStream fs;
	Properties pro;
  	
  public ConfigReader()
   {
	File f=new File("./config.properties");
	try 
	{
		fs=new FileInputStream(f);
	}
	catch (FileNotFoundException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 pro=new Properties();
	try 
	{
		pro.load(fs);
	}
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
  public String getBrowserValue()
  {
	 String value= pro.getProperty("browser");
	 return value;
  }
  
  public String getUrl()
  {
	 String url= pro.getProperty("url");
	 return url;
  }
  public String getUserName()
  {
	 String uname= pro.getProperty("username");
	 return uname;
  }
  public String getPassword()
  {
	 String pw= pro.getProperty("pwd");
	 return pw;
  }
  public String getChromeKey()
  {
	 String ckey= pro.getProperty("chromedriverkey");
	 return ckey;
  }
  public String getGeckoKey()
  {
	 String gkey= pro.getProperty("firefoxdriverkey");
	 return gkey;
  }
  
  
  
  
}
