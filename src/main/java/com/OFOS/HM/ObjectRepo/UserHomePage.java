package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserHomePage {

	// Declaration
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement resMajorTab;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;

	// Initialization
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getResMajorTab() {
		return resMajorTab;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	// Business Library
	/**
	 * This method will Logout from the Application as an User
	 */
	WebDriver driver;

	public void userLogout() {
		//WebDriverUtility wlib = new WebDriverUtility();
		// wlib.waitUntilEleToBeClickable(driver, logoutBtn, 10);
		logoutBtn.click();
	}

}
