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

import pageobjects.Footer07;

import resources.Base;

public class TC07 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 7th TC");
	}

	@Test(priority = 6)
	public void footerValidation() throws InterruptedException {
		driver.get(prop.getProperty("url"));

		Footer07 f07 = new Footer07(driver);
		f07.footerValidation();
		f07.subfooterValidation();
		
		System.out.println(f07.subfooterValidation().size());

		for (int i = 0; i < f07.subfooterValidation().size(); i++) {
			f07.subfooterValidation().get(i).sendKeys(Keys.CONTROL, Keys.ENTER);
		}

		String first = driver.getWindowHandle();
		Set<String> parent = driver.getWindowHandles();
		Iterator<String> itr = parent.iterator();

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
		log.info("Driver is closed for TC07");

	}
}
