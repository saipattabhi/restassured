package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myprofile {
	
	
	WebDriver driver;
	
	public myprofile(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//ul[@class='menu menu-level-0']//li//a[text()='My Profile']")
	
	public WebElement myprofile;
	
	public WebElement myprofile()
	{
		
		return myprofile;
	}
	

}
