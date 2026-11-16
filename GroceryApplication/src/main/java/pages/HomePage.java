package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminlogin;
@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement adminlogout;
@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageText;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']") WebElement moreinformation;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and  @class=' nav-link']") WebElement deliveryboymoreinfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement categorymoreinfo;

public HomePage clickAdminButton()
{
	adminlogin.click();
	return this;
}

public LoginPage clickLogoutButton()
{
adminlogout.click();
return new LoginPage(driver);
}
public AdminUsersPage clickMoreInfo()
{
	moreinformation.click();
	return new AdminUsersPage(driver);
}
public ManageDeliveryBoyPage clickdeliveryboyinfo()
{
	deliveryboymoreinfo.click();
	return new ManageDeliveryBoyPage(driver);
}
public AddCategoryPage clickcategorymoreinfo()
{
	categorymoreinfo.click();
	return new AddCategoryPage(driver);
}
public String verifyLoginTextIsDisplayed()
{
	return loginPageText.getText();
}

}
