package com.zoho.test;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zoho.generic.BaseClass;
@Listeners(com.zoho.generic.ListenerImplement.class)
public class System1 extends BaseClass{
	String CampaignName; 
	@Test(groups = "Smoke")
	public void test1a() throws IOException, InterruptedException {
		CampaignName = e.getPropertyData("CampaignName");
		c.findE(driver,By.xpath("//a[text()='Campaigns']")).click();
		c.findE(driver, By.xpath("//input[@value='New Campaign']")).click();
		c.findE(driver,By.name("property(Campaign Name)")).sendKeys(CampaignName);
		c.findE(driver, By.xpath("//input[@value='Save']")).click();
		c.findE(driver,By.xpath("//a[text()='Campaigns']")).click();
		
	}
	@Test(groups = "Smoke")
	public void test2() throws IOException, InterruptedException {
		String Company = e.getPropertyData("Company");
		String LastName = e.getPropertyData("LastName");
		c.findE(driver, By.xpath("//a[text()='Leads']")).click();
		c.findE(driver, By.xpath("//input[@value='New Lead']")).click();
		c.findE(driver,By.name("property(Company)")).sendKeys(Company);
		c.findE(driver,By.name("property(Last Name)")).sendKeys(LastName);
		c.findE(driver, By.xpath("//img[@title='Campaign Name Lookup']")).click();
		Thread.sleep(3000);
		String h = driver.getWindowHandle();
		 Set<String> w = driver.getWindowHandles();
		 for(String i:w) {
			 driver.switchTo().window(i);
		 }
		c.findE(driver, By.xpath("//a[text()='Akash']")).click();
		driver.switchTo().window(h);
		c.findE(driver, By.xpath("//input[@value='Save']")).click();
		c.findE(driver, By.xpath("//a[text()='Home']")).click();
	}

}
