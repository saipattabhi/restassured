package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Exceldataconfig.exceldata;
import pageobject.cookie;
import pageobject.crenditals;
import pageobject.joining;
import pageobject.myprofile;
import pageobject.verification;
import pageobject.welcomepage;
import resources.base;

public class loginpage extends base {

public 	WebDriver driver;

	@Test(dataProvider ="getinfo")
	public void  loginpages(String username,String password,String exceptedstatus) {
		
		cookie intial = new cookie(driver);

		intial.button().click();

		welcomepage welcome = new welcomepage(driver);
		welcome.careers().click();

		joining button = new joining(driver);
		button.joinbutton().click();

		myprofile profile = new myprofile(driver);
		profile.myprofile().click();

		crenditals fields = new crenditals(driver);
		fields.emailfield().sendKeys(username);
		fields.passwordfield().sendKeys(password);
		fields.loginbutton().click();
		verification valid = new verification(driver);
		
	  String actualstatus = null ;
		try {
			if(valid.questions().isDisplayed())
			{
				actualstatus="pass";
			}
		} catch (Exception e) {
			
			actualstatus="fail";
		}

		Assert.assertEquals(actualstatus, exceptedstatus);
	}

	@BeforeMethod
	public void OpenApplication() throws Exception {
		driver = intializedriver();

		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void closebrowser() {

		driver.quit();
	}

	@DataProvider
	public  Object[][] getinfo() throws FileNotFoundException  {
		
	
		
		exceldata config = new exceldata("C:\\Users\\saipa\\eclipse-workspace\\YourSelf\\data\\worksheet.xlsx");
		 
	
		
		int rows = config.getrow(0);
		
		
		Object[][] data = new Object[rows][3];
		
		
			
				for(int i=0;i<rows;i++)
				{
			       
					data[i][0]=config.getexceldata(0, i, 0);
					

					data[i][1]=config.getexceldata(0, i, 1);

					data[i][2]=config.getexceldata(0, i, 2);
					
				}
		
		return data;

	}

}
