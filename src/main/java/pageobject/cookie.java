package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cookie {
	
	WebDriver driver;
	
	public cookie(WebDriver driver)
	{
		
		this.driver=driver;
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@id='popup-buttons']//button[text()='Accept all cookies']")
	public WebElement button;
	
	public WebElement button()
	{
		return button;
	}
	

}
