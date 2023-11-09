package testng_Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProcess {
	
//	WebDriver driver;
	
	@Test(dataProvider = "ProductAdd", dataProviderClass = PoojaStore_ProductAdd.class)
//	@Test
		public void login(String ModelNumber, String ItemTitle, String ItemDescription, String Height, String Width, String Breadth, String ColorName, String ActualPrice, String MRPPrice, String Qty) throws Throwable {
//		public void login () throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://empirehome.myprojectsonline.co.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sureshbabuemp@gmail.com");
		driver.findElement(By.id("pword")).sendKeys("ZPMHQHIA");
		driver.findElement(By.xpath("//button[@class='btn green_btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='pe-7s-keypad']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-houzz']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Add Inventory']")).click(); ////a[normalize-space()='Add Inventory']
		driver.findElement(By.xpath("//input[@name='ModelNumber']")).sendKeys(ModelNumber);
		driver.findElement(By.xpath("//textarea[@name='Title']")).sendKeys(ItemTitle);
		driver.findElement(By.name("ItemDescription")).sendKeys(ItemDescription);
		driver.findElement(By.name("Height")).sendKeys(Height);
		driver.findElement(By.name("Width")).sendKeys(Width);
		driver.findElement(By.name("Breadth")).sendKeys(Breadth);
		driver.findElement(By.name("ColorName")).sendKeys(ColorName);
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		WebElement ImageUpload = driver.findElement(By.xpath("//input[@name='ColorImageUploaded']"));
		
		ac.moveToElement(ImageUpload).click().perform();
		
		driver.findElement(By.id("actual")).sendKeys(ActualPrice);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lobicard-custom-control1\"]/div[2]/form/div[1]/div[17]/div/span/span[1]/span")).click();
		driver.findElement(By.xpath("//li[contains(text(),'1.00')]")).click();
		driver.findElement(By.id("mrp")).sendKeys(MRPPrice);
		driver.findElement(By.name("Qty")).sendKeys(Qty);
		
		
		WebElement element = driver.findElement(By.name("ProductMainImageUploaded"));
		ac.moveToElement(element).click().perform();
		
		Thread.sleep(3000);
		
		Robot rb = new Robot();
		StringSelection path = new StringSelection("C:\\Users\\Admin\\OneDrive\\Pictures\\Saved Pictures\\free-photo-of-sunlight-over-yamaha-motorbike");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
//		rb.keyPress(KeyEvent.VK_ENTER); //
//		rb.keyRelease(KeyEvent.VK_ENTER);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();
		
	}

}
