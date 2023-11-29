package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	// Declaration
	@FindBy(xpath = "//span[text()='Restaurant']")
	private WebElement resDDTab;

	@FindBy(xpath = "//a[text()='All Restaurant']")
	private WebElement allResOption;

	@FindBy(xpath = "//a[text()='Add Restaurant']")
	private WebElement addResOption;

	@FindBy(xpath = "//img[@class='profile-pic']")
	private WebElement profilePicIcon;

	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement logoutOption;

	@FindBy(xpath = "//p[text()='Dishes']/preceding-sibling::h2")
	private WebElement noOfDishesBeforeAdding;

	@FindBy(xpath = "//span[text()='Menu']")
	private WebElement menuDDTab;

	@FindBy(xpath = "//a[text()='Add Menu']")
	private WebElement addMenuOption;

	@FindBy(xpath = "//a[text()='All Menues']")
	private WebElement allMenuOption;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardTab;

	@FindBy(xpath = "//p[text()='Dishes']/preceding-sibling::h2")
	private WebElement noOfDishesAfterAdding;

	// Initialization
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getResDDTab() {
		return resDDTab;
	}

	public WebElement getAllResOption() {
		return allResOption;
	}

	public WebElement getAddResOption() {
		return addResOption;
	}

	public WebElement getProfilePicIcon() {
		return profilePicIcon;
	}

	public WebElement getLogoutOption() {
		return logoutOption;
	}

	public WebElement getNoOfDishesBeforeAdding() {
		return noOfDishesBeforeAdding;
	}

	public WebElement getMenuDDTab() {
		return menuDDTab;
	}

	public WebElement getAddMenuOption() {
		return addMenuOption;
	}

	public WebElement getAllMenuOption() {
		return allMenuOption;
	}

	public WebElement getDashboardTab() {
		return dashboardTab;
	}

	public WebElement getNoOfDishesAfterAdding() {
		return noOfDishesAfterAdding;
	}

	// Business Library
	/**
	 * This method will Logout from the Application as an Admin
	 */
	public void adminLogout() {
		profilePicIcon.click();
		logoutOption.click();
	}

}
