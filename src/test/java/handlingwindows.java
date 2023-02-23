import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingwindows {

	@Test
	public void handlingwindow() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//*[@class=\"clearfix dib promotions-wrap link-blocks gtm-promotions-trigger\"]")).click();
		
		driver.findElement(By.xpath("//*[@class=\"  offer-slide-item offer-blocks gtm-promotions-trigger grow\"][1]")).click();

	
		Set<String> window = driver.getWindowHandles();

		Iterator<String> itr = window.iterator();

		while (itr.hasNext()) {
			
		String randomwindow = itr.next();
		
		
		driver.switchTo().window(randomwindow);
		
		
		

		}

	}

}
