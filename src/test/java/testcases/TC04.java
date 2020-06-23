package testcases;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.UserPhoto04;

import resources.Base;

public class TC04 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public Actions action;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 4th TC");
	}

	@Test(priority=4)
	public void userValidation() throws InterruptedException {
		driver.get(prop.getProperty("url"));

		UserPhoto04 up04 = new UserPhoto04(driver);
		

		up04.actionsTab();
		System.out.println(driver.getTitle());

		up04.subLinks().click();
		int count = up04.subHeader().size();
		System.out.println(count);

	}

	/*
	 * for (int i = 0; i < up04.subLinksValidation().size(); i++) {
	 * 
	 * 
	 * up04.subLinksValidation().get(i).sendKeys(Keys.CONTROL, Keys.ENTER); }
	 * 
	 * String first = driver.getWindowHandle(); Set<String> parent =
	 * driver.getWindowHandles(); Iterator<String> iternate = parent.iterator();
	 * 
	 * while (iternate.hasNext()) { String compare = iternate.next();
	 * 
	 * if (!(compare.contains(first))) { driver.switchTo().window(compare);
	 * System.out.println(driver.getTitle() + " " + compare.toString() + " " +
	 * first.toString()); driver.close(); } } driver.switchTo().window(first);
	 * System.out.println(driver.getTitle()); }
	 */

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed");
	}
}
