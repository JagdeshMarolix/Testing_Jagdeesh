package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable2Practice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> tablerow =  driver.findElements(By.xpath("//table[@id='countries']//tr"));
		
		List<WebElement> boxes = driver.findElements(By.xpath(".//input[@class='hasVisited']"));
		
//		System.out.println(tablerow.size());
//		System.out.println(boxes.size());
		int checkboxCount = 0;
		
		for(int i = 1; i < tablerow.size(); i++) {
			
//			checkboxCount++;
			
			System.out.println(tablerow.get(i).getText());
			
			
			if(tablerow.get(i).getText().contains("Brazil")) {
				
				
				boxes.get(checkboxCount).click(); 	 
				break;
			}
			checkboxCount++;
		}
		

	}

}
