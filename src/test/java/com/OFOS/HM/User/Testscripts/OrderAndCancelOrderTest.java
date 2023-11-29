package com.OFOS.HM.User.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.ExcelUtils;
import com.OFOS.HM.GenericUtils.UserBaseClass;
import com.OFOS.HM.GenericUtils.WebDriverUtility;
import com.OFOS.HM.ObjectRepo.UserCheckoutPage;
import com.OFOS.HM.ObjectRepo.UserDishesPage;
import com.OFOS.HM.ObjectRepo.UserHomePage;
import com.OFOS.HM.ObjectRepo.UserRestaurantPage;

@Listeners(com.OFOS.HM.GenericUtils.UserListenerImplementationClass.class)
public class OrderAndCancelOrderTest extends UserBaseClass {

	@Test(groups = {"Regression","System"})
	public void orderAndCancelOrder() throws IOException {

		ExcelUtils elib=new ExcelUtils();
		WebDriverUtility wlib=new WebDriverUtility();

		// Get Data From Excel File
		String QUANTITY = elib.readDataFromExcel("Sheet6", 0, 1);

		// Click on Restaurants Major Tab
		UserHomePage userHome=new UserHomePage(driver);
		userHome.getResMajorTab().click();

		// Click on 'View Menu' button of a Eataly Restaurant
		UserRestaurantPage userRes=new UserRestaurantPage(driver);
		userRes.getViewMenuBtnOfEatlyRes().click();

		// Enter the Quantity
		UserDishesPage userDishes=new UserDishesPage(driver);
		WebElement qtyTxtField = userDishes.getQuantityTxtField1();
		qtyTxtField.clear();
		qtyTxtField.sendKeys(QUANTITY);

		// Click on Add to Cart Button
		userDishes.getAddToCartBtn().click();

		// Click on Checkout Button
		userDishes.getChechoutBtn().click();

		// Click on Order Now Button
		UserCheckoutPage userCheckout=new UserCheckoutPage(driver);
		userCheckout.getOrderNowBtn().click();

		// Click OK in Confirmation Pop-up
		wlib.waitUntilAlertToBePresent(driver, 10);

		// Click OK in the Thank-You Message
		wlib.waitUntilAlertToBePresent(driver, 10);
		
		// click on Delete Icon
		driver.findElement(By.xpath("//tbody//td[text()=' " + QUANTITY + "']/../td[@data-column='Action']/a")).click();
		// btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();

		// driver.findElement(By.xpath("//table[@class='table table-bordered
		// table-hover']/tbody/tr[1]/td[6]")).click();
		wlib.waitUntilAlertToBePresent(driver, 10);
	}

}
