package day28;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo6 {

//print the content of the web table
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Workbook wb1 = WorkbookFactory.create(new FileInputStream("./data/Selenium.xlsx"));
		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).sendKeys("java");

		String xp = "//span[contains(text(),'java')]";
		List<WebElement> allASE = driver.findElements(By.xpath(xp));

		int count = allASE.size();
		System.out.println(count);

		for (int i = 0; i < count; i++) {

			String text = allASE.get(i).getText();

			wait.until(ExpectedConditions.titleContains("Google"));

			System.out.println((i + 1) + "." + (text));

			wb1.getSheet("java").getRow(i).createCell(1).setCellValue(text);

			wb1.write(new FileOutputStream("./data/Selenium.xlsx"));// Save
		}

	}
}
