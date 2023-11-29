package com.OFOS.HM.Admin.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.AdminBaseClass;
import com.OFOS.HM.GenericUtils.ExcelUtils;
import com.OFOS.HM.GenericUtils.WebDriverUtility;
import com.OFOS.HM.ObjectRepo.AdminAddMenuPage;
import com.OFOS.HM.ObjectRepo.AdminHomePage;

@Listeners(com.OFOS.HM.GenericUtils.AdminListenerImplementationClass.class)
public class AddMenuToDashboardDishesSectionTest extends AdminBaseClass{

	@Test(groups = {"Regression","Integration"})
	public void addMenuToDashboardDishesSection() throws IOException {

		ExcelUtils elib = new ExcelUtils();
		WebDriverUtility wlib = new WebDriverUtility();

		// Get Data From Excel File
		elib.readDataFromExcel("Sheet3", 6, 1);
		elib.readDataFromExcel("Sheet3", 7, 1);

		// Record Current Dishes Number
		AdminHomePage adminHome=new AdminHomePage(driver);
		String noOfDishesBeforeAdding = adminHome.getNoOfDishesBeforeAdding().getText();

		// Click on Menu DD
		adminHome.getMenuDDTab().click();

		// Click on Add Menu
		adminHome.getAddMenuOption().click();

		// Enter All the Details
		AdminAddMenuPage adminAddMenu=new AdminAddMenuPage(driver);
		WebElement dishNameTxtBox = adminAddMenu.getDishNameTxtBox();
		dishNameTxtBox.clear();
		dishNameTxtBox.sendKeys(elib.readDataFromExcel("Sheet3", 0, 1));

		WebElement aboutTxtBox = adminAddMenu.getAboutTxtBox();
		aboutTxtBox.clear();
		aboutTxtBox.sendKeys(elib.readDataFromExcel("Sheet3", 1, 1));

		WebElement priceTxtBox = adminAddMenu.getPriceTxtBox();
		priceTxtBox.clear();
		priceTxtBox.sendKeys(elib.readDataFromExcel("Sheet3", 2, 1));

		adminAddMenu.getSelectImgBtn().sendKeys("D:\\MyEclipse\\Hunger_Mantra\\src\\test\\resources\\dish.png");

		WebElement selectRest = adminAddMenu.getSelectResDD();

		wlib.dropdown(selectRest, "266");

		adminAddMenu.getSaveBtn().click();

		// Click on Dashboard-Tab
		adminHome.getDashboardTab().click();

		// Record Current Dishes Number
		String noOfDishesAfterAdding = adminHome.getNoOfDishesAfterAdding().getText();
		System.out.println(noOfDishesBeforeAdding);
		System.out.println(noOfDishesAfterAdding);

		// Validate the Results
		Assert.assertNotEquals(noOfDishesBeforeAdding, noOfDishesAfterAdding);

	}

}
