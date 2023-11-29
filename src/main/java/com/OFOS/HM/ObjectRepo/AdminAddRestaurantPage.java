package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddRestaurantPage {
	
	//Declaration
	@FindBy(name="res_name")
	private WebElement resNameTxtField;
	
	@FindBy(name="email")
	private WebElement emailTxtField;
	
	@FindBy(name="phone")
	private WebElement phoneNoTxtField;
	
	@FindBy(name="url")
	private WebElement urlTxtField;
	
	@FindBy(xpath="//label[text()='Open Hours']/following-sibling::select[@class='form-control custom-select']")
	private WebElement openHoursDD;
	
	@FindBy(xpath="//label[text()='Close Hours']/following-sibling::select[@class='form-control custom-select']")
	private WebElement closeHoursDD;
	
	@FindBy(xpath="//label[text()='Open Days']/following-sibling::select[@class='form-control custom-select']")
	private WebElement openDays;
	
	@FindBy(id="lastName")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath=
			"//label[text()='Select Category']/following-sibling::select[@class='form-control custom-select']")
	private WebElement selectCategoryDD;
	
	@FindBy(name="submit")
	private WebElement saveBtn;
	
	//Initialization
	public AdminAddRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getResNameTxtField() {
		return resNameTxtField;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getPhoneNoTxtField() {
		return phoneNoTxtField;
	}

	public WebElement getUrlTxtField() {
		return urlTxtField;
	}

	public WebElement getOpenHoursDD() {
		return openHoursDD;
	}

	public WebElement getCloseHoursDD() {
		return closeHoursDD;
	}

	public WebElement getOpenDays() {
		return openDays;
	}

	public WebElement getChooseFileBtn() {
		return chooseFileBtn;
	}

	public WebElement getSelectCategoryDD() {
		return selectCategoryDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	


}
