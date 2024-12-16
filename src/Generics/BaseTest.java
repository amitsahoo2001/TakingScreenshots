package Generics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest 
{
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.get("https://online.actitime.com/hyderabad/login.do");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
