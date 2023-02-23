package stepdefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.cookie;
import pageobject.crenditals;
import pageobject.joining;
import pageobject.myprofile;
import pageobject.verification;
import pageobject.welcomepage;
import resources.base;

public class page extends base {
	WebDriver driver;
	cookie intial;
	welcomepage welcome;
	joining button;
	myprofile profile;
	crenditals fields;
	verification valid;
	
	@Given("^Open the application with any browser$")
	public void Open_the_application_with_any_browser() throws Exception
	{
	 driver = intializedriver();

	}
	@And("^Navigate to the required position of the application$")
	public void  Navigate_to_the_required_position_of_the_application()
	{
		driver.get(prop.getProperty("url"));
		 intial = new cookie(driver);

		intial.button().click();

	    welcome = new welcomepage(driver);
		welcome.careers().click();

		button = new joining(driver);
		button.joinbutton().click();

	    profile = new myprofile(driver);
		profile.myprofile().click();
	}
	
	@When("^I enter username as (.+) and password as (.+) in to the fields$")
	public void I_enter_username_as_and_password_as_in_to_the_fields(String username,String password)
	{
		 fields = new crenditals(driver);
		fields.emailfield().sendKeys(username);
		fields.passwordfield().sendKeys(password);
		
	}
	@And("^I clicks on the login button$")
	public void I_clicks_on_the_login_button()
	{
		fields.loginbutton().click();
	}
	@Then("^User should see successfull (.+) after login$")
	public void User_should_see_successfull_after_login(String exceptedstatus)
	{
		 valid = new verification(driver);
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
	@After
	public void close()
	{
		driver.quit();
	}
	

}
