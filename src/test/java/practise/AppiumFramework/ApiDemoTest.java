package practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends baseGSApp{
	
	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException
	{
		service= startAppiumServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("apiDemoApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h= new HomePage(driver);
		Preferences p= new Preferences (driver);
		Dependencies d= new Dependencies(driver);
		
		// You can call the methods or variables of the class with class objects 
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		h.Preferences.click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		p.dependencies.click();
		//driver.findElementById("android:id/checkbox").click();
		d.checkbox.click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		d.wifisettings.click();
		//driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		//d.EditText.sendKeys("Hello");
		d.EditText.sendKeys(input);
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		d.Buttons.get(1).click();
		
		service.stop();
  
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	/*
	 * Terminate all ports 
	 * taskkill /F /IM node.exe		 * 
	 */
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
