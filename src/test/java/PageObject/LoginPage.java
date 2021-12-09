package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
    By username=By.xpath("//input[@id=\"txtUsername\"]");
    By pswd=By.xpath("//input[@id=\"txtPassword\"]");
    By login=By.xpath("//input[@value=\"LOGIN\"]");
    By error=By.xpath("//span[@id=\"spanMessage\"]");
    public boolean verify()
    {
    	boolean status=driver.findElement(username).isDisplayed();
    	return status;
    }
    public void setName(String uname)
    {
    	driver.findElement(username).sendKeys(uname);
    }
    public boolean verifyPwd()
    {
    	boolean status=driver.findElement(pswd).isDisplayed();
    	return status;
    }
    public void setPwd(String pwd)
    {
    	driver.findElement(pswd).sendKeys(pwd);
    }
    public boolean verifyLogin()
    {
    	boolean status=driver.findElement(login).isEnabled();
    	return status;
    }
    public void click()
    {
    	driver.findElement(login).click();
    }
    public String getInvalid()
    {
    	String errormessage=driver.findElement(error).getText();
    	return errormessage;
    }
}
