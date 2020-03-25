package practise.AppiumFramework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.GS_CheckoutPage;
import pageObjects.GS_FormPage;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class GS_TC_3 extends baseGSApp{

	
	
		@Test (dataProvider = "InputName", dataProviderClass = TestData.class)
		public void totalValidation(String name) throws IOException, InterruptedException
		
		{
		
		service= startAppiumServer();
			
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		GS_FormPage f=new GS_FormPage(driver);
		GS_CheckoutPage c=new GS_CheckoutPage(driver);
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Yuneek");
		//f.getNameField().sendKeys("Yuneek");
		//f.nameField.sendKeys("Yuneek");
		f.nameField.sendKeys(name); // Using Parameterizing
		driver.hideKeyboard();
		
		//driver.findElementByXPath("//*[@text='Female']").click();
		f.femaleOption.click();
		
		
		//driver.findElement(By.id("android:id/text1")).click();
		f.countryDropDown.click();
				
		
		Utilities u=new Utilities(driver);
		//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
		u.scrollToText("Australia");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"India\").instance(0))");
	    //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Zambia" + "\").instance(0))")); 
		
		//driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();
		f.countrySelection.click();
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		f.shopButton.click();
		
		/*
		 * Test Case: Validate the total amount displayed in the checkout page matches
		 * with the sum of product amounts selected for shopping
		 */
		
		 driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		//ADD TO CART button text changed to ADDED to CART which means we again need to use index 0
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(4000);
		
		// For loop to sum of all added products in the cart
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sumofProducts=0;
		
		for (int i=0;i<count;i++) {
		
		//String productAmount= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		String productAmount= c.productPrice.get(i).getText();
		double amountDouble= getAmount(productAmount);
        sumofProducts=sumofProducts + amountDouble;
		}
		
		
        System.out.println("Sum of Products "+ sumofProducts);
        
		//String ActualTotal= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        String ActualTotal= c.totalAmount.getText();
        double cartTotal= getAmount(ActualTotal);
		System.out.println("Cart page Total "+cartTotal);
		
		
		Assert.assertEquals(sumofProducts, cartTotal,0);
		
		// Mobile Gestures
		
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		
		WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		service.stop();

		}
		
		
		@DataProvider(name="InputData")
		public void getDataforEditField()
		{
			
			//2 set of data. "Hello" , "!@#$$"
			
			Object[][] obj= new Object[][]
					{
				
				          {"Yuneek"}, {"!@#$$"}, {"Yuneek1@3"}
					};
			
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
	
	public static double getAmount(String value) {
		
		// Omit $ from $120.0
		value = value.substring(1);
		double doubleAmt= Double.parseDouble(value);
		
		return doubleAmt;
	}
}
