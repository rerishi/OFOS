package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDishesPage {

	//Declaration
	@FindBy(xpath="(//div[@id='popular2']/div)[1]//input[@name='quantity']")
	private WebElement quantityTxtField1;
	
	@FindBy(xpath="(//div[@id='popular2']/div)[1]//input[@value='Add To Cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//div[@id='popular2']/div)[1]//input[@name='quantity']")
	private WebElement quantityTxtField2;
	
	@FindBy(xpath="//a[text()='Checkout']")
	private WebElement chechoutBtn;
	
	//Initialization
	public UserDishesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getQuantityTxtField1() {
		return quantityTxtField1;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getQuantityTxtField2() {
		return quantityTxtField2;
	}

	public WebElement getChechoutBtn() {
		return chechoutBtn;
	}
	
	
}
