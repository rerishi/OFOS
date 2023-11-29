package com.OFOS.HM.Admin.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.AdminBaseClass;
import com.OFOS.HM.GenericUtils.ExcelUtils;
import com.OFOS.HM.ObjectRepo.AdminAllRestaurantPage;
import com.OFOS.HM.ObjectRepo.AdminHomePage;
import com.OFOS.HM.ObjectRepo.AdminUpdateRestaurantPage;

@Listeners(com.OFOS.HM.GenericUtils.AdminListenerImplementationClass.class)
public class AdminEditResToAllResTest extends AdminBaseClass {

	@Test(groups = {"Regression","Integration"})
	public void adminEditResToAllRes() throws InterruptedException, IOException {

		ExcelUtils elib=new ExcelUtils();

		// Get Data From Excel File
		String newResName = elib.readDataFromExcel("Sheet1", 0, 1);
		String expectesResMsg = elib.readDataFromExcel("Sheet1", 1, 1);

		// Click on Restaurant Drop-down
		AdminHomePage adminHome=new AdminHomePage(driver);
		adminHome.getResDDTab().click();

		// click on All-Restaurant Option in tyhe Drop-Down
		adminHome.getAllResOption().click();

		// Click on Edit Action Button
		AdminAllRestaurantPage adminAllRes=new AdminAllRestaurantPage(driver);
		adminAllRes.getEditActionBtn().click();

		// Change the Details
		AdminUpdateRestaurantPage adminUpdateRes=new AdminUpdateRestaurantPage(driver);
		WebElement resName = adminUpdateRes.getResName();
		resName.clear();
		resName.sendKeys(newResName);

		// Select the Image
		adminUpdateRes.getSelectImgBtn().sendKeys("D:\\MyEclipse\\Hunger_Mantra\\src\\test\\resources\\SagarGaire.png");

		// Click on Save Button
		adminUpdateRes.getSaveBtn().click();
		
		//Capture Updation Message
		String actualUpdationMsg=adminUpdateRes.getUpdationMsg().getText();
		
		if(expectesResMsg.contains(actualUpdationMsg))
		{
			System.out.println(expectesResMsg);
		}
		else
		{
			System.out.println(actualUpdationMsg);
		}

		// Click on Restaurant Drop-down
		adminHome.getResDDTab().click();

		// click on All-Restaurant Option in the Drop-Down
		adminUpdateRes.getAllResOption().click();

		// Capture Updated Restro Name
		String updatedResName = adminAllRes.getUpdatedResName().getText();

		Assert.assertEquals(newResName, updatedResName);
		
	}
}
