package com.OFOS.HM.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is used to Maximize window
	 * @author Rishav Singh
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * THis method is used to Minimize Window
	 * @author Rishav Singh
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until page loads
	 * @author Rishav Singh
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	/**
	 * This Method will Wait for Elements to load
	 * @author Rishav Singh
	 * @param driver
	 */
	public void waitForElementLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method is used to wait until element to be visible
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilEleToBeVisible(WebDriver driver, WebElement element, int sec )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Method will Wait Untill Alert Popup is Present
	 * @author Rishav Singh
	 * @param driver
	 * @param sec
	 */
	public void waitUntilAlertToBePresent(WebDriver driver, int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * This method is used to wait until element to be Clickable
	 * @author Rishav Singh
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilEleToBeClickable(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is to select the drop-down by using index
	 * @author Rishav Singh
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is to select the drop-down by using value
	 * @author Rishav Singh
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is to select the drop-down by using text
	 * @author Rishav Singh
	 * @param text
	 * @param element
	 */
	public void dropdown(String text, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to Drag And Drop an object from Source to Destination
	 * @author Rishav Singh
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * This Method is Used to Double Click Whereever the Pointer is
	 * @author Rishav Singh
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This Method is Used to Double Click on a Particular specified Element
	 * @author Rishav Singh
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).click().perform();
	}
	
	/**
	 * This Method is Used to Right Click Whereever the Pointer is
	 * @author Rishav Singh
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().click().perform();
	}
	
	/**
	 * This Method is Used to Right Click on a Particular specified Element
	 * @author Rishav Singh
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 */
	public void keyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * @author Rishav Singh
	 * @throws AWTException
	 */
	public void keyPressEnter() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * @author Rishav Singh
	 * @throws AWTException
	 */
	public void keyReleaseEnter() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * @author Rishav Singh
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * This Method is used to Capture the Screenshot of the execution, whenever the Script Fails
	 * @author Rishav Singh
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="./Screenshot/"+screenshotName+".png";
		File dest=new File(path);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
}
