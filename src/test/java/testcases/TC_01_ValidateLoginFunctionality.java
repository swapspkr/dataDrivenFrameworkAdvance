package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.DriverInstance;
import pages.LoginPage;

public class TC_01_ValidateLoginFunctionality extends DriverInstance {

	
	@Test(dataProvider="LoginCredentials")
	public void loginTest(String uname, String pass) throws Exception {
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterUsername(uname);
		loginpg.enterPasswordname(pass);
		loginpg.clickSignin();
		
	}
	
	@DataProvider(name="LoginCredentials")
	public Object dataGenerator() {
		
		Object[][] data = {{"user1","pwd1"},{"user2","pwd2"},{"user3","pwd3"}};
		
		return data;
	}
}
