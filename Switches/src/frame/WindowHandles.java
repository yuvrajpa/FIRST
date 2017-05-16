package frame;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowHandles {
	
	@Test
	public void WinHandle(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\shpatil\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://accounts.google.com");
		driver.manage().window().maximize();
		System.out.println("Before switching title is :"+ driver.getTitle());
	
		String Parent_Window = driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='initialView']/footer/ul/li[3]/a")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i  = windows.iterator();
		while(i.hasNext())
		{
			String Child_Window = i.next();
			if(!Parent_Window.equalsIgnoreCase(Child_Window)){
				driver.switchTo().window(Child_Window);
				System.out.println("After switching title is :"+ driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(Parent_Window);
		System.out.println("Back to parent window  title is :"+ driver.getTitle());
		
		System.out.println("commit testing");
	}

}
