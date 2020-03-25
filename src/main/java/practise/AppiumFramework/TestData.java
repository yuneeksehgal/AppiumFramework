package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	
	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		
		//2 set of data. "Hello" , "!@#$$"
		
		Object[][] obj= new Object[][]
				{
			
			          {"Yuneek"}, {"!@#$$"}, {"Yuneek1@3"}
				};
		
				return obj;
	}
	
	
	@DataProvider(name="InputName")
	public Object[][] getDataforNameField()
	{
		
		//2 set of data. "Hello" , "!@#$$"
		
		Object[][] obj= new Object[][]
				{
			
			          {"Yuneek"}, {"Achin"}
				};
		
				return obj;
	}
}
