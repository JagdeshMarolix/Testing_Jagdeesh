package calender_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDemo1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[normalize-space()='Selenium Practice']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Calendars Practice']")).click();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		
		String Date = "27";
		String Month = "August";
		String Year = "2034";
		
		driver.findElement(By.id("first_date_picker")).click();
		
		while(true) {
		
		String MonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(MonthYear);
		
		String []SplitedMonthYear =  MonthYear.split(" ");
		
//		System.out.println(SplitedMonthYear);
		
		String OnlyMonth =  SplitedMonthYear[0];
		String OnlyYear = SplitedMonthYear[1];
//		System.out.println(OnlyMonth);
//		System.out.println(OnlyYear);
		
		if(OnlyMonth.equalsIgnoreCase(Month) && OnlyYear.equalsIgnoreCase(Year)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		
		}
		
		}
		List<WebElement> date = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for(WebElement finalDate : date) {
			if(finalDate.getText().equals(Date)) {
				finalDate.click();
				break;
			}
		}
	}

}
