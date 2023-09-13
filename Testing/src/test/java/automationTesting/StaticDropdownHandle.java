package automationTesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropdownHandle {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dropdown = driver.findElement(By.id("country"));
		
		Select item = new Select(dropdown);
		
		//item.selectByValue("china");  exact match excluding or not a case sensitive
		
		//item.selectByIndex(8); no need of matching the index value is enough for retrieval
		
		item.selectByVisibleText("India"); // there should be exact match including uppercase letters
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./target/StaticDropdown.png");
		
		FileUtils.copyFile(source, destination);
		
	}
	
	

}
