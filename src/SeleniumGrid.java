import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	@Test
	public void demo() throws MalformedURLException
	{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444"), dc);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.quit();				
	}
	
	@Test
	public void demo1() throws MalformedURLException
	{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444"), dc);
		driver.get("https://www.udemy.com/");
		System.out.println(driver.getTitle());
		driver.quit();			
	}
	
	@Test
	public void demo2() throws MalformedURLException
	{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444"), dc);
		driver.get("https://www.geeksforgeeks.org/");
		System.out.println(driver.getTitle());
		driver.quit();			
	}

}
