package com.zoho.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.zoho.pom.Login;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	}
	
	public CommonMethods c = new CommonMethods();
	public static WebDriver driver; // why it should be static ????
	public ExternalFile e = new ExternalFile();
	/**
	 * To open browser
	 * @param driver
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@BeforeTest
	public void urlopen() throws IOException, InterruptedException {		
		driver = new ChromeDriver();
		c.iWait(driver, 10,TimeUnit.SECONDS);
		String url = e.getPropertyData("url");
		driver.get(url);
		driver.manage().window().maximize();
	}
	/**
	 * To close browser
	 * @param driver
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@BeforeMethod
	public void login() throws IOException {
		String un = e.getPropertyData("un");
		String pwd = e.getPropertyData("pwd");
		Login l = new Login(driver);
		l.login(un, pwd);
	}
	/**
	 * To Logout
	 */
	@AfterMethod
	public void logout() {
		c.findE(driver, By.xpath("//a[text()='Logout [rashmi@dell.com]']")).click();
	}
	/**
	 * To close browser
	 */
	@AfterTest
	public void closeurl() {
		driver.close();
	}

}
