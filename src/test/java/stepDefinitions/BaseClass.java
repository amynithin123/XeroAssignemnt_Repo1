package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	public static Logger logger;
	public Properties configProp;

	
	

	
	
	// Created for generating random string for Account Name 
		public static String randomString() {

			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}
		// Created for generating random numbers for Account Number	
		public static String randomNumbers() {

			String generatedNo = RandomStringUtils.randomNumeric(10);
			return (generatedNo);
		}

}
