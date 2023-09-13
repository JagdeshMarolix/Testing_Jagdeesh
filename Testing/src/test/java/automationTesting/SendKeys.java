package automationTesting;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeys {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup(); // for setting up without .exe file 
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("JAGGU");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jagdeeshrajula@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8143234734"); 
		
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Chicago, USA");
		
		driver.findElement(By.id("male")).click();
		
		List<WebElement> Daylist = driver.findElements(By.cssSelector("input[id$='day']"));
		
//		System.out.println(Daylist.get(1));
		
		System.out.println(Daylist.size());
		
		for(int i=1; i<Daylist.size()-1; i++)
		{
			Daylist.get(i).click();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./target/Daylist.png");
		FileUtils.copyFile(source, destination);
		
	}

}
