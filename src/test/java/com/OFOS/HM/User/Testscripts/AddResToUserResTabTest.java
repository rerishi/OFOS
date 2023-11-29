
package com.OFOS.HM.User.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.ExcelUtils;
import com.OFOS.HM.GenericUtils.FileUtils;
import com.OFOS.HM.GenericUtils.WebDriverUtility;
import com.OFOS.HM.ObjectRepo.AdminAddRestaurantPage;
import com.OFOS.HM.ObjectRepo.AdminHomePage;
import com.OFOS.HM.ObjectRepo.AdminLoginPage;
import com.OFOS.HM.ObjectRepo.UserHomePage;
import com.OFOS.HM.ObjectRepo.UserLoginPage;
import com.OFOS.HM.ObjectRepo.UserRestaurantPage;

public class AddResToUserResTabTest {

	@Test(groups = {"Regression","System"})
	public void addResToUserResTab() throws IOException, InterruptedException {

		ExcelUtils elib = new ExcelUtils();
		FileUtils flib = new FileUtils();
		WebDriverUtility wlib = new WebDriverUtility();

		// Get the Data from the Properties File
		String URL = flib.readDataFromPropertyFile("adminurl");
		String USERNAME = flib.readDataFromPropertyFile("adminusername");
		String PASSWORD = flib.readDataFromPropertyFile("adminpassword");

		// Get Data From Excel File
		String resName = elib.readDataFromExcel("Sheet2", 0, 1);
		String resEmail = elib.readDataFromExcel("Sheet2", 1, 1);
		String resPhone = elib.readDataFromExcel("Sheet2", 2, 1);
		String resURL = elib.readDataFromExcel("Sheet2", 3, 1);
		String openHours = elib.readDataFromExcel("Sheet2", 4, 1);
		String closeHours = elib.readDataFromExcel("Sheet2", 5, 1);
		String openedDays = elib.readDataFromExcel("Sheet2", 6, 1);
		String category = elib.readDataFromExcel("Sheet2", 7, 1);

		WebDriver driver = new ChromeDriver();
        wlib.maximizeWindow(driver);
		wlib.waitForElementLoad(driver);
		driver.get(URL);
		Thread.sleep(5000);

		// Login as an Admin to the Application
		AdminLoginPage adLogin=new AdminLoginPage(driver);
		adLogin.loginToApp(USERNAME, PASSWORD);

		// Click on Restaurant Drop-down
		AdminHomePage adminHome=new AdminHomePage(driver);
		adminHome.getResDDTab().click();

		// Click on Add Restaurant
		adminHome.getAddResOption().click();

		// Add Restaurant Details
		AdminAddRestaurantPage adminAddRes=new AdminAddRestaurantPage(driver);
		adminAddRes.getResNameTxtField().sendKeys(resName);
		adminAddRes.getEmailTxtField().sendKeys(resEmail);
		adminAddRes.getPhoneNoTxtField().sendKeys(resPhone);
		adminAddRes.getUrlTxtField().sendKeys(resURL);

		WebElement openHoursDD =adminAddRes.getOpenHoursDD();
		wlib.dropdown(openHoursDD, openHours);

		WebElement closeHoursDD = adminAddRes.getCloseHoursDD();
		wlib.dropdown(closeHoursDD, closeHours);

		WebElement openDays = adminAddRes.getOpenDays();
		wlib.dropdown(openDays, openedDays);
		
		adminAddRes.getChooseFileBtn().sendKeys("D:\\MyEclipse\\Hunger_Mantra\\src\\test\\resources\\SagarGaire.png");

		WebElement selectCategoryDD = adminAddRes.getSelectCategoryDD();
		wlib.dropdown(selectCategoryDD, category);
		
		// driver.findElement(By.name("address")).sendKeys(address);
		adminAddRes.getSaveBtn().click();

		// Logout from Admin-Module
		adminHome.getProfilePicIcon().click();
		adminHome.getLogoutOption().click();

		// Get the Data from the Properties File
		String URL2 = flib.readDataFromPropertyFile("userurl");
		String USERNAME2 = flib.readDataFromPropertyFile("userusername");
		String PASSWORD2 = flib.readDataFromPropertyFile("userpassword");
		

		// Login as an User to the Application
		driver.switchTo().newWindow(WindowType.TAB).get(URL2);
		UserLoginPage userLogin=new UserLoginPage(driver);
		userLogin.loginToApp(USERNAME2, PASSWORD2);

		// Click on Restaurants Major Tab
		UserHomePage userHome=new UserHomePage(driver);
		userHome.getResMajorTab().click();
		
		UserRestaurantPage userRes=new UserRestaurantPage(driver);
		String newlyAddedRestaurant = userRes.getNewlyAddedRes().getText();

		Assert.assertEquals(resName,newlyAddedRestaurant);
//		if (resName.equalsIgnoreCase(newlyAddedRestaurant)) {
//			System.out.println("Newly Added Restaurant is Added Successfully and is visible to Users");
//		} else {
//			System.out.println("Newly Added Restaurant is not Visible to Users");
//		}

		userHome.userLogout();
		wlib.minimizeWindow(driver);
		driver.quit();
	}

}
