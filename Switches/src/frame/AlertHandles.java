package frame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AlertHandles {
@Test(dataProvider="getData")
public void alerts1(String FromPlace){
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\shpatil\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.ksrtc.in");
	driver.findElement(By.xpath(".//*[@id='fromPlaceName']")).sendKeys(FromPlace);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.getMessage();
	}
	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	Alert alert = driver.switchTo().alert();
	String AlertMsg = alert.getText();
	System.out.println(AlertMsg);
	alert.accept();
}

@DataProvider
public Object[][] getData(){
	Object[][] data =new Object[1][2];
	data[0][0] ="delhi";
	data[0][1] ="Hyderabad";
	return data;

}
}