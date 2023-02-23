package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class joining {
	
	WebDriver driver;
	
	public joining(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Join CGI']")
	
	public WebElement joinbutton;
	
	public WebElement joinbutton()
	{
		
		return joinbutton;
	}
	

}
