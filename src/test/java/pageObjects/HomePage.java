package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All the objects belonging to one page will be defined in Java Class
public class HomePage {
	
	//Concatenate driver
	public HomePage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Accessibility']")
	public WebElement Accessibility;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Animation']")
	public WebElement Animation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App']")
	public WebElement App;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Content']")
	public WebElement Content;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Graphics']")
	public WebElement Graphics;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Media']")
	public WebElement Media;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NFC']")
	public WebElement NFC;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OS']")
	public WebElement OS;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Text']")
	public WebElement Text;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	public WebElement Views;

}
