package com.zoho.pom;


import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class CreateLead {
	WebDriver driver;
	
	@FindBy(xpath = "(//input[@value='Save'])[1]")
	private WebElement save1;
	
	@FindBy(xpath = "(//input[@value='Save'])[2]")
	private WebElement save2;
	
	@FindBy(xpath = "(//input[@value='Save & New'])[1]")
	private WebElement save_new1;
	
	@FindBy(xpath = "(//input[@value='Save & New'])[2]")
	private WebElement save_new2;
	
	@FindBy(name = "Cancel")
	private List<WebElement> cancel;
	
	@FindBy(xpath = "//div[contains(text(),'rashmi')]")
	private WebElement leadowner;
	
	@FindBy(name = "property(saltName)")
	private WebElement name;
	
	@FindBy(name = "property(First Name)")
	private WebElement fname;
	
	@FindBy(name = "property(Designation)")
	private WebElement designation;
	
	@FindBy(name = "property(Phone)")
	private WebElement phone;
	
	@FindBy(name = "property(Mobile)")
	private WebElement mobile;
	
	@FindBy(name = "property(Company)")
	private WebElement company;
	
	@FindBy(name = "property(Last Name)")
	private WebElement lname;
	
	@FindBy(name = "property(Email)")
	private WebElement email;
	
	@FindBy(name = "property(Fax)")
	private WebElement fax;
	
	@FindBy(name = "property(Website)")
	private WebElement website;
	
	@FindBy(name = "property(Lead Source)")
	private WebElement leadsource;
	
	@FindBy(name = "property(Industry)")
	private WebElement industry;
	
	@FindBy(name = "property(Annual Revenue)")
	private WebElement aRevenue;
	
	@FindBy(name = "//img[@title='Calculator']")
	private WebElement calc;
	
	@FindBy(name = "property(Campaign Source)")
	private WebElement cSource;
	
	@FindBy(name = "property(Lead Status)")
	private WebElement leadStatus;
	
	@FindBy(name = "property(No of Employees)")
	private WebElement noOfEmp;
	
	@FindBy(name = "property(Rating)")
	private WebElement rating;
	
	@FindBy(name = "property(Street)")
	private WebElement street;
	
	@FindBy(name = "property(State)")
	private WebElement state;
	
	@FindBy(name = "property(Country)")
	private WebElement country;
	
	@FindBy(name = "property(City)")
	private WebElement city;
	
	@FindBy(name = "property(Zip Code)")
	private WebElement zip;
	
	@FindBy(name = "property(Description)")
	private WebElement desc;
	
	@FindBy(xpath = "//div[text()='* Required Field(s)']")
	private WebElement reqField;
	
	@FindBy(xpath = "//img[@title='Campaign Name Lookup']")
	private WebElement cLookup;
	
	
	public CreateLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void buttons() {
		Assert.assertTrue(save1.isEnabled());
		Assert.assertTrue(save2.isEnabled());
		Assert.assertTrue(save_new1.isEnabled());
		Assert.assertTrue(save_new2.isEnabled());
		Assert.assertTrue(cancel.get(0).isEnabled());
		Assert.assertTrue(cancel.get(1).isEnabled());
		Reporter.log("All Buttons are enabled");
	}
	public void texts(String t1, String t2) {
		String text1 = leadowner.getText();
		String text2 = reqField.getText();
		Assert.assertEquals(text1, t1);
		Assert.assertEquals(text2, t2);
		Reporter.log("All texts are displayed");
	}
	public void firstnameLastnameDesignation(String type,String firstName,String lastName, String designa) {
		//Select s = new Select(name);
		//s.selectByVisibleText(type);
		fname.sendKeys(firstName);
		lname.sendKeys(lastName);
		designation.sendKeys(designa);
	}
	public void phoneMobileMailFax(String phno, String mbno, String mail, String fx) {
		phone.sendKeys(phno);
		mobile.sendKeys(mbno);
		email.sendKeys(mail);
		fax.sendKeys(fx);
	}
	public void companyWebsiteNoEmp(String comp, String web, String noOfEmp2) {
		company.sendKeys(comp);
		website.sendKeys(web);
		noOfEmp.sendKeys(noOfEmp2);	
	}
	
	public void annualRevCampSource(String annualRev, String ctitle, String Campaignname) throws InterruptedException {
		aRevenue.sendKeys(""+annualRev);
		String parent = driver.getWindowHandle();
		/*
		Actions a = new Actions(driver);
		a.moveToElement(calc);
		Thread.sleep(3000);
		a.doubleClick(calc);
		calc.click();
		Thread.sleep(2000);
		Set<String> win = driver.getWindowHandles();
		for(String i:win) {
		driver.switchTo().window(i);
		}
		String atitle = driver.getTitle();
		Assert.assertEquals(atitle, ctitle);
		driver.close();
		driver.switchTo().window(parent);*/
		cLookup.click();
		Thread.sleep(2000);
		Set<String> win1 = driver.getWindowHandles();
		for(String i:win1) {
		driver.switchTo().window(i);
		}
		driver.findElement(By.xpath("//a[text()='"+Campaignname+"']")).click();
		driver.switchTo().window(parent);	
	}
	public void dropdowns(String leadsrc,String indus,String lStatus,String rate) {
		Select s = new Select(leadsource);
		s.selectByVisibleText(leadsrc);
		Select s1 = new Select(industry);
		s1.selectByVisibleText(indus);
		Select s2 = new Select(leadStatus);
		s2.selectByVisibleText(lStatus);
		Select s3 = new Select(rating);
		s3.selectByVisibleText(rate);
	}
	public void address(String street1, String state1,String city1, String zip2, String country1 ) {
		street.sendKeys(street1);
		state.sendKeys(state1);
		city.sendKeys(city1);
		zip.sendKeys(zip2);
		country.sendKeys(country1);
	}
	public void description(String info) {
		desc.sendKeys(info);
	}
	public void save() {
		save1.click();
	}
}
