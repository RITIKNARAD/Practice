import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://web.whatsapp.com/");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions a =new Actions(driver);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'menu-bar-menu']")));
		
		driver.findElement(By.xpath("//div[@title ='Search input textbox']")).sendKeys("Kalyani");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid = 'list-item-0']")).click();
		Thread.sleep(6000);
		
		while(true)
		{			
			driver.findElement(By.xpath("//div[@data-testid = 'conversation-compose-box-input']")).sendKeys("Chutiya💓");
			//driver.findElement(By.xpath("//div[@data-testid = 'conversation-compose-box-input']")).sendKeys("Be Lavdya, Chaddit raha 🖕");
			a.sendKeys(Keys.ENTER).build().perform();	
			Thread.sleep(2000);
		}
	}

}
