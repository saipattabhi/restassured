package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class crenditals {
	
	WebDriver driver;
	
	public crenditals(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath = "//input[@id='Inp_Login_email']")
	
	public WebElement emailfield;
	
	@FindBy(xpath = "//input[@id='Inp_Login_password']")
	
	public WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	
	public WebElement loginbutton;
	
	public WebElement emailfield()
	{
		return emailfield;
	}
	public WebElement passwordfield()
	{
		return passwordfield;
	}
	
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	

}
