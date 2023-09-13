package screenshotPractice;

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

public class GetScreenshot {

	public static void main(String[] args) throws IOException { //vfb-6-0  //vfb-6-2
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.guru99.com/test/radio.html");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
//	System.out.println(checkboxes.size());
//	for(int i=0; i<(checkboxes.size()); i++) {
//		checkboxes.get(0).click();
//		checkboxes.get(2).click();
//		
//		}
	for(WebElement items : checkboxes) {
		String ids = items.getAttribute("id");
		System.out.println(ids);
		if((ids.equals("vfb-6-0")) || (ids.equals("vfb-6-2"))) {
			items.click();
	}
	
	}
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File("./target/guru99screenshot.png");
	FileUtils.copyFile(source, destination);

}
}
