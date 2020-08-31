package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utitlities.Utility;

public class DriverInstance {

	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws IOException{
		
		if (Utility.fetchUtilityValue("browser").toString().equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
			driver = new ChromeDriver();			
			
		}else if (Utility.fetchUtilityValue("browser").toString().equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();
			//log.info("Firefox browser Launched !!");

		}
		driver.get(Utility.fetchUtilityValue("testsiteurl").toString());
	} 
	
	@AfterMethod
	public void closeDriverInstance(){
		
	driver.quit();	
	}
}
