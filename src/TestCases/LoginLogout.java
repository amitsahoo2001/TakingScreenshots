package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Generics.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

//@Listeners(generics.Sreenshots.class)
public class LoginLogout extends BaseTest
{
	@Test
	public void loginActiTime() throws IOException
	{
		LoginPage login = new LoginPage(driver);
		login.loginPageMethod();
	}
	
	@Test(dependsOnMethods = "loginActiTime")
	public void logoutActiTime() throws IOException
	{
		HomePage homepage = new HomePage(driver);
		homepage.logoutMethod();
	}
}