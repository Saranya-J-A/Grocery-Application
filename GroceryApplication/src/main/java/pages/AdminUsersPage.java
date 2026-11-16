package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
		public WebDriver driver;
		PageUtility pu=new PageUtility();
		
		public AdminUsersPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newelement;
		@FindBy(xpath="//input[@id='username']") WebElement newUsername;
		@FindBy(xpath="//input[@id='password']") WebElement newPassword;
		@FindBy(xpath="//select[@id='user_type']") WebElement selectType;
		@FindBy(xpath="//button[@name='Create']") WebElement clicksave;
		@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement blueSearch;
		@FindBy(xpath="//input[@name='un']") WebElement searchUsername;
		@FindBy(xpath="//select[@name='ut']") WebElement searchUserType;
		@FindBy(xpath="//button[@value='sr']") WebElement clickRedSearch;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlertMessage;
		@FindBy(xpath="//h4[text()='Admin Users']") WebElement adminUserSearchText;
	
	public AdminUsersPage ClickNewButton()
	{
		newelement.click();
		return this;
	}
	public  AdminUsersPage enterNewUsernameOnUsernameField(String usernamevalue1)
	{
		newUsername.sendKeys(usernamevalue1);
		return this;
	}
	public AdminUsersPage enterNewPasswordOnPasswordField(String passwordvalue1)
	{
		newPassword.sendKeys(passwordvalue1);
		return this;
	}
	public AdminUsersPage clickUsertypeinSearchAdminUsers()
	{
		pu.selectDropdownWithVisibleText(selectType,"Admin");
		//Select obj=new Select(selectType);
		//obj.selectByVisibleText("Admin");
		return this;
	}
	public AdminUsersPage clicksavebutton()
	{
		clicksave.click();
		return this;
	}
	public AdminUsersPage clickBlueSearch()
	{
		blueSearch.click();
		return this;
	
}
	public AdminUsersPage enterUsernameInSearchAdminUsers(String newusernamevalue1)
	{
		searchUsername.sendKeys(newusernamevalue1);
		return this;
	}
	public AdminUsersPage selectUserTypeinSearchAdminUsers()
	{
		pu.selectDropdownWithVisibleText(searchUserType, "Admin");
		return this;
		
	}
	public AdminUsersPage clickRedSearchButton()
	{
		clickRedSearch.click();
		return this;
	}
	//assertion
	public boolean verifyWhetherTheSuccessAlertMessageIsDiplayed()
	{
		return successAlertMessage.isDisplayed();
	}
	public String verifyWhetherTheAdminUserTextIsDisplayed()
	{
		return adminUserSearchText.getText();
	}
}
