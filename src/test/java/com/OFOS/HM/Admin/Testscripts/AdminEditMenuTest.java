package com.OFOS.HM.Admin.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.AdminBaseClass;
import com.OFOS.HM.GenericUtils.ExcelUtils;
import com.OFOS.HM.GenericUtils.WebDriverUtility;
import com.OFOS.HM.ObjectRepo.AdminAddMenuPage;
import com.OFOS.HM.ObjectRepo.AdminAllMenuPage;
import com.OFOS.HM.ObjectRepo.AdminHomePage;
import com.OFOS.HM.ObjectRepo.AdminUpdateMenuPage;

@Listeners(com.OFOS.HM.GenericUtils.AdminListenerImplementationClass.class)
public class AdminEditMenuTest extends AdminBaseClass {

	@Test(groups = {"Regression","System","Integration"})
	public void adminEditMenu() throws IOException, InterruptedException {

		ExcelUtils elib = new ExcelUtils();
		WebDriverUtility wlib = new WebDriverUtility();

		// Get Data From Excel File
		// String msgValue1 = sh.getRow(6).getCell(1).getStringCellValue();
		String msgValue2 = elib.readDataFromExcel("Sheet7", 7, 1);
//		Thread.sleep(5000);

		// Click on Menu DD
		AdminHomePage adminHome=new AdminHomePage(driver);
		adminHome.getMenuDDTab().click();

		// Click on Add Menu
		adminHome.getAddMenuOption().click();

		// Enter All the Details
		AdminAddMenuPage adminAddMenu=new AdminAddMenuPage(driver);
		WebElement dishNameTxtBox = adminAddMenu.getDishNameTxtBox();
		dishNameTxtBox.clear();
		dishNameTxtBox.sendKeys(elib.readDataFromExcel("Sheet7", 0, 1));

		//Assert.fail();
		WebElement aboutTxtBox = adminAddMenu.getAboutTxtBox();
		aboutTxtBox.clear();
		aboutTxtBox.sendKeys(elib.readDataFromExcel("Sheet7", 1, 1));

		WebElement priceTxtBox = adminAddMenu.getPriceTxtBox();
		priceTxtBox.clear();
		priceTxtBox.sendKeys(elib.readDataFromExcel("Sheet7", 2, 1));

		// File f = new File(".‪\\src\\test\\resources\\dish.png");
		// String abPath = f.getAbsolutePath();
		adminAddMenu.getSelectImgBtn().sendKeys("D:\\MyEclipse\\Hunger_Mantra\\src\\test\\resources\\dish.png");

		WebElement selectRest = adminAddMenu.getSelectResDD();

		wlib.dropdown(selectRest, "266");

		adminAddMenu.getSaveBtn().click();

		// Click on All Menu Option
		adminHome.getAllMenuOption().click();

		// Click on Edit Button
		AdminAllMenuPage adminAllM=new AdminAllMenuPage(driver);
		adminAllM.getEditActionBtn().click();

		// Enter All the Details
		AdminUpdateMenuPage adminUpdMenu=new AdminUpdateMenuPage(driver);
		WebElement dishNameTxtBox2 = adminUpdMenu.getDishNameTxtBox();
		dishNameTxtBox2.clear();
		dishNameTxtBox2.sendKeys(elib.readDataFromExcel("Sheet7", 0, 1));

		WebElement aboutTxtBox2 = adminUpdMenu.getAboutTxtBox();
		aboutTxtBox2.clear();
		aboutTxtBox2.sendKeys(elib.readDataFromExcel("Sheet7", 1, 1));

		WebElement priceTxtBox2 = adminUpdMenu.getPriceTxtBox();
		priceTxtBox2.clear();
		priceTxtBox2.sendKeys(elib.readDataFromExcel("Sheet7", 2, 1));

		adminUpdMenu.getChooseFileBtn().sendKeys("D:\\MyEclipse\\Hunger_Mantra\\src\\test\\resources\\dish.png");

		WebElement selectRest2 = adminUpdMenu.getSelectRestDD();

		wlib.dropdown(selectRest2, "266");

		adminUpdMenu.getSaveBtn().click();

		// Capture the Message
		String msg2 = driver.findElement(By.xpath("//strong[text()='" + msgValue2 + "']")).getText();

		// Validate the Message
		Assert.assertEquals(msg2, msgValue2);

		System.out.println("Admin is Successfully able to edit the Menu");

		// Click on Menu DD
		adminHome.getMenuDDTab().click();

		// Click on All Menu Option
		adminHome.getAllMenuOption().click();

	}

}
