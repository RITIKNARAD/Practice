import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RITIK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://in.tradingview.com/");		
		System.out.println(driver.getCurrentUrl());
		
		/*driver.navigate().to("https://www.geeksforgeeks.org/");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();		
		System.out.println(driver.getCurrentUrl());*/
		
		driver.findElement(By.cssSelector("button[class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Google')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Email or phone')]")).sendKeys("pratibhanara03@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Enter your password')]")).sendKeys("8378819036");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		//driver.close();

	}

}
