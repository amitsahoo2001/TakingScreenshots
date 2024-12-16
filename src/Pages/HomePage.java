package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generics.ScreenshotElements;

public class HomePage 
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskOption;
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNew;
	
	@FindBy(xpath = "(//div[starts-with(@class,'item')])[23]")
	private WebElement NewCustomer;
	
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement logoutLink;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void taskOptionMethod() throws IOException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(taskOption));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", taskOption);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElements(addNew));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addNew);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElements(NewCustomer));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", NewCustomer);
	}
	public void logoutMethod() throws IOException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", logoutLink);
	}
}
