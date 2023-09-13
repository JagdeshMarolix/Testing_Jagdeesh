package fileUploading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelFileUploading {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://poojastore.marolix.com/Authenticate/Login");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		File file = new File("./target/UserNames.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		
		int cells = sheet.getRow(1).getLastCellNum();
		
		sheet.getRow(1).getLastCellNum();
		
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<cells; j++) {
				
				DataFormatter df = new DataFormatter();
				
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				
			}
		}
		

	}

}
