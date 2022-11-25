package com.zoho.generic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	/**
	 * To return webelement when passed locator and driver
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findE(WebDriver driver,By locator) {
		return driver.findElement(locator);
	}
	/**
	 * To return list of webelements when passed locator and driver
	 * @param driver
	 * @param locator
	 * @return
	 */
	public List<WebElement> findEs(WebDriver driver,By locator) {
		return driver.findElements(locator);
	}
	/**
	 * Implicit wait
	 * @param driver
	 * @param seconds
	 * @param unit
	 */
	public void iWait(WebDriver driver, int seconds, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(seconds, unit);
	}
	/**
	 * ExplicitWait
	 * @param driver
	 * @param time
	 * @param e
	 */
	public void ewait(WebDriver driver, int time, ExpectedCondition<?> e ) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(e);
	}
}
