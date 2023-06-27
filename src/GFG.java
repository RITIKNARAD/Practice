import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GFG {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.geeksforgeeks.org/");
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		System.out.println("Sign In button clicked");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("luser")));
		//Thread.sleep(15000);
		
		driver.findElement(By.id("luser")).sendKeys("ritiknarad27@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Qwerty@123");
		if(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected())
		{
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		System.out.println("Signed In");
		
		driver.findElement(By.id("lower_section_text")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Practice')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Practice')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Problem of the Day')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Solve Problem')]")).click();
		
		// After clicking Solve Problem new tab is opened
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector("div[class*='problems_problem_content']")).getText());

		//driver.quit();
		
	}

}
