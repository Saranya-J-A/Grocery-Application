package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
public WebDriver driver;
WaitUtility wu=new WaitUtility();

public LoginPage(WebDriver driver)
{
this.driver=driver;	
PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement button;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageText;



public LoginPage enterUsernameOnUsernameField(String usernamevalue)
{
	username.sendKeys(usernamevalue);
	return this;
}

public LoginPage enterPasswordOnPasswordField(String passwordvalue)
{
	password.sendKeys(passwordvalue);
	return this;
}

public HomePage clickLoginButton()
{
	wu.waitUntilElementToBeClickable(driver, button);
	button.click();
	return new HomePage(driver);
}
//assertion
public boolean verifyWhetherDashboardIsDisplayed()
{
	return dashboard.isDisplayed();
}
public String verifyLoginTextIsDisplayed()
{
	return loginPageText.getText();
}








}
