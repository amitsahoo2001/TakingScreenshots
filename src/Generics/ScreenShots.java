package Generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
public class ScreenShots implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		 
		TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
		File srcFiles = ts.getScreenshotAs(OutputType.FILE);
		
		if(result.getStatus()==1)
			Reporter.log("test case is passed", true);
		else if(result.getStatus()==2)
			Reporter.log("test case is failed", true);
		else if(result.getStatus()==3)
			Reporter.log("test case is skipped", true);
		
		String methodName = result.getName();
		Date date = Calendar.getInstance().getTime();
		String today = date.toString().replace(":", "_");
		File destFile = new File("./faild_screenshot/"+methodName+".png");
		
		try {
			FileHandler.copy(srcFiles, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("chek the format", true);
	}
}
