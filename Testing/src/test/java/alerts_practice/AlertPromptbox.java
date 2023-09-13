package alerts_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPromptbox {

	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		
		WebDriverManager.firefoxdriver().setup();
		
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("[onclick='myFunctionPrompt()']")).click();
		
		Alert promptbox = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		promptbox.sendKeys("Beautiful!");
		
	}
}