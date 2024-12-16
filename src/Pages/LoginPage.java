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

public class LoginPage 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	@FindBy(name = "username")
	private WebElement usernameTextField;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextField;
	
	@FindBy(name = "remember")
	private WebElement rememberCheckBox;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageMethod() throws IOException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		ScreenshotElements.takeElementsScreenshot(usernameTextField, "beforeusernameTextField");
		usernameTextField.sendKeys("theinfinitecodefrom2024@gmail.com");
		ScreenshotElements.takeElementsScreenshot(usernameTextField, "afterusernameTextField");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(passwordTextField));
		ScreenshotElements.takeElementsScreenshot(passwordTextField, "beforepasswordTextField");
		passwordTextField.sendKeys("Actitime@2024");
		ScreenshotElements.takeElementsScreenshot(passwordTextField, "afteruserpasswordTextField");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(rememberCheckBox));
		ScreenshotElements.takeElementsScreenshot(rememberCheckBox, "beforerememberCheckBox");
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", rememberCheckBox);
		ScreenshotElements.takeElementsScreenshot(rememberCheckBox, "afterrememberCheckBox");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		ScreenshotElements.takeElementsScreenshot(loginButton, "beforeloginButton");
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginButton);
		ScreenshotElements.takeElementsScreenshot(loginButton, "afterloginButton");
		
	}
}
