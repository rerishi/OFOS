package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCheckoutPage {
	
	//Declaration
	@FindBy(xpath="//input[@value='Order Now']")
	private WebElement orderNowBtn;
	
	//Initialization
	public UserCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrderNowBtn() {
		return orderNowBtn;
	}
	
}
