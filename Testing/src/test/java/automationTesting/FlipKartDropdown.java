package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//div[@class='ytd-searchbox-spt']")).sendKeys("Indian flag making");
//		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("iphone 14 pro max");
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("watches");
		List<WebElement> watcheslist = driver.findElements(By.xpath("//li[@class='suggestionList_menuitem unstructuredList']"));
		System.out.println(watcheslist.size());
		for(WebElement options : watcheslist) {
			System.out.println(options.getText());
			if(options.getText().equals("Watches For Men"))
				options.click();
			break;
		}
		
		

	}

}
