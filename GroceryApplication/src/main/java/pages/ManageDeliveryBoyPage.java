package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
public WebDriver driver;

public ManageDeliveryBoyPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement deliveryBoyNewbutton;
	@FindBy(xpath="//input[@id='name']") WebElement deliveryBoyNewName;
	@FindBy(xpath="//input[@id='email']") WebElement deliveryboyEmail;
	@FindBy(xpath="//input[@id='phone']") WebElement deliveryBoymobileNumber;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']") WebElement deliveryBoyAddress;
	@FindBy(xpath="//input[@placeholder='Enter the Username']") WebElement deliveryBouUsername;
	@FindBy(xpath="//input[@placeholder='Enter the Password']") WebElement deliveryBoyPassword;
	@FindBy(xpath="//button[@type='submit']") WebElement clickDeliveryBoySaveButton;
	
	
	
	public ManageDeliveryBoyPage clickDeliveryBoyNewbutton()
	{
		deliveryBoyNewbutton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterNewDeliveryboyName(String newdeliveryboyname)
	{
		deliveryBoyNewName.sendKeys(newdeliveryboyname);
		return this;
	}
	
	public ManageDeliveryBoyPage enternewEmailofDeliveryBoy(String emailid)
	{
		deliveryboyEmail.sendKeys(emailid);	
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryboyNumber(String mobilenumber)
	{
		deliveryBoymobileNumber.sendKeys(mobilenumber);
		return this;
	}
	
	public ManageDeliveryBoyPage enterDeliveryBoyAddress(String address)
	{
		deliveryBoyAddress.sendKeys(address);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryBoyUsername(String deliveryboyUsername)
	{
		deliveryBouUsername.sendKeys(deliveryboyUsername);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryBoyPassword(String deliveryboyPassword)
	{
		deliveryBoyPassword.sendKeys(deliveryboyPassword);
		return this;
	}

	public ManageDeliveryBoyPage scrollPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)","");
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButtonofDeliveryBoy()
	{
		clickDeliveryBoySaveButton.click();
		return this;
	}
	
	
}
