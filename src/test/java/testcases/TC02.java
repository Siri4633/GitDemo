package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Header02;

import resources.Base;

public class TC02 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 2nd TC");
	}

	@Test(priority = 2)
	public void headerValidation() throws InterruptedException {
		driver.get(prop.getProperty("url"));

		Header02 h02 = new Header02(driver);
		h02.headerValidation();

		int count = h02.subheaderValidation().size();
		System.out.println(count);

		for (int i = 0; i < h02.subheaderValidation().size(); i++) {

			h02.subheaderValidation().get(i).sendKeys(Keys.CONTROL, Keys.ENTER);
		}
		String first = driver.getWindowHandle();
		Set<String> parent = driver.getWindowHandles();
		Iterator<String> iternate = parent.iterator();

		while (iternate.hasNext()) {
			String compare = iternate.next();

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
		log.info("Driver is closed for TC02");

	}
}
