package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		List<WebElement> countrylist = driver.findElements(By.xpath("//table[@id='countries']//tr//td[2]"));
		
		for(WebElement ele : countrylist)
		{
			System.out.println(ele.getText());
		}
			
//		if(ele.getText().equals("Cameroon"));
//		{
//			
//			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
////				ele.click();
//			}
//		}
//		driver.findElement(By.xpath("//td[strong='Fiji']//preceding-sibling::td//input")).click();
//		driver.findElement(By.xpath("//td[text()='Manama']//preceding-sibling::td//input")).click();
		

	}

}


//table[@id='countries']

//table[contains(@id, 'count')] partial xpath with linked text to the same table 

//table[@id='countries']//tr for all tables in the row including headers

//table[@id='countries']//td for all the data inside the table rows and columns

//table[@id='countries']//tr//td[2] for all the countries within the table

//td[strong='Cameroon'] for exact match with in the countries column

//td[strong='Cameroon']//following::td for the next verification of the data which starts from cameroon

//td[strong='Cameroon']//preceding-sibling::td//input for traversing in a reverse direction 

//input[@type='checkbox']

//td[text()='Manama']//preceding-sibling::td//input for any checkbox click
	