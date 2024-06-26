package apiTestingFrameWork.SetUpStripeAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import apiTestingFrameWork.UtilitiesStripeAPI.ExcelReader;
import io.restassured.RestAssured;

public class BaseTest {
	public static Properties config= new Properties();
	public FileInputStream fis;
	public static ExcelReader excel= new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp()   {
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\propertiesOfStripeAPI\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI=config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
		
	}
	@AfterSuite
	public void tearDown() {
		
	}

}
