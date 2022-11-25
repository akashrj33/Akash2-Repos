package com.zoho.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zoho.generic.BaseClass;
import com.zoho.generic.ExternalFile;
import com.zoho.pom.CreateLead;
import com.zoho.pom.LeadList;

@Listeners(com.zoho.generic.ListenerImplement.class)
public class CreateNewLead extends BaseClass{
	ExternalFile f = new ExternalFile();
	@Test
	public void test1() throws EncryptedDocumentException, IOException, InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//input[@value='New Lead']")).click();		
		String leadOwner = f.getExcelData("leadsheet", 1, 3);
		String reqField = f.getExcelData("leadsheet", 1, 4);
		String fname = f.getExcelData("leadsheet", 1, 5);
		String lName = f.getExcelData("leadsheet", 1, 6);
		String designation = f.getExcelData("leadsheet", 1, 7);
		String phno = f.getExcelData("leadsheet", 1, 8);
		String mbno = f.getExcelData("leadsheet", 1, 9);
		String email = f.getExcelData("leadsheet", 1, 10);
		String fax = f.getExcelData("leadsheet", 1, 11);
		String company = f.getExcelData("leadsheet", 1, 12);
		String website = f.getExcelData("leadsheet", 1, 13);
		String noOfEmp = f.getExcelData("leadsheet", 1, 14);
		String annualRev = f.getExcelData("leadsheet", 1, 15);
		String calcTitle = f.getExcelData("leadsheet", 1, 16);
		String campaignName = f.getExcelData("leadsheet", 1, 17);
		String leadSource = f.getExcelData("leadsheet", 1, 18);
		String industry = f.getExcelData("leadsheet", 1, 19);
		String leadStatus = f.getExcelData("leadsheet", 1, 20);
		String rating = f.getExcelData("leadsheet", 1, 21);
		String street = f.getExcelData("leadsheet", 1, 22);
		String city = f.getExcelData("leadsheet", 1, 23);
		String state = f.getExcelData("leadsheet", 1, 24);
		String zip =f.getExcelData("leadsheet", 1, 25);
		String country = f.getExcelData("leadsheet", 1, 26);
		String desc = f.getExcelData("leadsheet", 1, 27);
		String type = f.getExcelData("leadsheet", 1, 28);
		CreateLead c = new CreateLead(driver);
		c.buttons();
		c.texts(leadOwner, reqField);
		c.firstnameLastnameDesignation(fname, lName, designation,type);
		c.companyWebsiteNoEmp(company, website, noOfEmp);
		c.phoneMobileMailFax(phno,mbno , email, fax);
		c.annualRevCampSource(annualRev, calcTitle, campaignName);
		c.dropdowns(leadSource, industry, leadStatus, rating);
		c.address(street, state, city, zip, country);
		c.description(desc);
		Thread.sleep(3000);
		c.save();
		Thread.sleep(3000);
		driver.findElement(By.id("Leadstab")).click();
	}
	@Test
	public void test2() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		LeadList l = new LeadList(driver);
		String n1 = f.getExcelData("leadsheet", 1, 29);
		String n2 = f.getExcelData("leadsheet", 1, 30);
		String n3 = f.getExcelData("leadsheet", 1, 31);
		String ldName = f.getExcelData("leadsheet", 1, 6);
		l.noOfLeads(n1);
		l.openLeads(n2);
		l.findLeads(ldName, n3);		
	}
	

}
