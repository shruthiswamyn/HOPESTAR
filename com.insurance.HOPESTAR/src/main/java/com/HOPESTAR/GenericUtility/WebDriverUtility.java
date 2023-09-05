package com.HOPESTAR.GenericUtility;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;

public class WebDriverUtility {

	/**
	 * This method maximizes the window
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method waits for webpage to load using implicit wait
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	/**
	 * This method waits for element in the webpage to become visible using explicit
	 * wait
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is for handling dropdowns by index
	 * 
	 * @author Shruthi
	 * @param index
	 * @param element
	 */
	public void dropDownUsingSelect(int index, WebElement element) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is for handling dropdowns by value
	 * 
	 * @author Shruthi
	 * @param element
	 * @param value
	 */
	public void dropDownUsingSelect(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method is for handling dropdowns by visible text
	 * 
	 * @author Shruthi
	 * @param visibleText
	 * @param element
	 */
	public void dropDownUsingSelect(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	/**
	 * This methods performs mouse hover action
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	/**
	 * This method performs drag and drop action on the webpage elements
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop);
	}

	/**
	 * This method performs double click action on the webpage elements
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method performs right click action on webpage
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void rightClickActionOnWebpage(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method performs right click action on webpage element
	 * 
	 * @param driver
	 * @param target
	 */
	public void rightClickActionOnWebelement(WebDriver driver, WebElement target) {
		Actions act = new Actions(driver);
		act.contextClick(target);
	}

	/**
	 * This method performs enter key press action using Actions class
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method performs enter key action using robot class
	 * 
	 * @author Shruthi
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKeyPressRobot(WebDriver driver) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method performs enter key release using Robot class
	 * 
	 * @author Shruthi
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKeyReleaseRobot(WebDriver driver) throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method switches frames by index
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method swicthes frame by nmame or Id
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method switches frame by web element
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This methods accepts the alert window pop up
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This methods dismisses/rejects the alert window pop up
	 * 
	 * @author Shruthi
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method switches between windows
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchBetweenWindows(WebDriver driver, String expectedTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String w : windows) {
			String title = driver.switchTo().window(w).getTitle();
			// validation
			if (title.contains(expectedTitle)) {
				System.out.println("Window found");
				break;
			}

		}
	}

	/**
	 * This method performs random scrolling action
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}

	/**
	 * This methods scrolls to required web element
	 * 
	 * @Shruthi
	 * @param driver
	 * @param element
	 */
	public void scrollUntilElementIsFound(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// first get y coordinate - location of the element
		int locOfElement = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + locOfElement + ")", element);
	}

	/**
	 * This method takes screenshot and dumps the file into screenshots folder
	 * 
	 * @author Shruthi
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destn = new File("/com.insurance.HOPESTAR/screenshots" + screenshotName + ".jpg");
		FileUtils.copyFile(src, destn);
		return destn.getAbsolutePath();
	}
}
