package tsetScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage out;

	@Test(description="User is trying to logout the page")
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
	LoginPage lp=new LoginPage(driver);
	lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	out=lp.clickLoginButton();
	
	
	out.clickAdminButton();
	lp=out.clickLogoutButton();
	
	//assertion
		String actual=lp.verifyLoginTextIsDisplayed();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected ,Constant.HOMETESTERROR);
			
	}
}
