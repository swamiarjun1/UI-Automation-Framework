package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			System.err.println("Invalid Browser Name ");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

			else {

				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}
	}

	public void goToWebsite(String url) {

		logger.info("Visiting the website: " + url);
		driver.get().get(url);
		driver.get().manage().window().maximize();
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		//WebElement element = driver.get().findElement(locator);
		
		WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		

	}
	
	public void clickOnCheckBox(By locator) {
		//WebElement element = driver.get().findElement(locator);
		
		WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		element.click();

	}


	public void clickOn(WebElement element) {

		element.click();

	}

	public void enterText(By locator, String textToEnter) {

		WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);

//		logger.info("Debug 1");
//		WebElement element=driver.get().findElement(locator);
//		logger.info("Debug 2");
//		element.sendKeys(textToEnter);
//		logger.info("Debug 3");
	}

	public void selectFromDropDown(By dropDownLocator, String textToSelect) {
//		logger.info("Finding element with locator"+dropDownLocator);
//		WebElement element=driver.get().findElement(dropDownLocator);
//		logger.info("debug"+textToSelect);
//		Select select = new Select(element);
//		logger.info("Select text"+textToSelect);
//		select.selectByVisibleText(textToSelect);

		driver.get().findElement(By.id("uniform-group_1")).click();
		driver.get().findElement(By.xpath("//option[text()='L']")).click();

	}

	public void clearText(By textBoxLocator) {
		//WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

		element.clear();

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);

	}

	public String getVisibleText(By locator) {
		WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		//WebElement element = driver.get().findElement(locator);
		return element.getText();

	}

	public String getVisibleText(WebElement element) {
		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Printing list of elements");

		System.out.println("11111******");

		List<String> visibleTextList = new ArrayList();

		for (WebElement element : elementList) {
			System.out.println("******");
			System.out.println(getVisibleText(element));

			visibleTextList.add(getVisibleText(element));
		}

		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Printing list of elements");

		System.out.println("11111******");

		for (WebElement element : elementList) {
			System.out.println("******");
			System.out.println(getVisibleText(element));
		}

		return elementList;

	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}

}
