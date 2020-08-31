package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utitlities.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public void enterUsername(String uname) throws Exception {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("loginusername_XPATH"))).sendKeys("uname");
	}

	public void enterPasswordname(String pass) throws Exception {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("loginpassword_XPATH"))).sendKeys("pass");
	}

	public void clickSignin() throws Exception {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("signin_XPATH"))).click();
	}

	public void clickSignUp()throws Exception {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("signup_XPATH"))).click();
	}

	public void clickRememberMe() throws Exception{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("rememberme_XPATH"))).click();
	}
}
