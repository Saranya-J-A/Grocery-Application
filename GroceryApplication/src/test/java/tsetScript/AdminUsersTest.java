package tsetScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	
	HomePage hp;
	AdminUsersPage au;
	
@Test(description="User is trying to add new admin users")
public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException
{
	String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
LoginPage lp=new LoginPage(driver);
lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
hp=lp.clickLoginButton();

//click adminuser more info link

au=hp.clickMoreInfo();

//
	au.ClickNewButton();
	RandomDataUtility rdu=new RandomDataUtility();
	String usernamevalue1 = rdu.generateRandomUserName();//using faker class to fetch username randomly
	String passwordvalue1 = rdu.generateRandomPassword();//using faker class to fetch the password randomly
	
	//Add new user 
	au.enterNewUsernameOnUsernameField(usernamevalue1).enterNewPasswordOnPasswordField(passwordvalue1).clickUsertypeinSearchAdminUsers();
	au.clicksavebutton();
	//Assertion
	boolean alertMessage = au.verifyWhetherTheSuccessAlertMessageIsDiplayed();
	Assert.assertTrue(alertMessage,Constant.ADMINUSERSNEWUSERADDERROR);
}

@Test(description="User is trying to search the newly added adminuser")
public void verifyWhethertheUserIsableTOSearchTheNewlyaddedAdminuser() throws IOException
{
	String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
LoginPage lp=new LoginPage(driver);
lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
hp=lp.clickLoginButton();


//click adminuser more info link

au=hp.clickMoreInfo();

//click blue search

au.clickBlueSearch();

//search user
String usernamevalue1 = ExcelUtility.readStringData(0, 0, "adminuser");
au.enterUsernameInSearchAdminUsers(usernamevalue1).selectUserTypeinSearchAdminUsers().clickRedSearchButton();

//Assertion
String actual = au.verifyWhetherTheAdminUserTextIsDisplayed();
String expected = "Admin Users";
Assert.assertEquals(actual, expected ,Constant.ADMINUSERSEARCHADDEDUSERERROR);

	
}
}
