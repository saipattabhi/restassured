package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verification {
	
	WebDriver driver;
	
	public verification(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='button-wrapper']//a[text()='Questions']")
	
	public WebElement question;
	
	public WebElement questions()
	{
		
		return question;
	}
	

}
