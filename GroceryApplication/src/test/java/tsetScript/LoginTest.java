package tsetScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })

	public void verifyUserLoginWithValidCredentials() throws IOException {

		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=lp.clickLoginButton();
//assertion

		boolean dashboardValue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardValue,Constant.VALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "User is trying to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String usernamevalue = ExcelUtility.readStringData(1, 0, "LoginData");
		String passwordvalue = ExcelUtility.readStringData(1, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();
		// assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDANDINVALIDERROR);

	}

	@Test(priority = 3, description = "User is trying to login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(2, 0, "LoginData");
		String passwordvalue = ExcelUtility.readStringData(2, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();

		// assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDANDVALIDERROR);

	}

	@Test(priority = 4, description = "User is trying to login with invalid credentials", groups = {
			"smoke" }, dataProvider = "LoginData")
	public void verifyUserLoginWithInvalidCredentials(String usernamevalue, String passwordvalue) throws IOException {

		// String usernamevalue = ExcelUtility.readStringData(3, 0, "LoginData");
		// String passwordvalue = ExcelUtility.readStringData(3, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();

		// assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDCREDENTIALSERROR2);

	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Admin", "admin22" }, new Object[] { "Admin12", "admin1" },

		};
	}
}
