package com.SwagLab.UITest.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static void getScreenshot(WebDriver driver,String fileName)
	{
		 String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+fileName+timestamp+".png");
		  
		  try {
			FileHandler.copy(temp,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readPropertiesFile(String fileName, String key) {
		// create object of Properties class
		Properties p1 = new Properties();

		// read data from file we need path
		File f1 = new File(System.getProperty("user.dir") + "//ConfigData//" + fileName + ".properties");

		// read a file in stream: FileInputStream
		FileInputStream fs;
		try {
			fs = new FileInputStream(f1);
			// load the file
			p1.load(fs);
		} catch (FileNotFoundException e) {

			System.out.println("File path is wrong!");
		} catch (IOException e) {

			System.out.println("Properties file not loaded!");
		}

		return p1.getProperty(key);
	}

	public static void closeAllWindows(WebDriver driver, String parentId, List<String> allHandles) {
		for (String windowId : allHandles) {
			if (!windowId.equals(parentId)) {
				driver.switchTo().window(windowId).close();
			}
		}
	}

	// utility
	public static boolean switchToRightWindow(String expwindowTitle, List<String> allHandles, WebDriver driver) {

		for (String windowId : allHandles) {

			// get the title of that window after switch
			String actTitle = driver.switchTo().window(windowId).getTitle();
			if (actTitle.contains(expwindowTitle)) {
				System.out.println("Found right window.....");
				return true;
			}

		}
		return false;
	}

	public static WebDriver switchToParentWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
		return driver;
	}

	public static void selectBasedDropdown(WebElement ele, String value) {
		Select dd = new Select(ele);
		System.out.println("Is dropdown support multipleSelection: " + dd.isMultiple());

		List<WebElement> allOptions = dd.getOptions();
		System.out.println("Total options are: " + allOptions.size());

		for (WebElement i : allOptions) {
			System.out.println(i.getText());
			if (i.getText().contains(value)) {
				i.click();
				break;
			}
		}

	}

	// scroll

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scrolldown
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scrollup
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void scrollUptoElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

//explicitWait
	public static WebElement waitForElementPresence(WebDriver driver, By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}

	public static WebElement waitForElementVisibility(WebDriver driver, By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}

	public static WebElement waitForElementToClick(WebDriver driver, By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.elementToBeClickable(loc));
	}

	public static boolean waitForUrlContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public static boolean waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.titleContains(title));
	}

}
