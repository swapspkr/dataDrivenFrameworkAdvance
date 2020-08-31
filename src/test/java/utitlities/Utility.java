package utitlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {




public static Object fetchUtilityValue(String key) throws IOException {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
	Properties property = new Properties();
	property.load(fis);
	return property.get(key);
}	

public static String fetchLocatorValue(String key) throws IOException {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Elements.properties");
	Properties property = new Properties();
	property.load(fis);
	return property.get(key).toString();
}	



}
