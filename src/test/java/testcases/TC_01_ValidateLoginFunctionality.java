package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataGenerators.DataGenerator;
import base.DriverInstance;
import pages.LoginPage;


public class TC_01_ValidateLoginFunctionality extends DriverInstance {


	@Test(dataProvider = "readExcel" )
	public void loginTest(String uname, String pass) throws Exception {
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterUsername(uname);
		loginpg.enterPasswordname(pass);
		loginpg.clickSignin();
	}
	
	@DataProvider()
	public Object[][] readExcel() throws IOException {
		return DataGenerator.readExcel("Login");
	}


}
