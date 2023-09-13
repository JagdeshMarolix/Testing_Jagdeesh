package actionclassPractice;

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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElement {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=610644601173&hvpos=&hvnetw=g&hvrand=9949688906710983654&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062167&hvtargid=kwd-10573980&hydadcr=14453_2316415");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement hoveredElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions ac = new Actions(driver);
		
		ac.moveToElement(hoveredElement).perform();	
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Destinantion = new File("./target/movetoElement.png");
		FileUtils.copyFile(source, Destinantion);
		
		
		

	}

}
