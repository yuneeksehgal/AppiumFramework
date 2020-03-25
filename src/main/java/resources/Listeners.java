package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import practise.AppiumFramework.baseGSApp;

public class Listeners implements ITestListener {
	
	@Override
	public  void onTestFailure(ITestResult result) {
		
		String s= result.getName();
		try {
			baseGSApp.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
