package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRestaurantPage {
	
	//Declaration
	
	@FindBy(xpath="//a[text()='Sagar Gaire']")
	private WebElement newlyAddedRes;
	
	@FindBy(xpath=
			"//div[@class='bg-gray restaurant-entry']//a[text()='Eataly']/ancestor::div[@class='col-sm-12 col-md-12 col-lg-8 text-xs-center text-sm-left']/following-sibling::div//a[contains(@href,'res_id=232')]")
	private WebElement viewMenuBtnOfEatlyRes;
	
	@FindBy(xpath = "//div[@class='bg-gray restaurant-entry']//a[text()='Chinees Reso']/ancestor::div[@class='col-sm-12 col-md-12 col-lg-8 text-xs-center text-sm-left']/following-sibling::div//a[contains(@href,'res_id=230')]")
	private WebElement viewMenuBtnOfChinese_ResoRes;
	
	//Initialization
	public UserRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getNewlyAddedRes() {
		return newlyAddedRes;
	}

	public WebElement getViewMenuBtnOfEatlyRes() {
		return viewMenuBtnOfEatlyRes;
	}

	public WebElement getViewMenuBtnOfChinese_ResoRes() {
		return viewMenuBtnOfChinese_ResoRes;
	}

	
}
