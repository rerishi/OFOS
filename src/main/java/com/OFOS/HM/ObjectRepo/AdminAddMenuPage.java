package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddMenuPage {
	
	//Declaration
	@FindBy(xpath="//input[@name='d_name']")
	private WebElement dishNameTxtBox;
	
	@FindBy(xpath="//input[@name='about']")
	private WebElement aboutTxtBox;
	
	@FindBy(xpath="//input[@name='price']")
	private WebElement priceTxtBox;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement selectImgBtn;
	
	@FindBy(xpath="//select[@name='res_name']")
	private WebElement selectResDD;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBtn;
	
	//Initialization
	public AdminAddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getDishNameTxtBox() {
		return dishNameTxtBox;
	}

	public WebElement getAboutTxtBox() {
		return aboutTxtBox;
	}

	public WebElement getPriceTxtBox() {
		return priceTxtBox;
	}

	public WebElement getSelectImgBtn() {
		return selectImgBtn;
	}

	public WebElement getSelectResDD() {
		return selectResDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

}
