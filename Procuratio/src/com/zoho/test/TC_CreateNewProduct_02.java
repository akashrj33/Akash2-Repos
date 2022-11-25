package com.zoho.test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zoho.generic.BaseClass;


public class TC_CreateNewProduct_02 extends BaseClass{
	
	@Test
	public void test1() throws InterruptedException {
		c.findE(driver, By.xpath("//a[text()='Products']")).click();
		c.findE(driver, By.xpath("//input[@value='New Product']")).click();
		c.findE(driver,By.name("property(Product Name)")).sendKeys("Akash");
		Thread.sleep(2000);
		c.findE(driver, By.xpath("//input[@value='Save']")).click();
		c.findE(driver, By.name("Delete2")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	@Test
	public void test2() throws InterruptedException {
		c.findE(driver, By.xpath("//a[text()='Products']")).click();
		c.findE(driver, By.xpath("//input[@value='New Product']")).click();
		c.findE(driver, By.xpath("//input[@value='Save']")).click();
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		Assert.assertEquals(text, "Product Name cannot be empty");
		a.accept();
	}
	@Test
	public void test3(){
		c.findE(driver, By.xpath("//a[text()='Products']")).click();
		c.findE(driver, By.xpath("//input[@value='New Product']")).click();
		c.findE(driver,By.name("property(Product Name)")).sendKeys("@@@@@");
		c.findE(driver, By.xpath("//input[@value='Save']")).click();
		String value = c.findE(driver, By.name("Delete2")).getAttribute("value");
		Assert.assertNotEquals(value, "Delete");
	}
		
}

