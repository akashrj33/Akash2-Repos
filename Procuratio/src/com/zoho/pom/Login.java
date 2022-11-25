package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id = "userName")
	private WebElement untb;
	@FindBy(id = "passWord")
	private WebElement pwtb;
	@FindBy(xpath = "//input[@title = 'Sign In']")
	private WebElement lgbtn;
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pwd) {
		untb.sendKeys(un);
		pwtb.sendKeys(pwd);
		lgbtn.click();
	}

}
