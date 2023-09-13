package mutliplewindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTabs {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		
		String firstWindow =  driver.getWindowHandle();
//		System.out.println(firstWindow);
		
		driver.findElement(By.id("newTabBtn")).click();
		 Set<String> secondWindow = driver.getWindowHandles();
		 for(String mutilpeWindowids : secondWindow)
		 {
			 System.out.println(mutilpeWindowids);
			 if(!firstWindow.equals(mutilpeWindowids)) {
				 driver.switchTo().window(mutilpeWindowids);
				 driver.findElement(By.id("alertBox")).click();
				 Alert alertbox = driver.switchTo().alert();
				 
				 Thread.sleep(3000);
				 alertbox.accept();
				 
				 
				 
			 }
		 }
		 driver.switchTo().window(firstWindow);
		 driver.findElement(By.id("name")).sendKeys("Multiple Window Handled By Selenium Using SwitchTo()");

	}

}
