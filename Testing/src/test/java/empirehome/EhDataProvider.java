package empirehome;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EhDataProvider {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://empirehome.myprojectsonline.co.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sureshbabuemp@gmail.com");
		driver.findElement(By.id("pword")).sendKeys("ZPMHQHIA");
		driver.findElement(By.xpath("//button[@class='btn green_btn']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='pe-7s-keypad']")).click();
		
		driver.findElement(By.xpath("//i[@class='fa fa-houzz']")).click();
		
		driver.findElement(By.xpath("//li[@class='treeview active']//li[8]")).click();
		
		File file = new File("./target/ProductDetails.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		
		XSSFSheet sheet =  workbook.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		
		int cells = sheet.getRow(1).getLastCellNum();
		
		for(int i=1; i<rows; i++) {
			
			for(int j=0; j<cells; j++) {
				
				DataFormatter df = new DataFormatter();
				
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
		}
	}

}
