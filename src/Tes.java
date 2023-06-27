import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tes {

	public static void main(String[] args) {
		
		// setting the path for chrome driver. This step is now optional as SeleniumManager will take care of it if we don;t mention.
		// ChromeDriver.exe is the middleman as selenium cannot directly start/communicate with chrome browser and need this to do so
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RITIK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		// Starting the chrome browser
		WebDriver driver = new ChromeDriver();
		
		// giving implicit wait, it means max it will wait for 5 sec to any element to get load. But if the element gets loaded in 1sec then it will go ahead to next line and will not wait for whole 5 sec 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Hitting the url
		driver.get("https://www.saudewala.in/account/login");
		
		// Getting the tab title just for verification and printing it on console
		System.out.println(driver.getTitle());
		
		// Getting the current tab URL just for verification and printing it on console
		System.out.println(driver.getCurrentUrl());
		
		// sending values for id, pass field and clicking submit
		driver.findElement(By.id("CustomerEmail")).sendKeys("ritiknarad27@gmail.com");
		driver.findElement(By.id("CustomerPassword")).sendKeys("Qwerty@123");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		
		// Clicking the checkbox
		driver.findElement(By.xpath("//span/div")).click();
		System.out.println("Captch clicked");
		
		
		// Clicking submit
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		//driver.findElement(By.className("header-main__signup login-modal-btn")).click();
		
		
		
		//driver.quit();

	}

}
