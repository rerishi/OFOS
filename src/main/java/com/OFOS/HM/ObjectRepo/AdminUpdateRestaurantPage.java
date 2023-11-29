package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUpdateRestaurantPage {
	
	//Declaration
	@FindBy(xpath="//input[@name='res_name']")
	private WebElement resName;

	@FindBy(xpath="//input[@id='lastName']")
	private WebElement selectImgBtn;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBtn ;
	
	@FindBy(xpath="//div[@class='container-fluid']//strong")
	private WebElement updationMsg;
	
	@FindBy(xpath="//a[text()='All Restaurants']")
	private WebElement allResOption;
	

	//Initialization
	public AdminUpdateRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getResName() {
		return resName;
	}

	public WebElement getSelectImgBtn() {
		return selectImgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getUpdationMsg() {
		return updationMsg;
	}
	
	public WebElement getAllResOption() {
		return allResOption;
	}
	
}
