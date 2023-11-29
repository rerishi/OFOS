package com.OFOS.HM.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.OFOS.HM.ObjectRepo.UserHomePage;
import com.OFOS.HM.ObjectRepo.UserLoginPage;

public class UserBaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtils eLib=new ExcelUtils();
	public FileUtils fLib=new FileUtils();
	public JavaUtils jLib=new JavaUtils();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	public static String USERURL;
	public static String USERUSERNAME;
	public static String USERPASSWORD;
	
	
	//First remove the <Scope> tag from pom.xml file under TestNG Dependency
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws SQLException, IOException
	{
		dLib.connectDB();
		System.out.println("--Connected to DB---");
		
		USERURL=fLib.readDataFromPropertyFile("userurl");
		USERUSERNAME=fLib.readDataFromPropertyFile("userusername");
		USERPASSWORD=fLib.readDataFromPropertyFile("userpassword");
	}
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("--Invalid Browser--");
		}
		

		sdriver=driver;
		wLib.maximizeWindow(driver);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws IOException
	{
		UserLoginPage ulp=new UserLoginPage(driver);
		
		driver.get(USERURL);
		ulp.loginToApp(USERUSERNAME, USERPASSWORD);
		
		wLib.waitForElementLoad(driver);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		
		UserHomePage uhp=new UserHomePage(driver);
		uhp.userLogout();
		
		wLib.minimizeWindow(driver);
		System.out.println("Logged out of the application");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws SQLException
	{
		dLib.disconnectDB();
		System.out.println("--Disconnected From DB--");
	}
}
