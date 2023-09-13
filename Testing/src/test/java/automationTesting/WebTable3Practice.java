package automationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable3Practice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> allrows = driver.findElements(By.xpath("//table[@id='countries']//tr"));
		
		int rowsizeCount = allrows.size();
		
		System.out.println(rowsizeCount);
		
		for(int i=1; i < rowsizeCount; i++) {
			List<WebElement> allcells = allrows.get(i).findElements(By.xpath(".//td"));
			for(WebElement celldata : allcells) {
				String Countryname = celldata.getText();
				System.out.println(Countryname);
				
				if(Countryname.equals("English")) {
					WebElement checkBox = allrows.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
					checkBox.click();
					break;
				}
			}
		}
		
		
	}

}
