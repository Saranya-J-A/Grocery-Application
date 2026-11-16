package tsetScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AddCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddCategoryTest extends Base{
	HomePage hp;
	AddCategoryPage ad;
	
	@Test(description="User is trying to add new category")
	
public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException
{
	String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
LoginPage lp=new LoginPage(driver);
lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
hp=lp.clickLoginButton();



ad=hp.clickcategorymoreinfo();


ad.clickCategoryNewButton();

String newcategory = ExcelUtility.readStringData(0, 0,"category");
ad.enterCategoryOnAddNewCategory(newcategory).selectGroupOnAddCategory().clickChooseFile().clickSaveButton();

//assertion
boolean alertmessage=ad.verifyWhetherTheCategoryAddedSuccessAlertIsDisplayed();
Assert.assertTrue(alertmessage, Constant.ADDNEWCATEGORYERROR);


}



@Test(description="User is trying to search the added category list")
public void searchtheaddedCategory() throws IOException
{
	String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
LoginPage lp=new LoginPage(driver);
lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
hp=lp.clickLoginButton();


ad=hp.clickcategorymoreinfo();

AddCategoryPage ad=new AddCategoryPage(driver);
ad.clickBlueSerachButton();

String category=ExcelUtility.readStringData(0, 0, "category");
ad.enterSearchCategory(category).clickRedSearchButton();

//assertion
String actual = ad.verifyWhetherTheListCategoryTextIsDisplayed();
String expected = "List Categories";
Assert.assertEquals(actual, expected , Constant.SEARCHADDEDCATEGORYERROR);






}
}
