package tasksJava;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksStatusCodes {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		
		List <WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println(linksList.size());
		
		for(int i=0; i<linksList.size(); i++) {
			
			WebElement element = linksList.get(i);
			
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			HttpsURLConnection httpConn = (HttpsURLConnection) link.openConnection();
			
			Thread.sleep(2000);
			
			httpConn.connect();
			
			int responseCode = httpConn.getResponseCode();
			
			if(responseCode>=400) {
				System.out.println(url + " - " + " is a broken link ");
			}
			else {
				System.out.println(url + " - " + " is a valid link ");
			}
		}
		
	}

}
