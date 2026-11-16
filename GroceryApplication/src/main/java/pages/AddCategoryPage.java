package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	public WebDriver driver;
	public AddCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement categoryNewButton;
	@FindBy(xpath="//input[@id='category']") WebElement enterCategory;
	@FindBy(xpath="//li[@id='2-selectable']") WebElement selectGroups;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement blueSearchButton;
	@FindBy(xpath="//input[@name='un']") WebElement searchCategory;
	@FindBy(xpath="//button[@value='sr']") WebElement redSearchButton;
	@FindBy(xpath="//h4[text()='List Categories']") WebElement listCategoryText;
	
	
	
	
	
	
	
	
	public AddCategoryPage clickCategoryNewButton()
	{
		categoryNewButton.click();
		return this;
	}
	
	public AddCategoryPage enterCategoryOnAddNewCategory(String newcategory)
	{
		enterCategory.sendKeys(newcategory);
		return this;
	}
	public AddCategoryPage selectGroupOnAddCategory()
	{
		selectGroups.click();
		return this;
	}
	
	public AddCategoryPage clickChooseFile()
	{
		chooseFile.sendKeys("C:\\Users\\saran\\Downloads\\images.jpg");
		return this;
	}
	
	public AddCategoryPage clickSaveButton()
	{
		Actions action=new Actions(driver);
		action.click(saveButton).perform();
		return this;
	}
	public AddCategoryPage clickBlueSerachButton()
	{
		blueSearchButton.click();
		return this;
	}
	public AddCategoryPage enterSearchCategory(String category)
	{
		searchCategory.sendKeys(category);
		return this;
	}
	public AddCategoryPage clickRedSearchButton()
	{
		redSearchButton.click();
		return this;
	}
	public boolean verifyWhetherTheCategoryAddedSuccessAlertIsDisplayed()
	{
		return successAlert.isDisplayed();
	}
	public String verifyWhetherTheListCategoryTextIsDisplayed()
	{
		return listCategoryText.getText();
	}
	
}
