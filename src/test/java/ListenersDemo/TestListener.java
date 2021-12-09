package ListenersDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class TestListener extends TestBase implements ITestListener
{
	
	public void onStart(ITestContext context)
	{
		System.out.println("this is the start of the testing");
	}
		
	public void onFinish(ITestContext context)
	{
		System.out.println("this is the on finish of the testing");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("this is the on test start of the testing" + result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("test case execution success"  + result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("test case  failure"  + result.getName());
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String fileName=result.getName()+".png";
		File dest=new File("ScreenShots",fileName);
		try {
			FileUtils.copyFile(source,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
