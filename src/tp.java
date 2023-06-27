import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		Actions a = new Actions(driver);
		
		Thread.sleep(5000);
		a.moveToElement(driver.findElement(By.id("form-field-travel_comp_date"))).build().perform();
		
		Thread.sleep(8000);
		//April 23
		//driver.findElement(By.id("form-field-travel_comp_date")).click();
		//driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();
		
	
	}

}
