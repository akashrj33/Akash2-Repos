package com.zoho.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LeadList {
	
	@FindBy(xpath = "(//a[text()='asd'])[2]/../../td[2]//a[text()='Edit']")
	private WebElement edit;
	
	@FindBy(xpath = "(//a[text()='asd'])[2]/../../td[2]//a[text()='Del']")
	private WebElement del;
	
	@FindBy(xpath = "//input[@value ='New Lead']")
	private WebElement newlead;
	
	@FindBy(name = "cvid")
	private WebElement viewLeads;
	
	@FindBy(name = "searchString")
	private WebElement findLeads;
	
	
	@FindBy(name = "Go")
	private WebElement go;
	
	@FindBy(name = "chk")
	private WebElement checkBox;
	
	@FindBy(xpath = "//td[@class='tableData']/../td[3]/a")
	private List<WebElement> leadNames;
	
	@FindBy(xpath = "//input[@value = 'Change Status']")
	private WebElement changeStatus;
	
	@FindBy(xpath = "//input[@value = 'Create Task']")
	private WebElement createTask;
	
	@FindBy(xpath = "//input[@value = 'Delete']")
	private WebElement delete;
	
	public LeadList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void noOfLeads(String n1) {		
		int count = leadNames.size();
		String count1 = ""+count;
		Assert.assertEquals(count1, n1);
	}
	public void openLeads(String n2) throws InterruptedException {
		Select s = new Select(viewLeads);
		s.selectByValue("9");
		Thread.sleep(3000);
		int count = leadNames.size();
		String count1 = ""+count;
		Assert.assertEquals(count1, n2);
	}
	public void findLeads(String leadName,String n3) throws InterruptedException {
		findLeads.sendKeys(leadName);
		go.click();
		Thread.sleep(3000);
		int count = leadNames.size();
		String count1 = ""+count;
		Assert.assertEquals(count1, n3);
	}
	
	

}
