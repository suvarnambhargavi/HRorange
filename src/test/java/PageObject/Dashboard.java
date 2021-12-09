package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard
{
	public Dashboard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//h1[text()='Dashboard']")
	WebElement dashboardpage;
	public boolean verifyId()
	{
		boolean status=dashboardpage.isDisplayed();
		return status;
	}
    public String getTitle()
    {
    	String title=dashboardpage.getText();
    	return title;
    }
}
