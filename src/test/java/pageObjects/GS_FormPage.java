package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All the objects belonging to one page will be defined in Java Class
public class GS_FormPage {
	
	//Concatenate driver
	public GS_FormPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	public WebElement getNameField()
	{
		return nameField;
	}
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	
	@AndroidFindBy(xpath="//*[@text='Male']")
	public WebElement maleOption;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement countryDropDown;
	
	@AndroidFindBy(xpath="//*[@text='Australia']")
	public WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;

	

}
