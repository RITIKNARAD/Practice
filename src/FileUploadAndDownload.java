import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadAndDownload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//Setting the default download path to projects location
		String path = System.getProperty("user.dir");
		//System.out.println(path);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", path);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));

		
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(2000);
		
		//Uploading and downloading file
		Runtime.getRuntime().exec("D:\\CODES\\Selenium Screenshots\\fileSelectUpload.exe");
		driver.findElement(By.id("processTask")).click();


		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'downloader__btn active']")));		
		driver.findElement(By.xpath("//a[@class = 'downloader__btn active']")).click();
		Thread.sleep(8000);
		
		//Verifying that the correct file is downloaded	
		File f = new File(path+"/ExtentReports.pdf");
		if(f.exists())
		{
			System.out.println("File found");
			f.delete();		
		}
		else
		{
			System.out.println("File not found");
		}
		
		driver.quit();
	}

}
