package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All the objects belonging to one page will be defined in Java Class
public class Preferences {
	
	//Concatenate driver
	public Preferences(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1. Preferences from XML']")
	public WebElement XML;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Launching preferences']")
	public WebElement Launching;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='4. Default values']")
	public WebElement Default;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='5. Preferences from code']")
	public WebElement code;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='6. Advanced preferences']")
	public WebElement Advanced;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='7. Fragment']")
	public WebElement Fragment;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='8. Headers']")
	public WebElement Headers;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='9. Switch']")
	public WebElement Switch;

}
