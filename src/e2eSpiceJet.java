import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class e2eSpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub		
		
		System.setProperty("webdriver.chrome.driver", "D:\\CODES\\JAVA\\chromedriver.exe");
		
		String departuremonth = "April";
		String departuredate = "21";
		int i=0;		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();	// Clicking From testbox
		driver.findElement(By.xpath("//div[contains(text(),'DEL')]")).click();		// Selcting Nagpur
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();		// Selection Hyderabad
		
		System.out.println("The flight is from "+ driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).getAttribute("value"));
		System.out.println("The flight is to "+ driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).getAttribute("value"));

		//Selecting departure date

		List<WebElement> months = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		
		// finding desired month
		for(i=0;i<months.size();i+=2)
		{
			if(months.get(i).getText().contains(departuremonth))
			{	
				break;
			}
			if(months.get(i+1).getText().contains(departuremonth))
			{
				i++;
				break;
			}
			else
			{
				driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div")).click();
			}
		}
		
		// Finding the desired date in month selected
		i++;
		List<WebElement> dates = driver.findElements(By.xpath("(//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088'])["+i+"]/div[3]/div[@class='css-1dbjc4n r-6koalj r-18u37iz r-d0pm55']/div"));
		
		for(int j=0;j<dates.size();j++)
		{
			if(dates.get(j).getText().equalsIgnoreCase(departuredate))
			{
				dates.get(j).click();
				//System.out.println(dates.get(j).getText());
				break;
			}
		}
	
		// Opening passenger dropdown
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		
		for(i=0;i<2;i++)
		{
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();	// Selecting 5 Adults
		}
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();	// Clicking done
		
		driver.findElement(By.xpath("//div[contains(text(), 'INR')]")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'USD')]")).click();			// Selecting USD
		driver.findElement(By.xpath("//div[contains(text(), 'Students')]")).click();	//Selecting Students
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();	// Clicking search

		// Explicit wait for the continue window
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-1tf5bf9 r-1777fci r-1ww30s9']")));
		// Clicking checkbox
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1tf5bf9 r-1777fci r-1ww30s9']")).click();	//Ticking checkbox
		// Clicking continue
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73' and @data-focusable='true']")).click();					// Clicking continue

	}

}
