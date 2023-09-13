package mutliplewindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindowHandle {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String parentWindow =  driver.getWindowHandle();
//		System.out.println(parentWindow);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> ids =  driver.getWindowHandles();
		
		for(String windowids : ids) {
			System.out.println(windowids);
			
			if(!parentWindow.equals(windowids)) {
				
				driver.switchTo().window(windowids);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("Jagdeesh");
				driver.findElement(By.id("lastName")).sendKeys("Rajula");
				driver.findElement(By.id("englishchbx")).click();
				driver.findElement(By.id("hindichbx")).click();
				driver.findElement(By.id("email")).sendKeys("jagdesh@gmail.com");
				driver.findElement(By.id("password")).sendKeys("1234@");
				driver.findElement(By.id("registerbtn")).click();
				
				js.executeScript("window.scrollBy(0,250)");
				
				}
		}
		Thread.sleep(4000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys("Done by Jagdeesh");
		
	}

}
