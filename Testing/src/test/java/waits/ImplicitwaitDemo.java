package waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitwaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=610644601173&hvpos=&hvnetw=g&hvrand=13328131621200820498&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062167&hvtargid=kwd-10573980&hydadcr=14453_2316415");
		
		driver.get("https://www.google.com/");
		
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys("perfume for men");
		
		List<WebElement> perfumelist = driver.findElements(By.xpath("//div[@class='lnnVSe']//b"));
		
		System.out.println(perfumelist.size());
		
		for(WebElement items : perfumelist) {
			System.out.println(items.getText());
			
			if(items.getText().equals("zara")) {
				items.click();
				break;
			}
		}
		
		
		
	}

}
