package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDemo5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		WebDriverWait wait = new  WebDriverWait(driver, 15);
		driver.findElement(By.id("checkbox")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
		WebElement checkbox = driver.findElement(By.id("ch"));
		System.out.println(checkbox.isSelected());
		
		

	}

}
