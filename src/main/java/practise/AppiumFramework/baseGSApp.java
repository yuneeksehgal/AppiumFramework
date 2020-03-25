package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseGSApp {
	
	
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startAppiumServer()
	
	{
		boolean flag = checkIfServerIsRunnning(4723);
		
		if (!flag) {
		service= AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}

	public static void startEmulator() throws IOException, InterruptedException
	{
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Runtime.getRuntime().exec("cd C:\\android-sdk\\emulator && emulator -avd YuneekEmulatorPie");
		Thread.sleep(10000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		
				
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
	
		
		
		// TODO Auto-generated method stub
		File appDir=new File("src");
		File app=new File(appDir,(String) prop.get(appName));
		
		System.out.println("Value stored in app is " + app.getAbsolutePath());
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//StartEmulator
		
		//String device= (String) prop.get("device");
		String device=System.getProperty("deviceName"); //Getting deviceName from Maven command
	
		 //if(device.contains("Emulator")) { startEmulator(); }
		
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
        driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        
        return driver;
        
        
	}
	
	
	public static void getScreenshot(String s) throws IOException {

		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));



		}
	
	public static boolean checkIfServerIsRunnning(int port) {


		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {

		serverSocket = new ServerSocket(port);
		serverSocket.close();

		} catch (IOException e) {

		// If control comes here, then it means that the port is in use

		isServerRunning = true;

		} finally {

		serverSocket = null;

		}

		return isServerRunning;

		}

}
