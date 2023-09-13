package automationTesting;

import java.io.File;
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

public class MeeshoDropDown {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.meesho.com/");
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		WebElement click = driver.findElement(By.xpath("//input[@font-weight='book']"));
		
		click.click();
		
		click.sendKeys("jeans for men");
		
		Thread.sleep(2000);
		
		List<WebElement> itemsList =  driver.findElements(By.xpath("//p[@class='sc-eDvSVe hpsLdS sc-AHaJN puxZX sc-AHaJN puxZX']"));
		
		System.out.println(itemsList.size());
		
		for(WebElement options : itemsList)
		{
			System.out.println(options.getText());
//			
			if(options.getText().equals("jeans for men blue"))
			{
				options.click();
				break;
			}
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File Destination = new File("./target/Meesho.png");
		
		FileUtils.copyFile(source, Destination);
	

	}

}
