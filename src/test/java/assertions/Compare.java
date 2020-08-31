package assertions;

import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validatePageTitle(WebDriver driver, String expectedTitle) {
		
		boolean flag=false;
		if(driver.getTitle().equalsIgnoreCase(expectedTitle)) {
			flag=true;			
		}
		
		return flag;
	}
	
	public static boolean validatePageUrl(WebDriver driver, String expectedPageUrl) {
		
		boolean flag=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedPageUrl)) {
			flag=true;			
		}
		
		return flag;	
	}
}