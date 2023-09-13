package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDemo1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		WebDriverWait wait = new WebDriverWait(driver, 10); //instantiating the webdriverwait class and creating an object for that class.
		driver.findElement(By.id("display-other-button")).click(); // clicking the button using id locator 	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));//condition to be checked after 10 secs wait
		WebElement hiddenElemenet = driver.findElement(By.id("hidden")); // finding a hidden element and storing it in a variable
		System.out.println(hiddenElemenet.isEnabled()); // checking whether the hidden element is active or not 
		 

	}

}
