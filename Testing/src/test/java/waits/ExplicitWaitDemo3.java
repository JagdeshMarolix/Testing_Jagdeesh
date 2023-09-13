package waits;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDemo3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(By.id("populate-text")).click();
//		Boolean element =  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("target-text"), "Selenium Webdriver"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("target-text")));
		WebElement textpresent = driver.findElement(By.className("target-text"));
		System.out.println(textpresent.isDisplayed());
		
	}

}
