package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	//Declaration
	@FindBy(name="username")
	private WebElement userNameTxtField;
	
	@FindBy(name="password")
	private WebElement pwdTxtField;
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	//Initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUserNameTxtField() {
		return userNameTxtField;
	}

	public WebElement getPwdTxtField() {
		return pwdTxtField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library
	/**
	 * This method will login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameTxtField.sendKeys(USERNAME);
		pwdTxtField.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
}
