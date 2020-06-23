package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Offers09;
import resources.Base;

public class TC09 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 9th TC");
	}

	@Test(priority = 7)
	public void offerWindows() {

		driver.get(prop.getProperty("url"));

		Offers09 tc09 = new Offers09(driver);
		tc09.offersButtuon().click();
		System.out.println("navigated to offers");

		String first = driver.getWindowHandle();
		System.out.println(first);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String compare = itr.next();
			if (!(compare.contains(first))) {
				driver.switchTo().window(compare);
				String title = driver.getTitle();
				System.out.println(title + "  " + compare);
				driver.close();
				log.info(title + "  " + compare);
			}
		}
		driver.switchTo().window(first);
		System.out.println(driver.getTitle());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed for TC09");
	}
}
