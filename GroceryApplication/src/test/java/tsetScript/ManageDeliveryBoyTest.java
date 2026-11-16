package tsetScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage hp;
	ManageDeliveryBoyPage md;
	
@Test(description="User is trying to add new deliveryboy list")

	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException
	{
		
	String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginData");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginData");
LoginPage lp=new LoginPage(driver);
lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
lp.clickLoginButton();
	
//call home page
md=hp.clickdeliveryboyinfo();


md.clickDeliveryBoyNewbutton();

RandomDataUtility rdu=new RandomDataUtility();
String newdeliveryboyname = rdu.generateFullName();
String emailid = rdu.generateRandomEmail();
String mobilenumber = rdu.generateRandomPhoneNumber();
String address = rdu.generateRandomAddress();
String deliveryboyUsername = rdu.generateRandomUserName();
String deliveryboyPassword = rdu.generateRandomPassword();

md.enterNewDeliveryboyName(newdeliveryboyname).enternewEmailofDeliveryBoy(emailid).enterDeliveryboyNumber(mobilenumber).enterDeliveryBoyAddress(address).enterDeliveryBoyUsername(deliveryboyUsername).enterDeliveryBoyPassword(deliveryboyPassword).scrollPage().clickSaveButtonofDeliveryBoy();



	}
	
}
