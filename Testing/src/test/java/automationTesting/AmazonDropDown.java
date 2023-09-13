package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("refrigrators");
		
		List<WebElement> fridges = driver.findElements(By.xpath("//div[@class='s-suggestion-container']//span"));
		
		System.out.println(fridges.size());
		
		for(WebElement options : fridges)
		{
			System.out.println(options.getText());
			
			if(options.getText().equals("side by side refrigerators")) {
				options.click();
				break;
				
			}
		}

	}

}
