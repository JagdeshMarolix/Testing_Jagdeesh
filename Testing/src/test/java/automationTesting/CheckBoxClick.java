package automationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> Daylist =  driver.findElements(By.cssSelector("input[id$='day']"));
		
		for(int i=1; i<Daylist.size()-1; i++)
		{
			Daylist.get(i).click();
		}
		
		
	}

}


//for(int i=1; i<Daylist.size()-1; i++)
//{
//	Daylist.get(i).click();
//}


