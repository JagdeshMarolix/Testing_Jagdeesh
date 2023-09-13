package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("fortuner");
		
		List<WebElement> carlist = driver.findElements(By.xpath("//div[@class='pcTkSc']//b"));
		
		System.out.println(carlist.size());
		
		for(WebElement options : carlist)
		{
			System.out.println(options.getText()); 
			
			if(options.getText().equals("on road price hyderabad"))
			{
				options.click();
				
			}
		}
		

	}

}
