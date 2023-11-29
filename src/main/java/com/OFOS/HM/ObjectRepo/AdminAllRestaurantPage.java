package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAllRestaurantPage {

	// Declaration
	@FindBy(xpath = "(//tbody/tr)[1]//i[@class='fa fa-edit']")
	private WebElement editActionBtn;

	@FindBy(xpath = "(//tbody//td)[2]")
	private WebElement updatedResName;

	// Initialization
	public AdminAllRestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getEditActionBtn() {
		return editActionBtn;
	}

	public WebElement getUpdatedResName() {
		return updatedResName;
	}
	
	

}
