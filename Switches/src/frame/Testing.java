package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Testing {
@Test
public Testing() throws InterruptedException{
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\shpatil\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.learn-automation.com");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.switchTo().parentFrame();
	driver.findElement(By.xpath(".//a[text()='Selenium Tutorial']")).click();
	System.out.println(driver.getTitle());
	driver.navigate().back();
	System.out.println(driver.getTitle());
}
}