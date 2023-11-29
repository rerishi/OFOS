package com.OFOS.HM.User.Testscripts;

import java.io.IOException;

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
public class OrderDishesFromTwoResTest extends UserBaseClass {

	@Test(groups = {"Regression","System","Integration"})
	public void orderDishesFromTwoRes() throws IOException {

		ExcelUtils elib=new ExcelUtils();
		WebDriverUtility wlib=new WebDriverUtility();
		
		// Get Data From Excel File
		String QUANTITY1 = elib.readDataFromExcel("Sheet5", 0, 1);
		String QUANTITY2 = elib.readDataFromExcel("Sheet5", 1, 1);

		// Click on Restaurants Major Tab
		UserHomePage userHome=new UserHomePage(driver);
		userHome.getResMajorTab().click();

		// Click on 'View Menu' button of a Eataly Restaurant
		UserRestaurantPage userRes=new UserRestaurantPage(driver);
		userRes.getViewMenuBtnOfEatlyRes().click();

		// Enter the Quantity
		UserDishesPage userDish=new UserDishesPage(driver);
		WebElement qtyTxtField1 = userDish.getQuantityTxtField1();
		qtyTxtField1.clear();
		qtyTxtField1.sendKeys(QUANTITY1);

		// Click on Add to Cart Button
		userDish.getAddToCartBtn().click();

		// Click on Restaurants Major Tab
		userHome.getResMajorTab().click();

		// Click on 'View Menu' button of a Chinese_Reso Restaurant
		userRes.getViewMenuBtnOfChinese_ResoRes().click();

		// Enter the Quantity
		WebElement qtyTxtField2 = userDish.getQuantityTxtField2();
		qtyTxtField2.clear();
		qtyTxtField2.sendKeys(QUANTITY2);

		// Click on Add to Cart Button
		userDish.getAddToCartBtn().click();

		// Click on Checkout Button
		userDish.getChechoutBtn().click();

		// Click on Order Now Button
		UserCheckoutPage userCheckout=new UserCheckoutPage(driver);
		userCheckout.getOrderNowBtn().click();

		// Click OK in Confirmation Pop-up
		wlib.waitUntilAlertToBePresent(driver, 10);
		
		// Click OK in the Thank-You Message
		wlib.waitUntilAlertToBePresent(driver, 10);
	}

}
