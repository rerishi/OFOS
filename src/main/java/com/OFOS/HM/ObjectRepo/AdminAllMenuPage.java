package com.OFOS.HM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAllMenuPage {
	
	//Declaration
	@FindBy(xpath="//tbody/tr[1]/td[1]/..//i[@class='fa fa-edit']")
	private WebElement editActionBtn;
	
	//Initialization
	public AdminAllMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getEditActionBtn() {
		return editActionBtn;
	}
	
	

}
