package empirehome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EhDataProvider {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://empirehome.myprojectsonline.co.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sureshbabuemp@gmail.com");
		driver.findElement(By.id("pword")).sendKeys("ZPMHQHIA");
		driver.findElement(By.xpath("//button[@class='btn green_btn']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='pe-7s-keypad']")).click();
		
		driver.findElement(By.xpath("//i[@class='fa fa-houzz']")).click();
		
		driver.findElement(By.xpath("//li[@class='treeview active']//li[8]")).click();
		
	}

}
